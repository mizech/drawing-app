package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        createToDo.setOnClickListener {
            var title = ""
            if (important.isChecked) {
                title = "‼" + toDoDescriptor.text.toString()
            } else {
                title = toDoDescriptor.text.toString()
            }

            var prefs
                    = getSharedPreferences(getString(R.string.SHARED_PREF_NAME),
                                            Context.MODE_PRIVATE)
            var todos
                    = prefs.getStringSet(getString(R.string.TODO_STRINGS), mutableSetOf())
            todos?.add(title)

            prefs.edit().putStringSet("toDoStrings", todos).commit()

            finish()
        }
    }
}

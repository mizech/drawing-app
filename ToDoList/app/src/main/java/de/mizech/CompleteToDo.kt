package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.mizech.R
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDo : AppCompatActivity() {
    var sToDoText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)

        sToDoText = intent.getStringExtra("toDoText")

        toDoText.text = sToDoText

        complete.setOnClickListener {
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME)
                , Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS)
                , mutableSetOf())
            var editor = prefs.edit()
            todos!!.remove(sToDoText)
            editor.putStringSet(getString(R.string.TODO_STRINGS), todos)
            editor.apply()
            finish()
        }
    }
}

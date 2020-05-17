package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)

        var sToDoText = intent.getStringExtra("toDoText")

        toDoText.text = sToDoText
        Log.i("###", sToDoText)
    }
}

package com.example.androidspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var givenText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        givenText = findViewById(R.id.givenString)

        val receivedString = intent.getStringExtra("selectedOption").toString()
        givenText.text = receivedString
    }
}

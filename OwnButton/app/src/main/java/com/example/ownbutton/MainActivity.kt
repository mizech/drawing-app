package com.example.ownbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show_message.setOnClickListener {
            Toast.makeText(this, "Testing 123 ...", Toast.LENGTH_SHORT).show()
        }
    }
}
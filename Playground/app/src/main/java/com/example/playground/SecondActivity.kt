package com.example.playground

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var extras = intent.extras

        if (extras != null) {
            var name = extras.get("name")

            greeting.text = "Hello $name!"
        }

        goBack.setOnClickListener {
            var returnIntent = intent
            returnIntent.putExtra("response", "Hello, from Second Activity!")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}

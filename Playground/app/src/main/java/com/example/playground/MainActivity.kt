package com.example.playground

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val FIRST_ACTIVITY_CODE = 1
        private const val SECOND_ACTIVITY_CODE = 2
        const val NAME = "name"
    }

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToFirst.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_CODE)
        }

        goToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_CODE)

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FIRST_ACTIVITY_CODE) {
                message.setText("First Activity Result Success!")
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("Cancelled", "Activity cancelled.")
            } else if (requestCode == SECOND_ACTIVITY_CODE) {
                if (data != null) {
                    val msg = data.getStringExtra("msg")
                    message.setText(msg)
                }
            }
        }
    }
}

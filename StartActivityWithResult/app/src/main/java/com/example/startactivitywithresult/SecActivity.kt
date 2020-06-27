package com.example.startactivitywithresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sec.*

class SecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        submit.setOnClickListener {
            val intent = Intent()
            intent.putExtra("messageSubmitted",
                messageInput.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}

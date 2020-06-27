package com.example.playground

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button2.setOnClickListener {
            val intent = Intent()
            var str = nameText.text.toString()
            intent.putExtra("msg", str)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}

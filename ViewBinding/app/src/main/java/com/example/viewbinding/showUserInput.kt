package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_show_user_input.*

class showUserInput : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_user_input)

        val sUserInput = intent.getStringExtra("sUserInput")
        showInput.text = sUserInput

        returnToPrevious.setOnClickListener {
            finish()
        }
    }
}

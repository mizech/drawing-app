package com.example.intentanimation

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            startActivity(Intent(this@MainActivity, Login::class.java))
            Animatoo.animateSpin(this@MainActivity)
        }

        signup.setOnClickListener {
            startActivity(Intent(this@MainActivity, Signup::class.java))
            Animatoo.animateSpin(this@MainActivity)
        }
    }
}

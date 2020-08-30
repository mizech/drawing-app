package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navbar.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.topItem -> {
                    Toast.makeText(applicationContext, "Top Item", Toast.LENGTH_SHORT).show()
                }
                R.id.middleItem -> {
                    Toast.makeText(applicationContext, "Middle Item", Toast.LENGTH_SHORT).show()
                }
                R.id.bottomItem -> {
                    Toast.makeText(applicationContext, "Bottom Item", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(applicationContext, "DEFAULT", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

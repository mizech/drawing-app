package com.example.playground

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import android.widget.*
import com.example.playground.R.array

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scroller?.movementMethod = ScrollingMovementMethod()

        val spinner = spinner as Spinner
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.numbers, android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val text = parent?.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "Num: $text",
                    Toast.LENGTH_LONG).show()
            }
        }

        goTo.setOnClickListener {
            Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

}

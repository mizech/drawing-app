package com.example.weightonmars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val MARS_GRAVITY = 0.38
    val VENUS_GRAVITY = 0.91
    val JUPITER_GRAVITY = 2.34
    var chosenGravity = MARS_GRAVITY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        marsBox.isChecked = true

        weightInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length > 0) {
                    marsBox.visibility = View.VISIBLE
                    venusBox.visibility = View.VISIBLE
                    jupiterBox.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        showWeight.setOnClickListener {
            var weight = weightInput.text

            var weightOnMars = calculateWeight(weight.toString().toDouble())
            resultText.text = "%.2f".format(weightOnMars) + " kg"
        }

        marsBox.setOnClickListener(this)
        venusBox.setOnClickListener(this)
        jupiterBox.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v as CheckBox

        if (v.isChecked) {
            when (v.id) {
                R.id.marsBox -> chosenGravity = MARS_GRAVITY
                R.id.venusBox -> chosenGravity = VENUS_GRAVITY
                R.id.jupiterBox -> chosenGravity = JUPITER_GRAVITY
            }
        }
    }

    fun calculateWeight(usesWeight: Double): Double {
        return usesWeight * chosenGravity
    }
}

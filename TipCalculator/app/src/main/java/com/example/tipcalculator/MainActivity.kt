package com.example.tipcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        total.visibility = View.INVISIBLE

       calculate.setOnClickListener {
           val dAmount = bill.text.toString().toDouble()
           val iPercentage = percentage.text.toString().toInt()

           val dTotal = dAmount + ((iPercentage * dAmount) / 100)
           val totalFormatted = "%.2f".format(dTotal)

           total.setText("Bill plus tip is $totalFormatted Euro")
           total.visibility = View.VISIBLE
       }
   }
}

package com.example.pocketcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var lastNumeric = false
    var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onPress(view: View) {
        var btn: Button = view as Button
        display.append(btn.text)
        lastNumeric = true

        display.text.contains("1")
    }

    fun onClear(view: View) {
        display.setText("")
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            display.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var value = display.text.toString()
            var prefix = ""

            try {
                if (value.startsWith("-")) {
                    prefix = "-"
                    value = value.substring(1)
                }

                if (value.contains("-")) {
                    val segments = value.split("-")
                    var one = segments[0].toFloat()
                    var two = segments[1].toFloat()

                    if (!prefix.isEmpty()) {
                        one *= -1
                    }

                    display.setText((one - two).toString())
                } else if (value.contains("+")) {
                    if (value.startsWith("-")) {
                        prefix = "-"
                        value = value.substring(1)
                    }

                    val segments = value.split("+")
                    var one = segments[0].toFloat()
                    var two = segments[1].toFloat()

                    if (!prefix.isEmpty()) {
                        one *= -1
                    }

                    display.setText((one + two).toString())
                } else if (value.contains("*")) {
                    if (value.startsWith("-")) {
                        prefix = "-"
                        value = value.substring(1)
                    }

                    val segments = value.split("*")
                    var one = segments[0].toFloat()
                    var two = segments[1].toFloat()

                    if (!prefix.isEmpty()) {
                        one *= -1
                    }

                    display.setText((one * two).toString())
                } else {
                    if (value.startsWith("-")) {
                        prefix = "-"
                        value = value.substring(1)
                    }

                    val segments = value.split("/")
                    var one = segments[0].toFloat()
                    var two = segments[1].toFloat()

                    if (!prefix.isEmpty()) {
                        one *= -1
                    }

                    display.setText((one / two).toString())
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(display.text.toString())) {
            display.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        } else if (display.text.isEmpty()) {
            var textView = view as TextView

            if (textView.text == "-") {
                display.append((view as Button).text)
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("+")
                    || value.contains("-")
        }
    }
}

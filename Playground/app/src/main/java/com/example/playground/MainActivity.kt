package com.example.playground

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_dialog.*

class MainActivity : AppCompatActivity() {
    var inputReceived: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReceived.text = inputReceived ?: ""

        showDialog.setOnClickListener {
            val dialog = Dialog(this)

            dialog.setContentView(R.layout.my_dialog)

            dialog.findViewById<Button>(R.id.closeDialog)
                    .setOnClickListener {
                dialog.dismiss()
            }

            dialog.findViewById<Button>(R.id.writeText)
                    .setOnClickListener {
                inputReceived = inputText.text?.toString()
            }

            dialog.show()
        }
    }
}

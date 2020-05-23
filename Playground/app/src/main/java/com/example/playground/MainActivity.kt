package com.example.playground

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goTo.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "Testing 1234 ...", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            Log.i("ooo", "OKAY!")
        } else {
            Log.i("ooo", "Fail!")
        }

        if (requestCode == 1) {
            Log.i("ooo", resultCode.toString())

            var responseText = data!!.extras!!.get("response")

            Toast.makeText(this, "Response: $responseText", Toast.LENGTH_LONG)
                .show();
        }
    }
}

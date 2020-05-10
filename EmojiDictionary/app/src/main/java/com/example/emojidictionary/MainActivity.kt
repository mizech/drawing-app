package com.example.emojidictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit  var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: ArrayList<String> = ArrayList()
        items.add("😀")
        items.add("😃")
        items.add("😕")
        items.add("💀")
        items.add("☠️")
        items.add("🐱")
        items.add("🐭")
        items.add("🐬")
        items.add("🐊")
        items.add("🐓")
        items.add("🌞")
        items.add("🌺")
        items.add("🍎")
        items.add("🍌")
        items.add("☘️")

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = RecyclerAdapter(items, this)
    }
}

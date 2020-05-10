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
        items.add("One")
        items.add("Second Item")
        items.add("Third Item!")
        items.add("Fourth Item!")
        items.add("6 Item!")
        items.add("7 Item!")
        items.add("Eight Item!")
        items.add("9 Item!")
        items.add("10 Item!")

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = RecyclerAdapter(items, this)
    }
}

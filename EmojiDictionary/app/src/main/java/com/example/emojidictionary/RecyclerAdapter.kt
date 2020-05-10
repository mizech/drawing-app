package com.example.emojidictionary

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(val items: ArrayList<String>, val context: Context):
    RecyclerView.Adapter<RecyclerAdapter.TextHolder>() {

    inner class TextHolder(view: View): RecyclerView.ViewHolder(view) {
        var emoji = view.emojiTextView

        init {
            view.setOnClickListener {
                Toast.makeText(context, "Testing 123 ...", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        return TextHolder(LayoutInflater.from(context)
                .inflate(R.layout.recycler_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TextHolder, position: Int) {
        holder?.emoji.text = "😀 " + items[position]
    }
}
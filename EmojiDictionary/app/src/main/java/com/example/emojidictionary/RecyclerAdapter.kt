package com.example.emojidictionary

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(val items: ArrayList<String>, val context: Context):
    RecyclerView.Adapter<RecyclerAdapter.TextHolder>() {

    inner class TextHolder(view: View): RecyclerView.ViewHolder(view) {
        var emoji = view.emojiTextView

        init {
            view.setOnClickListener {
                val emojiChar = it.emojiTextView.text

                val detailIntent = Intent(view.context, DetailsActivity::class.java)
                detailIntent.putExtra("emoji", emojiChar)
                startActivity(view.context, detailIntent, null)
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
        holder?.emoji.text = items[position]
    }
}
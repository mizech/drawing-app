package com.example.todolist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import de.mizech.R
import kotlinx.android.synthetic.main.todo_item.view.*

class ItemsAdapter(val items: MutableSet<String>, val context: Context):
    RecyclerView.Adapter<ItemsAdapter.ItemHolder>() {

    inner class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        val toDoTextView = view.todo_item

        init {
            toDoTextView.setOnClickListener {
                val intent = Intent(view.context, CompleteToDo::class.java)
                intent.putExtra("toDoText", toDoTextView.text.toString())
                startActivity(view.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = ItemHolder(LayoutInflater.from(context)
            .inflate(R.layout.todo_item, parent, false))
        return itemHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder?.toDoTextView.text = items.elementAt(position)
    }
}
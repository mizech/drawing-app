package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_item.view.*

class ItemsAdapter(val items: MutableSet<String>, val context: Context):
    RecyclerView.Adapter<ItemsAdapter.ItemHolder>() {

    inner class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        val toDoTextView = view.todo_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(context)
                            .inflate(R.layout.todo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder?.toDoTextView.text = items.elementAt(position)
    }
}
package com.example.todolist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: ItemsAdapter
    var prefs: SharedPreferences? = null
    var set: MutableSet<String>? = null
    var editor: SharedPreferences.Editor? = null

    fun setRecyclerView() {
        set = prefs?.getStringSet(getString(R.string.TODO_STRINGS), mutableSetOf())

        layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        adapter = ItemsAdapter(set!!, this)
        recycler_view.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
        editor = prefs?.edit()
        editor?.clear()?.commit()
        setRecyclerView()

        fab.setOnClickListener { view ->
            val intent = Intent(applicationContext, CreateToDo::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        setRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_delete) {
            editor?.clear()?.commit()
            setRecyclerView()
            recreate()

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}

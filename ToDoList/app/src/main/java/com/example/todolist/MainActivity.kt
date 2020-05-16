package com.example.todolist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.TokenWatcher
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var prefs
                = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
        val set
                = prefs.getStringSet(getString(R.string.TODO_STRINGS), mutableSetOf())

        set!!.add("Test 123")
//        set!!.add("Test 4")
//        set!!.add("Test 5")
//        set!!.add("Test 6")
//        set!!.add("Test 635")
//        set!!.add("Test 63")
//        set!!.add("Test 6z")
//        set!!.add("Test 6y")
//        set!!.add("Test 6x0")
//        set!!.add("Test 6x1")
//        set!!.add("Test 6x2")
//        set!!.add("Test 6x3")
//        set!!.add("Test 6x2")
//        set!!.add("Test 6x2x")
//        set!!.add("Test 6x2y")
//        set!!.add("Test 6x2z")

        Toast.makeText(this, set!!.size.toString(), Toast.LENGTH_LONG).show()

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ItemsAdapter(set!!, this)

        fab.setOnClickListener { view ->
            val intent = Intent(applicationContext, CreateToDo::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

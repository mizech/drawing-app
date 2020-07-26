package com.example.codeeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Browser : AppCompatActivity() {
    lateinit var browser: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        browser = findViewById(R.id.browser)

        val content = intent.getStringExtra("content")
        browser.loadData(content, "text/html; charset=utf-8", null)
    }
}

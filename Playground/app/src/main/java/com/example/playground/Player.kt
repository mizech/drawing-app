package com.example.playground

class Player(val name: String, var level: Int = 1,
             var lives: Int = 3, var score: Int = 0) {
    fun show() {
        var inventory = ArrayList<String>()
        inventory.add("Test 1")

        println("""
            name: $name
            lives: $level
            level: $score
            score: $score
        """)
    }
}
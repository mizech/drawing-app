package com.example.playground

import java.util.*

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object: Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            if (o1 ?: 0 > o2 ?: 0) {
                return 1
            } else if (o1 ?: 0 < o2 ?: 0) {
                return -1
            } else {
                return 0
            }
        }
    })
    return arrayList
}
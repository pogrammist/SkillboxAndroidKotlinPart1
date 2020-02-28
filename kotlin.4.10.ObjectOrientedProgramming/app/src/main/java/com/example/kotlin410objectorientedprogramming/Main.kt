package com.example.kotlin410objectorientedprogramming

import kotlin.random.Random

fun main() {
    while (true) {
        print("Введите количество воинов: ")
        val teamCount = readLine()?.toIntOrNull() ?: continue
        val battle = Battle(teamCount)
    }
}
package com.example.kotlin410objectorientedprogramming

fun main() {
    while (true) {
        print("Введите количество воинов: ")
        val teamCount = readLine()?.toIntOrNull() ?: continue
        val battle = Battle(teamCount)
        battle.startBattle()
    }
}
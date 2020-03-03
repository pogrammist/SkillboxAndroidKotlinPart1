package com.example.kotlin410objectorientedprogramming

interface Warrior {
    val isKilled: Boolean
    val chanceOfDodging: Int
    fun attack(warrior: Warrior)
    fun takeDamage(damage: Int)
    fun getCurrentHealth(): Int
}
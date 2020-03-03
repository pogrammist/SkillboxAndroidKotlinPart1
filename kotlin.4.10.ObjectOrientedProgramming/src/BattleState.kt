package com.example.kotlin410objectorientedprogramming

sealed class BattleState(private val state: String) {
    data class CurrentState(val state: String) : BattleState(state)
    data class FirstTeamWin(val state: String) : BattleState(state)
    data class SecondTeamWin(val state: String) : BattleState(state)
    data class Debuxar(val state: String) : BattleState(state)

    fun printInConsole() {
        println(state)
    }
}

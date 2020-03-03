package com.example.kotlin410objectorientedprogramming

import com.example.kotlin410objectorientedprogramming.BattleState.*
import kotlin.random.Random

class Battle(private val countOfWarrior: Int) {
    private var arrayTeams = Array(2) { Team(countOfWarrior) }
    private var battleFinished: Boolean = false
    private var turnFirst: Int = Random.nextInt(2)

    fun startBattle() {
        if (turnFirst == 1) {
            arrayTeams.reverse()
        }
        println("Начало битвы")
        while (!battleFinished) {
            when (val battleState = getState()) {
                is CurrentState -> {
                    shuffled()
                    battleState.printInConsole()
                }
                is FirstTeamWin -> {
                    battleFinished = true
                    battleState.printInConsole()
                }
                is SecondTeamWin -> {
                    battleFinished = true
                    battleState.printInConsole()
                }
                is Debuxar -> {
                    battleFinished = true
                    battleState.printInConsole()
                }
            }
        }
    }

    private fun getState(): BattleState {
        val firstTeamHealth = arrayTeams[0].getWarriorList()
            .sumBy { it.getCurrentHealth() }
        val secondTeamHealth = arrayTeams[1].getWarriorList()
            .sumBy { it.getCurrentHealth() }
        return if (firstTeamHealth == 0) {
            SecondTeamWin("Победила вторая команда")
        } else if (secondTeamHealth == 0) {
            FirstTeamWin("Победила первая команда")
        } else if (firstTeamHealth == 0 && secondTeamHealth == 0) {
            Debuxar("Ничья")
        } else {
            CurrentState("Progress(commandAHealth=$firstTeamHealth, commandBHealth=$secondTeamHealth)")
        }
    }

    private fun shuffled() {
//        println("Совершаем ход")
        arrayTeams.forEach { it.shuffleWarriorList() }
        arrayTeams.forEach { team ->
            team.getWarriorList().forEach { warrior ->
                if (!warrior.isKilled) {
                    val targetWarrior: Warrior = if (team == arrayTeams[0]) {
                        arrayTeams[1].getWarriorList().filter { !warrior.isKilled }.random()
                    } else {
                        arrayTeams[0].getWarriorList().filter { !warrior.isKilled }.random()
                    }
                    warrior.attack(targetWarrior)
                }
            }
        }
    }
}
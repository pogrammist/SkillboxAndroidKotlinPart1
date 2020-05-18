package com.example.kotlin410objectorientedprogramming

import com.example.kotlin410objectorientedprogramming.BattleState.*
import kotlin.random.Random

class Battle(private val countOfWarrior: Int) {
    private var arrayTeams = Array(2) { Team(countOfWarrior) }
    private var battleFinished: Boolean = false
    private var turnFirst: Int = Random.nextInt(2)
    private val firstTeamHealth: Int
        get() = arrayTeams[0].getWarriorList().sumBy { it.getCurrentHealth() }
    private val secondTeamHealth: Int
        get() = arrayTeams[1].getWarriorList().sumBy { it.getCurrentHealth() }

    fun startBattle() {
        if (turnFirst == 1) {
            arrayTeams.reverse()
        }
        println("Начало битвы")
        while (!battleFinished) {
            shuffled()
            when (val battleState = getState()) {
                is CurrentState -> {
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
        return if (firstTeamHealth == 0) {
            SecondTeamWin("Победила вторая команда")
        } else if (secondTeamHealth == 0) {
            FirstTeamWin("Победила первая команда")
        } else if (firstTeamHealth != 0 && secondTeamHealth != 0) {
            CurrentState("Progress(commandAHealth=$firstTeamHealth, commandBHealth=$secondTeamHealth)")
        } else {
            Debuxar("Ничья")
        }
    }

    private fun shuffled() {
        println("Совершаем ход")
        arrayTeams.forEach { it.shuffleWarriorList() }
        arrayTeams.forEach { team ->
            team.getWarriorList().forEach { warrior ->
                if (!warrior.isKilled) {
                    val targetWarrior: Warrior? = if (team == arrayTeams[0]) {
                        arrayTeams[1].getWarriorList().lastOrNull { !it.isKilled }
                    } else {
                        arrayTeams[0].getWarriorList().lastOrNull { !it.isKilled }
                    }
                    if (targetWarrior != null) {
                        warrior.attack(targetWarrior)
                    }
                }
            }
        }
    }
}
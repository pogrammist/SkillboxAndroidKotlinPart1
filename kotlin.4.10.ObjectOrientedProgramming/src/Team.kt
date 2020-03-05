package com.example.kotlin410objectorientedprogramming

import com.example.kotlin410objectorientedprogramming.Weapons.arm
import com.example.kotlin410objectorientedprogramming.Weapons.catapult
import com.example.kotlin410objectorientedprogramming.Weapons.crossbow
import com.example.kotlin410objectorientedprogramming.Weapons.grenadeLauncher
import com.example.kotlin410objectorientedprogramming.Weapons.machineGun
import kotlin.random.Random

class Team(private val countOfWarrior: Int) {
    private var warriorList: MutableList<Warrior> = mutableListOf()

    init {
        makeTeam(countOfWarrior)
    }

    private fun makeTeam(countOfWarrior: Int) {
        while (warriorList.size < countOfWarrior) {
            when (Random.nextInt(100)) {
                in 1..20 -> warriorList.add(
                    Shooter(
                        maxHealth = 100,
                        chanceOfDodging = 90,
                        accuracy = 90,
                        weapon = arm,
                        isKilled = false
                    )
                )
                in 21..40 -> warriorList.add(
                    Shooter(
                        maxHealth = 100,
                        chanceOfDodging = 50,
                        accuracy = 90,
                        weapon = crossbow,
                        isKilled = false
                    )
                )
                in 41..60 -> warriorList.add(
                    Gunner(
                        maxHealth = 500,
                        chanceOfDodging = 10,
                        accuracy = 20,
                        weapon = catapult,
                        isKilled = false
                    )
                )
                in 61..80 -> warriorList.add(
                    Juggernaut(
                        maxHealth = 1500,
                        chanceOfDodging = 30,
                        accuracy = 60,
                        weapon = machineGun,
                        isKilled = false
                    )
                )
                in 81..100 -> warriorList.add(
                    Juggernaut(
                        maxHealth = 1500,
                        chanceOfDodging = 30,
                        accuracy = 30,
                        weapon = grenadeLauncher,
                        isKilled = false
                    )
                )
            }
        }
    }

    fun shuffleWarriorList() {
        warriorList.shuffle()
    }

    fun getWarriorList(): MutableList<Warrior> {
        return warriorList
    }
}
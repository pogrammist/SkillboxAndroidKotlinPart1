package com.example.kotlin410objectorientedprogramming

class Juggernaut(
    override var isKilled: Boolean,
    maxHealth: Int,
    chanceOfDodging: Int,
    accuracy: Int,
    weapon: AbstractWeapon
) : AbstractWarrior(maxHealth, chanceOfDodging, accuracy, weapon) {
}
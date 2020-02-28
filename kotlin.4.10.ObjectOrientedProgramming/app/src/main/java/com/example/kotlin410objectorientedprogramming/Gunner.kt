package com.example.kotlin410objectorientedprogramming

class Gunner(
    override var isKilled: Boolean,
    maxHealth: Int,
    chanceOfDodging: Int,
    accuracy: Int,
    weapon: AbstractWeapon
) : AbstractWarrior(maxHealth, chanceOfDodging, accuracy, weapon) {
}
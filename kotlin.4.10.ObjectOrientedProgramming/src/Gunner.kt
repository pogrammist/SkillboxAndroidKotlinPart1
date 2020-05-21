package com.example.kotlin410objectorientedprogramming

class Gunner(
    health: Int,
    chanceOfDodging: Int,
    accuracy: Int,
    weapon: AbstractWeapon
) : AbstractWarrior(health, chanceOfDodging, accuracy, weapon) {
    override fun toString(): String {
        return "Gunner[${super.toString()}]"
    }
}
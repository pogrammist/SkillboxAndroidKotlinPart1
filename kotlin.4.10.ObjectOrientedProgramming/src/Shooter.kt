package com.example.kotlin410objectorientedprogramming

class Shooter(
    health: Int,
    chanceOfDodging: Int,
    accuracy: Int,
    weapon: AbstractWeapon
) : AbstractWarrior(health, chanceOfDodging, accuracy, weapon) {
    override fun toString(): String {
        return "Shooter[${super.toString()}]"
    }
}
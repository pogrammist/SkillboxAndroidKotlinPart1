package com.example.kotlin410objectorientedprogramming

class Juggernaut(
    health: Int,
    chanceOfDodging: Int,
    accuracy: Int,
    weapon: AbstractWeapon
) : AbstractWarrior(health, chanceOfDodging, accuracy, weapon) {
    override fun toString(): String {
        return "Juggernaut[${super.toString()}]"
    }
}
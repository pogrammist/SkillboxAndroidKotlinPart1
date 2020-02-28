package com.example.kotlin410objectorientedprogramming

abstract class AbstractWarrior(
    maxHealth: Int,
    override val chanceOfDodging: Int,
    val accuracy: Int,
    private val weapon: AbstractWeapon
) : Warrior {
    private var currentHealth: Int
    override var isKilled: Boolean = false

    init {
        currentHealth = maxHealth
    }

    override fun attack(warrior: Warrior) {
        val lowAmmo = weapon.getShell().isEmpty()
        if (lowAmmo) {
            weapon.reload()
        } else {
            val damage = weapon.getShell().sumBy { it.getDamage() }
            warrior.takeDamage(damage)
        }
    }

    override fun takeDamage(damage: Int) {
        currentHealth = if (currentHealth - damage < 0) 0 else currentHealth - damage
        isKilled = currentHealth == 0
    }

    override fun getCurrentHealth(): Int {
        return currentHealth
    }
}
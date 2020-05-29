package com.example.kotlin410objectorientedprogramming

abstract class AbstractWarrior(
    var health: Int,
    override val chanceOfDodging: Int,
    val accuracy: Int,
    private val weapon: AbstractWeapon
) : Warrior {
    override val isKilled: Boolean
        get() = health == 0

    init {
        println("Рекрутирован $this")
        weapon.reload()
    }

    override fun attack(warrior: Warrior) {
        try {
            val damage = weapon.getShell().sumBy { it.getDamage() }
            println("$this атакует $warrior")
            warrior.takeDamage(damage)
        } catch (ex: NoAmmoException) {
            println(ex.message)
            println("Требуется перезарядка")
            weapon.reload()
        }
    }

    override fun takeDamage(damage: Int) {
        health = if (health - damage < 0) 0 else health - damage
        if (isKilled) {
            println("$this понес урон $damage и погиб")
        } else {
            println("$this понес урон $damage")
        }
    }

    override fun getCurrentHealth(): Int {
        return health
    }

    override fun toString(): String {
        return health.toString()
    }
}
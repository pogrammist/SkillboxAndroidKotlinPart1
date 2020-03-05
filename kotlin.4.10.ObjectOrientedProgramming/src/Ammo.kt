package com.example.kotlin410objectorientedprogramming

import kotlin.random.Random

enum class Ammo(
    damage: Int,
    chanceOfMaxDamage: Int,
    ratioOfMaxDamage: Int
) {
    BULLET(damage = 30, chanceOfMaxDamage = 50, ratioOfMaxDamage = 25),
    GRENADE(damage = 80, chanceOfMaxDamage = 70, ratioOfMaxDamage = 50),
    ARROW(damage = 50, chanceOfMaxDamage = 30, ratioOfMaxDamage = 75),
    DART(damage = 20, chanceOfMaxDamage = 10, ratioOfMaxDamage = 75),
    CAT(damage = 100, chanceOfMaxDamage = 90, ratioOfMaxDamage = 100);

    private var currentDamage: Int

    init {
        val chance = Random.nextInt(100) > chanceOfMaxDamage
        val maxDamage = if (chance) 0 else (0..ratioOfMaxDamage).shuffled().last()
        currentDamage = damage + maxDamage
    }

    fun getDamage(): Int {
        return currentDamage
    }

    fun compareDamage(ammo: Ammo): Int {
        return currentDamage - ammo.currentDamage
    }
}

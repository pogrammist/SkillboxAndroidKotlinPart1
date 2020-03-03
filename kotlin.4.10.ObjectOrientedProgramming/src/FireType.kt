package com.example.kotlin410objectorientedprogramming

sealed class FireType(
    open val ammo: Ammo,
    open val repeat: Int
) {
    data class SingleShooting(
        override val ammo: Ammo,
        override val repeat: Int = 1
    ) :
        FireType(ammo, repeat)

    data class BurstsShooting(
        override val ammo: Ammo,
        override val repeat: Int
    ) :
        FireType(ammo, repeat)
}
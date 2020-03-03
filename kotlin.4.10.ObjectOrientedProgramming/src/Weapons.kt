package com.example.kotlin410objectorientedprogramming

import com.example.kotlin410objectorientedprogramming.Ammo.*
import com.example.kotlin410objectorientedprogramming.FireType.*

object Weapons {
    val machineGun = object :
        AbstractWeapon(
            maxAmmo = 1000,
            fireType = BurstsShooting(ammo = BULLET, repeat = 10)
        ) {
        override fun makeShell(): Ammo {
            return fireType.ammo
        }
    }
    val grenadeLauncher = object :
        AbstractWeapon(
            maxAmmo = 10,
            fireType = SingleShooting(ammo = GRENADE)
        ) {
        override fun makeShell(): Ammo {
            return fireType.ammo
        }
    }
    val crossbow = object :
        AbstractWeapon(
            maxAmmo = 1,
            fireType = SingleShooting(ammo = ARROW)
        ) {
        override fun makeShell(): Ammo {
            return fireType.ammo
        }
    }
    val arm = object :
        AbstractWeapon(
            maxAmmo = 1,
            fireType = SingleShooting(ammo = DART)
        ) {
        override fun makeShell(): Ammo {
            return fireType.ammo
        }
    }
    val catapult = object :
        AbstractWeapon(
            maxAmmo = 9999,
            fireType = BurstsShooting(ammo = CAT, repeat = 9)
        ) {
        override fun makeShell(): Ammo {
            return fireType.ammo
        }
    }

}
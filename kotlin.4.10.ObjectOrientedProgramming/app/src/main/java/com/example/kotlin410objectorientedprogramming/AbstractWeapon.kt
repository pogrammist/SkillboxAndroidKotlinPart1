package com.example.kotlin410objectorientedprogramming

abstract class AbstractWeapon(
    val maxAmmo: Int,
    val fireType: FireType
) {
    private var ammoList: MutableList<Ammo> = mutableListOf()
    private var shells: MutableList<Ammo> = mutableListOf()
    private var ammoIsEmpty: Boolean

    init {
//        println("Инициализировано оружие ${this.fireType}, магазин пуст")
        ammoIsEmpty = ammoList.isEmpty()
    }

    abstract fun makeShell(): Ammo
    fun reload() {
        for (shell in 1..maxAmmo) {
            ammoList.add(makeShell())
        }
        ammoIsEmpty = false
//        println("Заряжен ${ammoList.size} заряд")
    }

    fun getShell(): List<Ammo> {
        if (ammoList.isEmpty()) {
            ammoIsEmpty = true
        }
        var count = fireType.repeat
        while (!ammoIsEmpty && count > 0) {
            shells.add(ammoList.last())
            ammoList.removeAt(ammoList.lastIndex)
            count--
        }
        return shells
    }
}
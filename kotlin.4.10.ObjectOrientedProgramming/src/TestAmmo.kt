package com.example.kotlin410objectorientedprogramming

fun main() {
    println("Пуля нанесла урон ${Ammo.BULLET.getDamage()} единиц")
    println("Граната нанесла урон ${Ammo.GRENADE.getDamage()} единиц")
    println("Стрела нанесла урон ${Ammo.ARROW.getDamage()} единиц")
    println("Дротик нанес урон ${Ammo.DART.getDamage()} единиц")
    println("Котик нанес урон ${Ammo.CAT.getDamage()} единиц")

    val bullet = Ammo.BULLET
    val dart = Ammo.DART
    println("Пуля нанесла урон ${bullet.getDamage()} единиц")
    println("Дротик нанес урон ${dart.getDamage()} единиц")
    println("Пуля нанесла больше урона на ${bullet.compareDamage(dart)} единиц чем дротик")

    val bullet2 = Ammo.BULLET
    val dart2 = Ammo.DART
    println("Пуля нанесла урон ${bullet2.getDamage()} единиц")
    println("Дротик нанес урон ${dart2.getDamage()} единиц")
    println("Пуля нанесла больше урона на ${bullet2.compareDamage(dart2)} единиц чем дротик")

    println(Ammo.valueOf("DART"))
    Ammo.values().forEach {
        println(it)
        println(it.name)
        println(it.ordinal)
    }
}
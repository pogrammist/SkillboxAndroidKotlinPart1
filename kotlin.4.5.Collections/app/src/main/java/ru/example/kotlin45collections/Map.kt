package ru.example.kotlin79extensionsobjectsenums

fun main() {
    while (true) {
        val map: MutableMap<String, String> = mutableMapOf()
        for (item in 1..3) {
            print("Введите имя человека с номером телефона ")
            val card = readLine() ?: continue
            map[card.substringBefore(':')] = card.substringAfterLast(": ")
        }
        map.forEach { (k, v) -> println("Человек: $v. Номер телефона: $k") }
    }
}
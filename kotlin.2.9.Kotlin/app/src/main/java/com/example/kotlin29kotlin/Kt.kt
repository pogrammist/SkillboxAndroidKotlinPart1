package com.example.kotlin29kotlin

fun main() {

    while (true) {
        println("Введите число чисел: ")
        val items = readLine()?.toIntOrNull() ?: continue
        val list = makeIntList(items)
        println("Вы ввели список чисел: $list")
        println("Количество натуральных чисел в массиве: ${countOfNaturalNumbers(list)}")
        println("Количество четных чисел в массиве: ${countOfEvenNumbers(list)}")
        println("Четные числа в массиве: ${evenNumbers(list)}")
        println("Количество уникальных чисел в массиве: ${uniqueNumbers(list).count()}")
        println("Сумма чисел в массиве: ${list.sum()}")
        list.map {
            println(
                "Число $it, сумма ${list.sum()}, НОД ${greatestCommonFactor(
                    it,
                    uniqueNumbers(list).sum()
                )}"
            )
        }
    }
}

fun makeIntList(items: Int): List<Int> {
    val list: MutableList<Int> = mutableListOf()
    var items = items
    var count = list.count()
    while (items > 0) {
        println("Введите ${++count} число:")
        val number = readLine()?.toIntOrNull() ?: continue
        list.add(number)
        items--
    }
    return list
}

fun countOfNaturalNumbers(list: List<Int>): Int {
    var count = 0
    for (item in list) {
        if (item > 0) {
            count++
        }
    }
    return count
}

fun countOfEvenNumbers(list: List<Int>): Int {
    var count = 0
    list.filter { it % 2 == 0 }.map { count++ }
    return count
}


fun evenNumbers(list: List<Int>): List<Int> {
    val evenNumbers = mutableListOf<Int>()
    list.filter { it % 2 == 0 }.map { evenNumbers.add(it) }
    return evenNumbers
}

fun uniqueNumbers(list: List<Int>): MutableSet<Int> {
    val set: MutableSet<Int> = mutableSetOf()
    list.map { set += it }
    return set
}

tailrec fun greatestCommonFactor(a: Int, b: Int): Int {
    val a = a
    if (b == 0) {
        return a
    }
    return greatestCommonFactor(b, a % b)
}

package com.example.kotlin29kotlin

fun main() {

    while (true) {
        println("Введите число чисел: ")
        val listLength = readLine()?.toIntOrNull() ?: continue
        val list = makeIntList(listLength)
        println("Вы ввели список чисел: $list")
        println("Количество натуральных чисел в массиве: ${countOfNaturalNumbers(list)}")
        println("Количество четных чисел в массиве: ${countOfEvenNumbers(list)}")
        println("Четные числа в массиве: ${evenNumbers(list)}")
        println("Количество уникальных чисел в массиве: ${uniqueNumbers(list).count()}")
        val sumNumbers = list.sum()
        println("Сумма чисел в массиве: $sumNumbers")
        list.forEach {
            println(
                "Число $it, сумма $sumNumbers, НОД ${greatestCommonFactor(
                    it,
                    uniqueNumbers(list).sum()
                )}"
            )
        }
    }
}

fun makeIntList(items: Int): List<Int> {
    val list: MutableList<Int> = mutableListOf()
    for (item in 1..items) {
        println("Введите $item число:")
        val number = readLine()?.toIntOrNull() ?: continue
        list.add(number)
    }
    return list
}

fun countOfNaturalNumbers(list: List<Int>) = list.filter { it > 0 }.size

fun countOfEvenNumbers(list: List<Int>) = list.filter { it % 2 == 0 }.size

fun evenNumbers(list: List<Int>): List<Int> = list.filter { it % 2 == 0 }.map { it }

fun uniqueNumbers(list: List<Int>): MutableSet<Int> {
    val set: MutableSet<Int> = mutableSetOf()
    list.forEach { set += it }
    return set
}

tailrec fun greatestCommonFactor(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return greatestCommonFactor(b, a % b)
}

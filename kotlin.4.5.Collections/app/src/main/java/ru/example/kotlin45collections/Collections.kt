package ru.example.kotlin79extensionsobjectsenums

fun main() {
    while (true) {
        println("Введите число: ")
        val listLength = readLine()?.toIntOrNull() ?: continue
        val list = makePhoneNumberList(listLength)
        println("Вы ввели список телефонных номеров: $list")

        if (countOfRussianNumbers(list).isNotEmpty()) {
            println("Российские телефонные номера: ${countOfRussianNumbers(list)}")
        } else {
            "Российские телефонные номера отсутствуют"
        }

        println(
            "Уникальных номеров: ${setOfNumbers(list)}"
        )
        println("Сумма длин всех номеров: ${sumOfNumbers(list)}")
    }
}

fun makePhoneNumberList(items: Int): List<String> {
    val list: MutableList<String> = mutableListOf()
    for (item in 1..items) {
        println("Введите $item телефонный номер (+01234567890):")
        val number = readLine() ?: continue
        val matchResult = Regex("""\+\d{11}""").find(number) ?: continue
        list.add(matchResult.value)
    }
    return list
}

fun countOfRussianNumbers(list: List<String>) = list.filter { it.startsWith("+7") }

fun setOfNumbers(list: List<String>) = list.toSet().size

fun sumOfNumbers(list: List<String>) = list.sumBy { it.substring(1).length }

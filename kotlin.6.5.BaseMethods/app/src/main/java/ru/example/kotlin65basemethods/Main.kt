package ru.example.kotlin65basemethods

fun main() {
    val sam: Person = Person(170, 70, "Sam")
    sam.buyPet()
    val sammy: Person = Person(170, 70, "Sam")
    sammy.buyPet()
    sammy.buyPet()
    val tom: Person = Person(170, 70, "Tom")
    tom.buyPet()
    tom.buyPet()
    tom.buyPet()
    val persons: MutableSet<Person> = mutableSetOf()
    persons.addAll(listOf(sam, sammy, tom))
    println("persons count: ${persons.size}")
    persons.forEach { println(it.toString()) }
}
package ru.example.kotlin65basemethods

import kotlin.random.Random

class Person(
    val height: Int,
    val weight: Int,
    val name: String
) {
    val pets: HashSet<Animal> = hashSetOf()

    fun buyPet() {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z')
        val randomString = (1..5)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
        val pet = Animal(Random.nextInt(0, 100), Random.nextInt(0, 50), randomString)
        pets.add(pet)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (pets != other.pets) return false

        return true
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + pets.hashCode()
        return result
    }

    override fun toString(): String {
        return "Person(height=$height, weight=$weight, name='$name', pets=$pets)"
    }
}
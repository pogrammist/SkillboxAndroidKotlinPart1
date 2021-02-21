package ru.example.kotlin25kotlinbasics

fun main() {
    foo()
}

fun foo() {
    var age: Int = 23
    println(age)
    age = 56
    println(age)

    val firstName: String = "Василий"
    val lastName: String = "Пупкин"

    var height: Int = 160
    var weight: Float = 50F

    val isChild: Boolean = height < 150 || weight < 40F
    var isChildren: Boolean = height < 150 || weight < 40F
    println(isChild)
    println(isChildren)

    var info: String = "name: $firstName, lastname: $lastName, " +
            "height: $height, weight: $weight, isChild: $isChild, isChildren: $isChildren, ${height < 150 || weight < 40F}"
    println("Summary info: $info")
    val info2: String = "name: $firstName, lastname: $lastName, " +
            "height: $height, weight: $weight, isChild: $isChild, isChildren: $isChildren, ${height < 150 || weight < 40F}"
    println("Summary info: $info2")

    height = 50
    println(height)
    weight = 30F
    println(weight)
    println(isChild)
    println(isChildren)
    println(height < 150 || weight < 40F)
    println("Updated summary info: $info")
    println("Updated summary info: $info2")
    println(
        "Updated summary info: name: $firstName, lastname: $lastName, \" +\n" +
                "            \"height: $height, weight: $weight, isChild: $isChild, isChildren: $isChildren, ${height < 150 || weight < 40F}"
    )
}
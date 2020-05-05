fun evenList(list: List<Number>): List<Number> {
    return list.filter { it.toByte() % 2 == 0 }
}
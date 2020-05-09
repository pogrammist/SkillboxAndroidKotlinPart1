fun evenList(list: List<Number>): List<Number> {
    return list.filter { it.toLong() % 2 == 0L }
}

fun <T : Number> evenListWithoutMaxLong(list: List<T>): List<T> {
    return list.filter { kotlin.math.round(it.toDouble()) == it.toDouble() }.filter { it.toLong() % 2 == 0L }
}

fun <T : Number> evenListWithMaxLong(list: List<T>): List<T> {
    val evenList: MutableList<T> = mutableListOf()
    for (x in list) {
        if (x is Long && (x == Long.MAX_VALUE)) {
            continue
        }

        val l = x.toLong()
        if (l < Long.MAX_VALUE) {
            if (kotlin.math.round(x.toDouble()) == x.toDouble() && l % 2 == 0L) {
                evenList.add(x)
            }
        } else {
            evenList.add(x)
        }
    }
    return evenList
}
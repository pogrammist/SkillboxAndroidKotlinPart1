fun main() {
    val first = Queue<Any?>()

    first.enqueue(1)
    first.enqueue("second")
    first.enqueue('3')
    first.enqueue(null)
    first.enqueue(5)

    val second = first.filter { it is Int }
    val three = second::filter { it is Int }

    println(three.dequeue())
    println(three.dequeue())

    val ff = Queue<Int>()
    ff.enqueue(1)
    ff.enqueue(2)
    ff.enqueue(3)
    ff.enqueue(4)
    val foo = ff.filter(::predict)

    println(foo.dequeue())
    println(foo.dequeue())
}

fun predict(it: Int): Boolean {
    return it % 2 == 0
}
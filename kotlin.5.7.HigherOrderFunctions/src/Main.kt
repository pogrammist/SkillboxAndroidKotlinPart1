fun main() {
    val first = Queue<Any?>()

    first.enqueue(1)
    first.enqueue("second")
    first.enqueue('3')
    first.enqueue(null)
    first.enqueue(5)

    val second = first.filter { it is Int }
    val three = second::filter{ it is Int }

    println(three.dequeue())
    println(three.dequeue())
}
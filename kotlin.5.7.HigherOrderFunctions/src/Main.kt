fun main() {
    val queue = Queue<Any?>()

    queue.enqueue(1)
    queue.enqueue("second")
    queue.enqueue('3')
    queue.enqueue(null)
    queue.enqueue(5)

    println(queue.filter { it is Int })

    println(queue.dequeue())
    println(queue.dequeue())
}
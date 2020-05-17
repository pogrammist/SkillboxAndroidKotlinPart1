class Queue<T> {
    private val queue: MutableList<T> = mutableListOf()

    fun enqueue(item: T) {
        queue.add(item)
    }

    fun dequeue(): T? {
        if (queue.isEmpty()) {
            return null
        }
        val first = queue.first()
        queue.removeAt(0)
        return first
    }
}
import java.util.function.BiPredicate

class Queue<T> {
    private var queue: MutableList<T> = mutableListOf()

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

    fun filter(predicate: (T) -> Boolean) {
        queue = queue.filter { predicate(it) } as MutableList<T>
    }
}

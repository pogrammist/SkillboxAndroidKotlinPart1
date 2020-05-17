fun main() {
    val listInt = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
    println(evenList(listInt))
    val listDouble = listOf<Double>(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7)
    println(evenList(listDouble))
    val listFloat = listOf<Float>(1.11f, 2.22f, 3.33f, 4.44f, 5.55f, 6.66f, 7.77f)
    println(evenList(listFloat))
    val listLong = listOf<Long>(
        1111111111111111111,
        2222222222222222222,
        3333333333333333333,
        4444444444444444444,
        5555555555555555555,
        6666666666666666666,
        7777777777777777777
    )
    println(evenList(listLong))

    val queue = Queue<String>()
    queue.enqueue("first")
    queue.enqueue("second")
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    //true
    val first: Result<Int, String>? = getResult(1)
    val second: Result<Any, String>? = getResult(0)
    println(first.toString())
    println(second.toString())

//    false
//    val three: Result<Int, CharSequence>? = getResult(1)
//    val four: Result<Int, Any>? = getResult(0)
//    println(three.toString())
//    println(four.toString())
}
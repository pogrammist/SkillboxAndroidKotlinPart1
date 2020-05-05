sealed class Result<out T, R>

data class Success<T, R>(val t: T) : Result<T, R>()
data class Error<T, R>(val r: R) : Result<T, R>()

fun getResult(request: Int): Result<Int, String>? {
    return when (request) {
        1 -> {
            Success(1)
        }
        0 -> {
            Error("Error")
        }
        else -> null
    }
}
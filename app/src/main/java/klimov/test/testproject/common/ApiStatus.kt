package klimov.test.testproject.common

sealed class ApiStatus<T> {
    class SuccessStatus<T>(val data: T) : ApiStatus<T>()
    class ErrorStatus<T>(val cashedData: T? = null, val errorMessage: String? = null) : ApiStatus<T>()
    class LoadingStatus<T>(val cashedData: T? = null) : ApiStatus<T>()
}
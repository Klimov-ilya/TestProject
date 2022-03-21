package klimov.test.core.network

sealed class ApiStatus<T> {
    class SuccessStatus<T>(val data: T) : ApiStatus<T>()
    class ErrorStatus<T>(val cachedData: T? = null, val errorMessage: String? = null) : ApiStatus<T>()
    class LoadingStatus<T>(val cachedData: T? = null) : ApiStatus<T>()
}
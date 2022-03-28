package klimov.test.core.network

sealed class DataStatus<T> {
    class InitStatus<T> : DataStatus<T>()
    class SuccessStatus<T>(val data: T) : DataStatus<T>()
    class ErrorStatus<T>(val cachedData: T? = null, val errorMessage: String? = null) : DataStatus<T>()
    class LoadingStatus<T>(val cachedData: T? = null) : DataStatus<T>()
}
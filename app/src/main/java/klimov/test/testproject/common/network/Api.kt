package klimov.test.testproject.common.network

import klimov.test.testproject.BuildConfig
import klimov.test.testproject.main.api.MainApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Api {
    private const val BASE_URL = "https://the-one-api.dev/v2/"
    private const val CONNECTION_TIMEOUT = 60L

    val mainApi: MainApi by lazy {
        retrofit.create(MainApi::class.java)
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(getOkHttpClient())
        .baseUrl(BASE_URL)
        .build()

    private fun getOkHttpClient() = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .addInterceptor(getAuthInterceptor())
        .build()

    private fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) BODY else NONE
    }

    private fun getAuthInterceptor() = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer 6kkwE_vi59hSjoDd3nSB")
            .build()
        chain.proceed(request)
    }

}
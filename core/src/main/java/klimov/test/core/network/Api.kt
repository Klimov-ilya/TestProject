package klimov.test.core.network

import klimov.test.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit

object Api {

    fun <API> getService(api: Class<API>): API {
        if (retrofit == null) {
            synchronized(Retrofit::class.java) {
                retrofit = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(getOkHttpClient())
                    .baseUrl(BASE_URL)
                    .build()
            }
        }
        if (retrofit == null) {
            throw IllegalStateException("Retrofit is null")
        }
        return retrofit!!.create(api)
    }


    private const val BASE_URL = "https://api.edamam.com/"
    private const val CONNECTION_TIMEOUT = 20L

    private var retrofit: Retrofit? = null

    private fun getOkHttpClient() = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .build()

    private fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) BODY else NONE
    }

}
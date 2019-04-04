package com.mpp.seed.android.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

inline fun <reified S> createService(endPoint: String): S {


    val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildClient())
            .baseUrl(endPoint)
            .build()

    return retrofit.create(S::class.java)
}

fun buildClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    val timeout: Long = 60

    val builder = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(AuthInterceptor())
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)

    return builder.build()
}

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
                chain.request().newBuilder()
                        .addHeader("Authorization", Credentials.basic("CLIENT_AUTH_USER", "CLIENT_AUTH_PASS"))
                        .build()
        )
    }
}
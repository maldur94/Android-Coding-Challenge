package com.shiftkey.codingchallenge.core.network

import android.content.Context
import com.shiftkey.codingchallenge.R
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManagerHelper(private val context: Context) {

    fun initRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(context.getString(R.string.config_server_url))
        .client(initOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun initOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .followRedirects(false)
            .followSslRedirects(false)
            .retryOnConnectionFailure(true)
            .addInterceptor(initLoggingInterceptor())
            .connectTimeout(SERVER_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(SERVER_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(SERVER_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .cache(Cache(context.cacheDir, 64L * 1024 * 1024))

        return builder.build()
    }

    private fun initLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { print(it) }
        loggingInterceptor.level = getLoggingLevel()
        return loggingInterceptor
    }

    private fun getLoggingLevel() = HttpLoggingInterceptor.Level.BODY
}

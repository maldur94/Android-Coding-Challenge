package com.shiftkey.codingchallenge.core.network

import android.content.Context
import com.shiftkey.codingchallenge.data.service.AvailableShiftsService
import retrofit2.Retrofit

const val SERVER_TIMEOUT_SECONDS = 30L
const val API_PAGE = 0L
const val API_DATA_SIZE = 1000L

class NetworkManager(context: Context) {

    private val retrofit: Retrofit
    private val networkManagerHelper = NetworkManagerHelper(context)

    init {
        retrofit = networkManagerHelper.initRetrofit()
    }

    fun provideGetAvailableShiftsService(): AvailableShiftsService =
        retrofit.create(AvailableShiftsService::class.java)
}
package com.shiftkey.codingchallenge.data.service

import com.shiftkey.codingchallenge.core.network.API_DATA_SIZE
import com.shiftkey.codingchallenge.core.network.API_PAGE
import com.shiftkey.codingchallenge.data.model.AvailableShiftDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AvailableShiftsService {

    @GET("/api/v2/available_shifts")
    fun getAvailableShifts(
        @Query("page") page: Long = API_PAGE,
        @Query("size") size: Long = API_DATA_SIZE
    ): Response<List<AvailableShiftDTO>>
}
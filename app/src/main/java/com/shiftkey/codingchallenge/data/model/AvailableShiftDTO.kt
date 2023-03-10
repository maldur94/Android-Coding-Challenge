package com.shiftkey.codingchallenge.data.model

import java.time.LocalDate

data class AvailableShiftDTO(
    val type: AvailableShiftType,
    val start: LocalDate,
    val end: LocalDate,
    val address: String,
    val radius: Int
)

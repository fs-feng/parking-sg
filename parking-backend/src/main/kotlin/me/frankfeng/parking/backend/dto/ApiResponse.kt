package me.frankfeng.parking.backend.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiResponse(
    @JsonProperty("total_count") val totalCount: Int,
    val results: List<ApiParkingLot>
)
package me.frankfeng.parking.backend.service

import me.frankfeng.parking.backend.dto.ApiResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ParkingLotApiService(
    private val webClient: WebClient,
) {
    suspend fun findAllParkingLots(): ApiResponse =
        webClient.get()
            .uri("?limit=20")
            .retrieve()
            .awaitBody<ApiResponse>()

    suspend fun findOneParkingLot(phid: String) : ApiResponse =
        webClient.get()
            .uri("?where=phid =\"" + phid +"\"")
            .retrieve()
            .awaitBody<ApiResponse>()
}
package me.frankfeng.parking.backend.service

import me.frankfeng.parking.backend.dto.ParkingLotResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ParkingLotApiService(
    private val webClient: WebClient,
) {
    suspend fun findAllParkingLots(): ParkingLotResponse =
        webClient.get()
            .uri("")
            .retrieve()
            .awaitBody<ParkingLotResponse>()
}
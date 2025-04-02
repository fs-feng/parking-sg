package me.frankfeng.parking.backend.controller

import me.frankfeng.parking.backend.service.ParkingLotApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/parkinglots")
class ParkingLotController(
    private val parkingLotApiService: ParkingLotApiService
) {

    @GetMapping
    suspend fun findAllUsers() =
        parkingLotApiService.findAllParkingLots()
}
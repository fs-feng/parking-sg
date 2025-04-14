package me.frankfeng.parking.backend.controller

import me.frankfeng.parking.backend.dto.ApiParkingLot
import me.frankfeng.parking.backend.model.ParkingLotEntity
import me.frankfeng.parking.backend.service.ParkingLotApiService
import me.frankfeng.parking.backend.service.ParkingLotSyncService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/parkinglots")
class ParkingLotController(
    private val parkingLotApiService: ParkingLotApiService,
    private val parkingLotSyncService: ParkingLotSyncService
) {

    @GetMapping
    suspend fun findAllParkingLots(): List<ApiParkingLot> {
        return parkingLotApiService.findAllParkingLots().results

    }



}
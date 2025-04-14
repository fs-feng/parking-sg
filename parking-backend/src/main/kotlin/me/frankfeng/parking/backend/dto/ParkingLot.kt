package me.frankfeng.parking.backend.dto

import jakarta.persistence.*
import me.frankfeng.parking.backend.model.ParkingLotState
import java.time.LocalDateTime

data class ParkingLot (
    val phid: String,
    val name: String,

    @Enumerated(EnumType.STRING)
    val state: ParkingLotState,

    val maxSpots: Int,
    val freeSpots: Int,
    val occupiedSpots: Int,
    val occupancyPercent: Int?,
    val location: Location,
    val timestamp: LocalDateTime
)

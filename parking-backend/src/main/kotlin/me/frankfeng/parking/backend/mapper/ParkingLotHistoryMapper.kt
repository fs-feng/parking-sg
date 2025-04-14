package me.frankfeng.parking.backend.mapper

import me.frankfeng.parking.backend.dto.ApiParkingLot
import me.frankfeng.parking.backend.model.ParkingLotEntity
import me.frankfeng.parking.backend.model.ParkingLotHistoryEntity
import me.frankfeng.parking.backend.model.ParkingLotState
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Component
class ParkingLotHistoryMapper {
    fun apiToEntity(api: ApiParkingLot, parkingLot: ParkingLotEntity): ParkingLotHistoryEntity =
        ParkingLotHistoryEntity(
            parkingLot = parkingLot,
            state = ParkingLotState.fromString(api.phstate),
            maxSpots = api.shortmax,
            freeSpots = api.shortfree,
            occupiedSpots = api.shortoccupied,
            occupancyPercent = api.belegung_prozent,
            timestamp = LocalDateTime.parse(api.zeitpunkt, DateTimeFormatter.ISO_OFFSET_DATE_TIME)

        )
}
package me.frankfeng.parking.backend.mapper

import me.frankfeng.parking.backend.dto.ApiParkingLot
import me.frankfeng.parking.backend.model.LocationEntity
import me.frankfeng.parking.backend.model.ParkingLotEntity
import org.springframework.stereotype.Component

@Component
class ParkingLotMapper {
    fun mapApiToEntity(api: ApiParkingLot): ParkingLotEntity =
        ParkingLotEntity(
            phId = api.phid,
            name = api.phname,
            location = LocationEntity(
                lon = api.standort.lon,
                lat = api.standort.lat
            ),
        )

}
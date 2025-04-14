package me.frankfeng.parking.backend.repository

import me.frankfeng.parking.backend.model.ParkingLotHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParkingHistoryRepository: JpaRepository<ParkingLotHistoryEntity, Long> {

}
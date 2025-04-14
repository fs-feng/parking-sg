package me.frankfeng.parking.backend.repository

import me.frankfeng.parking.backend.model.ParkingLotEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ParkingLotRepository: JpaRepository<ParkingLotEntity, Long> {
    fun findByPhId(phid: String): ParkingLotEntity?

    @Query("SELECT p FROM  ParkingLotEntity p LEFT JOIN FETCH p.history")
    fun findAllWithHistory(): List<ParkingLotEntity>
}
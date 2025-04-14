package me.frankfeng.parking.backend.repository

import me.frankfeng.parking.backend.model.LocationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository: JpaRepository<LocationEntity, Long> {
}
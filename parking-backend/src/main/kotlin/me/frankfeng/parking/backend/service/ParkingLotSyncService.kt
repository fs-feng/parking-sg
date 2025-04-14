package me.frankfeng.parking.backend.service

import jakarta.transaction.Transactional
import me.frankfeng.parking.backend.dto.ParkingLot
import me.frankfeng.parking.backend.mapper.ParkingLotHistoryMapper
import me.frankfeng.parking.backend.mapper.ParkingLotMapper
import me.frankfeng.parking.backend.model.LocationEntity
import me.frankfeng.parking.backend.model.ParkingLotEntity
import me.frankfeng.parking.backend.repository.ParkingLotRepository
import org.hibernate.Hibernate
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.stereotype.Service

@Service
class ParkingLotSyncService (
    private val parkingLotRepository: ParkingLotRepository,
    private val parkingLotHistoryMapper: ParkingLotHistoryMapper,
    private val parkingLotMapper : ParkingLotMapper,
    private val parkingLotApiService: ParkingLotApiService,
) {
    suspend fun syncParkingLots() {
        val apiEntities: List<ParkingLotEntity> = fetchApiEntities()
        val dbEntities: Map<String, ParkingLotEntity> = fetchDBEntities().associateBy { it.phId }
        val entitiesToSave: MutableList<ParkingLotEntity> = mutableListOf()

        updateParkingLots(apiEntities, dbEntities, entitiesToSave)

        parkingLotRepository.saveAll(entitiesToSave)
    }

    private fun updateParkingLots(apiEntities: List<ParkingLotEntity>,
                                  dbEntities: Map<String, ParkingLotEntity>,
                                  entitiesToSave: MutableList<ParkingLotEntity>) {
        apiEntities.forEach { apiEntity ->
            val dbEntity = dbEntities[apiEntity.phId]

            if (dbEntity != null) {
                dbEntity.history.add(apiEntity.history.first().copy(
                    parkingLot = dbEntity
                ))

                entitiesToSave.add(dbEntity.copy(
                    name = apiEntity.name,
                    phId = apiEntity.phId,
                    location = dbEntity.location.copy(
                        lon = apiEntity.location.lon,
                        lat = apiEntity.location.lat
                    ),
                ))
            } else {
                val apiHistory = apiEntity.history.distinctBy { it.timestamp }
                apiEntity.history.clear()
                apiEntity.history.addAll(apiHistory)

                entitiesToSave.add(apiEntity)
            }
        }

    }

    fun fetchDBEntities() : List<ParkingLotEntity> {
        return parkingLotRepository.findAll()
    }

    private suspend fun fetchApiEntities(): List<ParkingLotEntity> {
        val apiResponse = parkingLotApiService.findAllParkingLots()
        val apiEntities: List<ParkingLotEntity> = apiResponse.results.map { apiParkingLot ->
            val apiEntity = parkingLotMapper.mapApiToEntity(apiParkingLot)
            apiEntity.history.add(parkingLotHistoryMapper.apiToEntity(apiParkingLot, apiEntity))

            apiEntity
        }
        return apiEntities
    }
}
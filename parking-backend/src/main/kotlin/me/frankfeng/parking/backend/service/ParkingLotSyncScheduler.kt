package me.frankfeng.parking.backend.service

import jakarta.annotation.PostConstruct
import jakarta.transaction.Transactional
import kotlinx.coroutines.runBlocking
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@Transactional
class ParkingLotSyncScheduler (
    private val parkingLotSyncService: ParkingLotSyncService,
) {
    @Scheduled(cron = "0 0 * * * *")
    suspend fun runSyncJob() {
        parkingLotSyncService.syncParkingLots()


    }

}
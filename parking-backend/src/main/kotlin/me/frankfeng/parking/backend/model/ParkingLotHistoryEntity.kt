package me.frankfeng.parking.backend.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "parking_lot_history")
data class ParkingLotHistoryEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false)
    val parkingLot: ParkingLotEntity,

    @Enumerated(EnumType.STRING)
    val state: ParkingLotState,

    val maxSpots: Int,
    val freeSpots: Int,
    val occupiedSpots: Int,
    val occupancyPercent: Int?,
    val timestamp: LocalDateTime
) {
    override fun toString(): String {
        return "ParkingLotEntity(id=$id, state=${state.toString()} maxSpots=$maxSpots, freeSpots=$freeSpots, occupiedSpots=$occupancyPercent, timestamp=$timestamp)"
    }
}

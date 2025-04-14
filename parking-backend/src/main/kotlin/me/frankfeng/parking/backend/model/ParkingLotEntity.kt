package me.frankfeng.parking.backend.model

import jakarta.persistence.*


@Entity
@Table(name = "parking_lot")
data class ParkingLotEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(unique = true, nullable = false)
    val phId: String,

    val name: String,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    val location: LocationEntity,

    @OneToMany(mappedBy = "parkingLot", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val history: MutableList<ParkingLotHistoryEntity> = mutableListOf()
) {
    override fun toString(): String {
        return "ParkingLotEntity(id=$id, phId=$phId, name=$name location=$location, history=$history)"
    }
}

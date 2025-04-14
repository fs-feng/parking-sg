package me.frankfeng.parking.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "location")
data class LocationEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val lat: Double,
    val lon: Double
) {
    override fun toString(): String {
        return "LocationEntity(id=$id, lat=$lat, lon=$lon)"
    }
}
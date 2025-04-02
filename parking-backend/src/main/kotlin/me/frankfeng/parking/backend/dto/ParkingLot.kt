package me.frankfeng.parking.backend.dto

data class ParkingLot(
    val phid: String,
    val phname: String,
    val phstate: String,
    val shortmax: Int,
    val shortfree: Int,
    val shortoccupied: Int,
    val belegung_prozent: Int?,
    val standort: Location,
    val zeitpunkt: String
)

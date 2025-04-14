package me.frankfeng.parking.backend.dto

data class ApiParkingLot(
    val phid: String,
    val phname: String,
    val phstate: String,
    val shortmax: Int,
    val shortfree: Int,
    val shortoccupied: Int,
    val belegung_prozent: Int?,
    val standort: ApiLocation,
    val zeitpunkt: String
)

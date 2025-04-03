package me.frankfeng.parking.backend.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ParkingLot(
    @JsonProperty("phid") val phid: String,
    @JsonProperty("phname") val name: String,
    @JsonProperty("phstate") val state: String,
    @JsonProperty("shortmax") val capacity: Int,
    @JsonProperty("shortfree") val freeSpaces: Int,
    @JsonProperty("shortoccupied") val occupiedSpaces: Int,
    @JsonProperty("belegung_prozent") val occupancyPercent: Int?,
    @JsonProperty("standort") val location: Location,
    @JsonProperty("zeitpunkt") val timestamp: String
)

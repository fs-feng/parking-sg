package me.frankfeng.parking.backend.model


enum class ParkingLotState {
    OPEN, CLOSED, NOT_AVAILABLE, UNKNOWN;

    companion object {
        fun fromString(state: String): ParkingLotState =
            when (state.lowercase()) {
                "offen" -> OPEN
                "geschlossen" -> CLOSED
                "nicht verfügbar" -> NOT_AVAILABLE
                else -> UNKNOWN
            }
    }
}

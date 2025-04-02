package me.frankfeng.parking.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParkingBackendApplication

fun main(args: Array<String>) {
    runApplication<ParkingBackendApplication>(*args)
}

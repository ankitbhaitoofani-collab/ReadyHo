package com.aag.readyho

object Backend {
    private val rides = mutableListOf<Ride>()

    data class Ride(
        val pickup: String,
        val drop: String
    )

    fun addRide(pickup: String, drop: String): Boolean {
        // Temporary logic: simply add ride to list
        rides.add(Ride(pickup, drop))
        return true
    }

    fun getAllRides(): List<Ride> {
        return rides
    }
}
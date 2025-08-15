package com.aag.readyho

object Backend {

    private val rides = mutableListOf<Ride>()

    data class Ride(val pickup: String, val drop: String)

    fun addRide(pickup: String, drop: String) {
        val ride = Ride(pickup, drop)
        rides.add(ride)
        println("Ride Added: Pickup=$pickup, Drop=$drop")
    }

    fun getRides(): List<Ride> = rides.toList()

    fun clearRides() {
        rides.clear()
        println("All rides cleared")
    }
}
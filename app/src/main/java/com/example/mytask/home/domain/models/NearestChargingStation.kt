package com.example.mytask.home.domain.models

data class NearestChargingStation(
    val id: Int,
    val name: String,
    val unitsAvailable: String,
    val destination: String,
)

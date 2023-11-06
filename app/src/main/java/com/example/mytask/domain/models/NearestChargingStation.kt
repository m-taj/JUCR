package com.example.mytask.domain.models

data class NearestChargingStation(
    val id: Int,
    val name: String,
    val unitsAvailable: String,
    val destination: String,
)

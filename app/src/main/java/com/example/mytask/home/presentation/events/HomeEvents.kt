package com.example.mytask.home.presentation.events

import com.example.mytask.home.domain.models.ChargingData
import com.example.mytask.home.domain.models.NearestChargingStation

sealed class HomeEvents {

    object Loading : HomeEvents()

    data class Error(val throwable: Throwable) : HomeEvents()

    data class NearStationsListReceivedSuccessFully(val chargingStations: List<NearestChargingStation>, val chargingData:  List<ChargingData>) :
        HomeEvents()

    companion object {
        fun loading() = Loading
        fun error(throwable: Throwable) = Error(throwable)
        fun nearStationsListReceivedSuccessFully(stations: List<NearestChargingStation>, batteryStats:  List<ChargingData>) =
            NearStationsListReceivedSuccessFully(stations,batteryStats)
    }
}

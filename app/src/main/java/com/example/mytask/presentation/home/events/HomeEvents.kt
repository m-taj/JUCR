package com.example.mytask.presentation.home.events

import com.example.mytask.domain.models.BatteryStats
import com.example.mytask.domain.models.NearestChargingStation

sealed class HomeEvents {

    object Loading : HomeEvents()

    data class Error(val throwable: Throwable) : HomeEvents()

    data class NearStationsListReceivedSuccessFully(val list: List<NearestChargingStation>,val batteryStats: BatteryStats) :
        HomeEvents()

    companion object {
        fun loading() = Loading
        fun error(throwable: Throwable) = Error(throwable)
        fun nearStationsListReceivedSuccessFully(stationsList: List<NearestChargingStation>,batteryStats: BatteryStats) =
            NearStationsListReceivedSuccessFully(stationsList,batteryStats)
    }
}

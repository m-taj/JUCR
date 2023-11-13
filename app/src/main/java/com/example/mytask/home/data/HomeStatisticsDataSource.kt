package com.example.mytask.home.data

import com.example.mytask.home.domain.models.ChargingData
import com.example.mytask.home.domain.repository.HomeStatisticsRepository
import com.example.mytask.home.domain.models.NearestChargingStation
import kotlinx.coroutines.delay

/**
 * for simplicity will create a dummy chargingStations and return in each respective function as we do not have
 * a remote or local dataSources implemented as well as adding delay to functions to simulate
 * requesting data from endpoint
 */
class HomeStatisticsDataSource : HomeStatisticsRepository {


    override suspend fun getBatterStats(): List<ChargingData> {
        delay(3000L)
        return dummyBatterStats()
    }

    private fun dummyBatterStats() = listOf(
        ChargingData("240 volt", "Voltage"),
        ChargingData("540 km", "Remaining Charge"),
        /**
         * assumed this value based on design
         */
        ChargingData("20 Minutes", "Fast Charge")
    )

    override suspend fun getNearStationsList(): List<NearestChargingStation> {
        delay(3000L)
        return dummyListOfChargingStation()
    }

    private fun dummyListOfChargingStation(): List<NearestChargingStation> {
        return (1..20).map {
            NearestChargingStation(
                id = it,
                unitsAvailable = (0..10).random().toString(),
                destination = "1.5",
                name = "station $it"
            )
        }
    }
}
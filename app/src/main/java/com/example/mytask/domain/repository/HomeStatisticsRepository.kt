package com.example.mytask.domain.repository

import com.example.mytask.domain.models.ChargingData
import com.example.mytask.domain.models.NearestChargingStation

/**
 * Created by Mohammed Taguldeen on 05/11/2023.
 */
interface HomeStatisticsRepository {

    suspend fun getBatterStats():  List<ChargingData>

    suspend fun getNearStationsList(): List<NearestChargingStation>
}
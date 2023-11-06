package com.example.mytask.domain.repository

import com.example.mytask.domain.models.BatteryStats
import com.example.mytask.domain.models.NearestChargingStation

/**
 * Created by Mohammed Taguldeen on 05/11/2023.
 */
interface HomeStatisticsRepository {
    suspend fun getChargingStats(): String

    suspend fun getBatterStats(): BatteryStats

    suspend fun getNearStationsList(): List<NearestChargingStation>
}
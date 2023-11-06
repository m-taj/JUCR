package com.example.mytask.di

import com.example.mytask.data.HomeStatisticsDataSource
import com.example.mytask.domain.repository.HomeStatisticsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Mohammed Taguldeen on 05/11/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
class HomeFeatureModule {

    @Provides
    @Singleton
    fun providesHomeRepository(): HomeStatisticsRepository = HomeStatisticsDataSource()
}
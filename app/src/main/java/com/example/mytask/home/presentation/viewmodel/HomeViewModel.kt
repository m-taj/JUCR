package com.example.mytask.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytask.home.presentation.events.HomeEvents
import com.example.mytask.home.domain.repository.HomeStatisticsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Home Screen View Model has repository injected in its constructor ,
 *
 *
 * 1- if UseCase was Implemented then the repo would have been injected in the use case and the use-case
 * would be injected into the view-model instead
 *
 * 2- normally domain models are for domain layer only , as for presentation layer (view-model) i create UI models and a mapper
 * which maps the data from domain model to their respective UI models
 *
 * 3- used state flow as it serves the need with the sealed class based feature events as they're mutually exclusive
 **/

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: HomeStatisticsRepository) : ViewModel() {

    val homeEvents: StateFlow<HomeEvents>
        get() = _homeEvents
    private val _homeEvents = MutableStateFlow<HomeEvents>(
        HomeEvents.loading()
    )

    fun getNearChargingStations() {

        _homeEvents.update { HomeEvents.loading() }

        viewModelScope.launch {

            val nearestStation = async { repository.getNearStationsList() }
            val batteryStats = async { repository.getBatterStats() }

            try {
                _homeEvents.update {
                    HomeEvents.nearStationsListReceivedSuccessFully(
                        nearestStation.await(), batteryStats.await()
                    )
                }
            } catch (throwable: Throwable) {
                _homeEvents.update { HomeEvents.error(throwable) }
            }
        }
    }
}
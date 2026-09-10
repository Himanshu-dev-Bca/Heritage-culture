package com.heritage.india.presentation.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.heritage.india.core.common.toLatLng
import com.heritage.india.domain.repository.LocationProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationProvider: LocationProvider
) : ViewModel() {

    private val _state = MutableStateFlow(MapState())
    val state: StateFlow<MapState> = _state.asStateFlow()

    init {
        startLocationUpdates()
    }

    private fun startLocationUpdates() {
        viewModelScope.launch {
            locationProvider.getLocationUpdates()
                .filterNotNull()
                .collect { location ->
                    val userLatLng = location.toLatLng()
                    _state.update { it.copy(userLocation = userLatLng) }
                }
        }
    }

    fun onMapLoaded() {
        // Fetch nearby locations logic will go here
    }
}

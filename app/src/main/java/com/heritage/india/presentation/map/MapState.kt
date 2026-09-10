package com.heritage.india.presentation.map

import com.google.android.gms.maps.model.LatLng
import com.heritage.india.domain.model.CulturalLocation

data class MapState(
    val userLocation: LatLng? = null,
    val nearbyLocations: List<CulturalLocation> = emptyList(),
    val discoveredLocationIds: Set<String> = emptySet(),
    val isLoading: Boolean = false,
    val error: String? = null
)

package com.heritage.india.domain.repository

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface LocationProvider {
    fun getLocationUpdates(): Flow<Location?>
    suspend fun getCurrentLocation(): Location?
}

package com.heritage.india.domain.repository

import com.heritage.india.domain.model.CulturalLocation
import kotlinx.coroutines.flow.Flow

interface CulturalRepository {
    fun getAllLocations(): Flow<List<CulturalLocation>>
    suspend fun getLocationById(id: String): CulturalLocation?
    suspend fun refreshLocations() // To be implemented with Network later
    suspend fun insertSampleData()
}

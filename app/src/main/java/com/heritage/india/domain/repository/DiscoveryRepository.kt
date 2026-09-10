package com.heritage.india.domain.repository

import com.heritage.india.domain.model.UserDiscovery
import kotlinx.coroutines.flow.Flow

interface DiscoveryRepository {
    fun getAllDiscoveries(): Flow<List<UserDiscovery>>
    suspend fun markAsDiscovered(locationId: String, xp: Int)
    suspend fun isDiscovered(locationId: String): Boolean
}

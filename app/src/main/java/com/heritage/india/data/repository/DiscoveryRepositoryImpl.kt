package com.heritage.india.data.repository

import com.heritage.india.data.local.dao.UserDiscoveryDao
import com.heritage.india.data.local.entities.UserDiscoveryEntity
import com.heritage.india.domain.model.UserDiscovery
import com.heritage.india.domain.repository.DiscoveryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DiscoveryRepositoryImpl @Inject constructor(
    private val dao: UserDiscoveryDao
) : DiscoveryRepository {

    override fun getAllDiscoveries(): Flow<List<UserDiscovery>> {
        return dao.getAllDiscoveries().map { entities ->
            entities.map { UserDiscovery(it.locationId, it.discoveryDate, it.xpEarned) }
        }
    }

    override suspend fun markAsDiscovered(locationId: String, xp: Int) {
        dao.insertDiscovery(
            UserDiscoveryEntity(
                locationId = locationId,
                discoveryDate = System.currentTimeMillis(),
                xpEarned = xp
            )
        )
    }

    override suspend fun isDiscovered(locationId: String): Boolean {
        return dao.isDiscovered(locationId)
    }
}

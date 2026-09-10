package com.heritage.india.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.heritage.india.data.local.entities.UserDiscoveryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDiscoveryDao {
    @Query("SELECT * FROM user_discoveries")
    fun getAllDiscoveries(): Flow<List<UserDiscoveryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiscovery(discovery: UserDiscoveryEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM user_discoveries WHERE locationId = :locationId)")
    suspend fun isDiscovered(locationId: String): Boolean
}

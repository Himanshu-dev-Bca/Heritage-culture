package com.heritage.india.data.local.dao

import androidx.room.*
import com.heritage.india.data.local.entities.CulturalLocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CulturalLocationDao {
    @Query("SELECT * FROM cultural_locations")
    fun getAllLocations(): Flow<List<CulturalLocationEntity>>

    @Query("SELECT * FROM cultural_locations WHERE id = :id")
    suspend fun getLocationById(id: String): CulturalLocationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(locations: List<CulturalLocationEntity>)

    @Query("DELETE FROM cultural_locations")
    suspend fun deleteAll()
}

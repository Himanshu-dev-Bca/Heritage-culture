package com.heritage.india.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.heritage.india.data.local.entities.BadgeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BadgeDao {
    @Query("SELECT * FROM badges")
    fun getAllBadges(): Flow<List<BadgeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBadges(badges: List<BadgeEntity>)

    @Query("UPDATE badges SET isUnlocked = 1 WHERE id = :badgeId")
    suspend fun unlockBadge(badgeId: String)

    @Query("SELECT * FROM badges WHERE isUnlocked = 1")
    fun getUnlockedBadges(): Flow<List<BadgeEntity>>
}

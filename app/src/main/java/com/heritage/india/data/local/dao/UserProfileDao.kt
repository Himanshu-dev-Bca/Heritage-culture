package com.heritage.india.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.heritage.india.data.local.entities.UserProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {
    @Query("SELECT * FROM user_profile WHERE id = 'current_user'")
    fun getUserProfile(): Flow<UserProfileEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: UserProfileEntity)

    @Query("UPDATE user_profile SET totalXp = totalXp + :amount WHERE id = 'current_user'")
    suspend fun addXp(amount: Int)

    @Query("UPDATE user_profile SET level = :level WHERE id = 'current_user'")
    suspend fun updateLevel(level: Int)
}

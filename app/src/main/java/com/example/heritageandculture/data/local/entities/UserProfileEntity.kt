package com.heritage.india.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heritage.india.domain.model.UserProfile

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: String = "current_user",
    val username: String,
    val totalXp: Int,
    val level: Int
) {
    fun toDomain(): UserProfile = UserProfile(
        id = id,
        username = username,
        totalXp = totalXp,
        level = level
    )
}

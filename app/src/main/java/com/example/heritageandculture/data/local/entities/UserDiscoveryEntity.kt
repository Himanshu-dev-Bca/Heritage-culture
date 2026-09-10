package com.heritage.india.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_discoveries")
data class UserDiscoveryEntity(
    @PrimaryKey val locationId: String,
    val discoveryDate: Long,
    val xpEarned: Int
)

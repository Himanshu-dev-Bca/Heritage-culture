package com.heritage.india.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.heritage.india.data.local.dao.BadgeDao
import com.heritage.india.data.local.dao.CulturalLocationDao
import com.heritage.india.data.local.dao.UserDiscoveryDao
import com.heritage.india.data.local.dao.UserProfileDao
import com.heritage.india.data.local.entities.BadgeEntity
import com.heritage.india.data.local.entities.CulturalLocationEntity
import com.heritage.india.data.local.entities.UserDiscoveryEntity
import com.heritage.india.data.local.entities.UserProfileEntity

@Database(
    entities = [
        CulturalLocationEntity::class,
        UserDiscoveryEntity::class,
        BadgeEntity::class,
        UserProfileEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CulturalDatabase : RoomDatabase() {
    abstract val culturalLocationDao: CulturalLocationDao
    abstract val userDiscoveryDao: UserDiscoveryDao
    abstract val badgeDao: BadgeDao
    abstract val userProfileDao: UserProfileDao

    companion object {
        const val DATABASE_NAME = "heritage_db"
    }
}

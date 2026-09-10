package com.heritage.india.core.di

import android.content.Context
import androidx.room.Room
import com.heritage.india.data.local.CulturalDatabase
import com.heritage.india.data.local.dao.BadgeDao
import com.heritage.india.data.local.dao.CulturalLocationDao
import com.heritage.india.data.local.dao.UserDiscoveryDao
import com.heritage.india.data.local.dao.UserProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCulturalDatabase(
        @ApplicationContext context: Context
    ): CulturalDatabase {
        return Room.databaseBuilder(
            context,
            CulturalDatabase::class.java,
            CulturalDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideCulturalLocationDao(db: CulturalDatabase): CulturalLocationDao {
        return db.culturalLocationDao
    }

    @Provides
    @Singleton
    fun provideUserDiscoveryDao(db: CulturalDatabase): UserDiscoveryDao {
        return db.userDiscoveryDao
    }

    @Provides
    @Singleton
    fun provideBadgeDao(db: CulturalDatabase): BadgeDao {
        return db.badgeDao
    }

    @Provides
    @Singleton
    fun provideUserProfileDao(db: CulturalDatabase): UserProfileDao {
        return db.userProfileDao
    }
}

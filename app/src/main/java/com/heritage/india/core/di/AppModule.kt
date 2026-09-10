package com.heritage.india.core.di

import com.heritage.india.data.repository.CulturalRepositoryImpl
import com.heritage.india.data.repository.DiscoveryRepositoryImpl
import com.heritage.india.data.repository.GamificationRepositoryImpl
import com.heritage.india.domain.repository.CulturalRepository
import com.heritage.india.domain.repository.DiscoveryRepository
import com.heritage.india.domain.repository.GamificationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindCulturalRepository(
        culturalRepositoryImpl: CulturalRepositoryImpl
    ): CulturalRepository

    @Binds
    @Singleton
    abstract fun bindDiscoveryRepository(
        discoveryRepositoryImpl: DiscoveryRepositoryImpl
    ): DiscoveryRepository

    @Binds
    @Singleton
    abstract fun bindGamificationRepository(
        gamificationRepositoryImpl: GamificationRepositoryImpl
    ): GamificationRepository
}

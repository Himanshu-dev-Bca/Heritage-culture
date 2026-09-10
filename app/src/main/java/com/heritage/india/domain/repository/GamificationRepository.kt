package com.heritage.india.domain.repository

import com.heritage.india.domain.model.Badge
import com.heritage.india.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface GamificationRepository {
    fun getUserProfile(): Flow<UserProfile>
    fun getBadges(): Flow<List<Badge>>
    suspend fun checkAndUnlockBadges()
    suspend fun addXp(amount: Int)
    suspend fun insertInitialBadges()
}

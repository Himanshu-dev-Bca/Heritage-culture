package com.heritage.india.data.repository

import com.heritage.india.data.local.dao.BadgeDao
import com.heritage.india.data.local.dao.UserDiscoveryDao
import com.heritage.india.data.local.dao.UserProfileDao
import com.heritage.india.data.local.entities.BadgeEntity
import com.heritage.india.data.local.entities.UserProfileEntity
import com.heritage.india.domain.model.Badge
import com.heritage.india.domain.model.BadgeCategory
import com.heritage.india.domain.model.UserProfile
import com.heritage.india.domain.repository.GamificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GamificationRepositoryImpl @Inject constructor(
    private val userProfileDao: UserProfileDao,
    private val badgeDao: BadgeDao,
    private val discoveryDao: UserDiscoveryDao
) : GamificationRepository {

    override fun getUserProfile(): Flow<UserProfile> {
        return userProfileDao.getUserProfile().map { entity ->
            entity?.toDomain() ?: UserProfile("current_user", "Explorer", 0, 1)
        }
    }

    override fun getBadges(): Flow<List<Badge>> {
        return badgeDao.getAllBadges().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun checkAndUnlockBadges() {
        val discoveries = discoveryDao.getAllDiscoveries().first()
        val badges = badgeDao.getAllBadges().first()

        badges.filter { !it.isUnlocked }.forEach { badge ->
            if (discoveries.size >= badge.requirementCount) {
                badgeDao.unlockBadge(badge.id)
            }
        }
    }

    override suspend fun addXp(amount: Int) {
        val currentProfile = userProfileDao.getUserProfile().first()
        if (currentProfile == null) {
            userProfileDao.insertProfile(UserProfileEntity(username = "Explorer", totalXp = amount, level = 1))
        } else {
            userProfileDao.addXp(amount)
            val newProfile = userProfileDao.getUserProfile().first()!!
            val newLevel = (newProfile.totalXp / 1000) + 1
            if (newLevel > newProfile.level) {
                userProfileDao.updateLevel(newLevel)
            }
        }
    }

    override suspend fun insertInitialBadges() {
        val initialBadges = listOf(
            BadgeEntity("badge_novice", "Novice Explorer", "Discover 1 location", BadgeCategory.EXPLORER.name, "", 1),
            BadgeEntity("badge_karnataka_1", "Karnataka Traveler", "Discover 5 locations in Karnataka", BadgeCategory.STATE.name, "", 5),
            BadgeEntity("badge_heritage_hunter", "Heritage Hunter", "Discover 10 monuments", BadgeCategory.HERITAGE.name, "", 10)
        )
        badgeDao.insertBadges(initialBadges)
    }
}

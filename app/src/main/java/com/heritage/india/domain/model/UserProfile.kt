package com.heritage.india.domain.model

data class UserProfile(
    val id: String,
    val username: String,
    val totalXp: Int,
    val level: Int,
    val unlockedBadgeIds: List<String> = emptyList()
) {
    val levelProgress: Float
        get() = (totalXp % 1000) / 1000f
    
    val currentLevel: Int
        get() = (totalXp / 1000) + 1
}

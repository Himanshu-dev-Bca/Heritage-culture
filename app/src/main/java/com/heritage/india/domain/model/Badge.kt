package com.heritage.india.domain.model

enum class BadgeCategory {
    STATE, CITY, HERITAGE, FOOD, FESTIVAL, EXPLORER
}

data class Badge(
    val id: String,
    val name: String,
    val description: String,
    val category: BadgeCategory,
    val iconUrl: String,
    val requirementCount: Int,
    val isUnlocked: Boolean = false
)

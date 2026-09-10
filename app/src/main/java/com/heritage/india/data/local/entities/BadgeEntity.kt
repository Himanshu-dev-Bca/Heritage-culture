package com.heritage.india.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heritage.india.domain.model.Badge
import com.heritage.india.domain.model.BadgeCategory

@Entity(tableName = "badges")
data class BadgeEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String,
    val requirementCount: Int,
    val isUnlocked: Boolean = false
) {
    fun toDomain(): Badge = Badge(
        id = id,
        name = name,
        description = description,
        category = BadgeCategory.valueOf(category),
        iconUrl = iconUrl,
        requirementCount = requirementCount,
        isUnlocked = isUnlocked
    )

    companion object {
        fun fromDomain(badge: Badge): BadgeEntity = BadgeEntity(
            id = badge.id,
            name = badge.name,
            description = badge.description,
            category = badge.category.name,
            iconUrl = badge.iconUrl,
            requirementCount = badge.requirementCount,
            isUnlocked = badge.isUnlocked
        )
    }
}

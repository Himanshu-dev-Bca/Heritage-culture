package com.heritage.india.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heritage.india.domain.model.CulturalLocation
import com.heritage.india.domain.model.RarityTier

@Entity(tableName = "cultural_locations")
data class CulturalLocationEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val state: String,
    val city: String,
    val district: String,
    val latitude: Double,
    val longitude: Double,
    val category: String,
    val subcategory: String,
    val historicalPeriod: String,
    val significance: String,
    val imageUrls: String, // Stored as comma-separated string for simplicity in Room
    val audioUrl: String?,
    val localLanguage: String,
    val entryFee: String?,
    val openingHours: String?,
    val discoveryRadius: Double,
    val rarity: String,
    val tags: String // Comma-separated
) {
    fun toDomain(): CulturalLocation {
        return CulturalLocation(
            id = id,
            name = name,
            description = description,
            state = state,
            city = city,
            district = district,
            latitude = latitude,
            longitude = longitude,
            category = category,
            subcategory = subcategory,
            historicalPeriod = historicalPeriod,
            significance = significance,
            imageUrls = imageUrls.split(",").filter { it.isNotBlank() },
            audioUrl = audioUrl,
            localLanguage = localLanguage,
            entryFee = entryFee,
            openingHours = openingHours,
            discoveryRadius = discoveryRadius,
            rarity = RarityTier.valueOf(rarity),
            tags = tags.split(",").filter { it.isNotBlank() }
        )
    }

    companion object {
        fun fromDomain(location: CulturalLocation): CulturalLocationEntity {
            return CulturalLocationEntity(
                id = location.id,
                name = location.name,
                description = location.description,
                state = location.state,
                city = location.city,
                district = location.district,
                latitude = location.latitude,
                longitude = location.longitude,
                category = location.category,
                subcategory = location.subcategory,
                historicalPeriod = location.historicalPeriod,
                significance = location.significance,
                imageUrls = location.imageUrls.joinToString(","),
                audioUrl = location.audioUrl,
                localLanguage = location.localLanguage,
                entryFee = location.entryFee,
                openingHours = location.openingHours,
                discoveryRadius = location.discoveryRadius,
                rarity = location.rarity.name,
                tags = location.tags.joinToString(",")
            )
        }
    }
}

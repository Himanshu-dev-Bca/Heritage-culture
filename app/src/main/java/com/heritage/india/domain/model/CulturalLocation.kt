package com.heritage.india.domain.model

import com.google.android.gms.maps.model.LatLng

data class CulturalLocation(
    val id: String,
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
    val imageUrls: List<String>,
    val audioUrl: String?,
    val localLanguage: String,
    val entryFee: String?,
    val openingHours: String?,
    val discoveryRadius: Double, // in meters
    val rarity: RarityTier,
    val tags: List<String>
) {
    val position: LatLng get() = LatLng(latitude, longitude)
}

enum class RarityTier {
    COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
}

package com.heritage.india.data.repository

import com.heritage.india.data.local.dao.CulturalLocationDao
import com.heritage.india.data.local.entities.CulturalLocationEntity
import com.heritage.india.domain.model.CulturalLocation
import com.heritage.india.domain.model.RarityTier
import com.heritage.india.domain.repository.CulturalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CulturalRepositoryImpl @Inject constructor(
    private val dao: CulturalLocationDao
) : CulturalRepository {

    override fun getAllLocations(): Flow<List<CulturalLocation>> {
        return dao.getAllLocations().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getLocationById(id: String): CulturalLocation? {
        return dao.getLocationById(id)?.toDomain()
    }

    override suspend fun refreshLocations() {
        // In a real app, fetch from network and update DAO
    }

    override suspend fun insertSampleData() {
        val samples = listOf(
            CulturalLocationEntity(
                id = "loc_mysore_palace",
                name = "Mysore Palace",
                description = "Historical palace in the city of Mysore in Karnataka.",
                state = "Karnataka",
                city = "Mysore",
                district = "Mysore",
                latitude = 12.3051,
                longitude = 76.6552,
                category = "Monument",
                subcategory = "Palace",
                historicalPeriod = "1912",
                significance = "Seat of the Kingdom of Mysore",
                imageUrls = "https://example.com/mysore1.jpg,https://example.com/mysore2.jpg",
                audioUrl = null,
                localLanguage = "Kannada",
                entryFee = "₹100",
                openingHours = "10 AM - 5:30 PM",
                discoveryRadius = 150.0,
                rarity = RarityTier.EPIC.name,
                tags = "Wodeyar,Heritage,Architecture"
            ),
            CulturalLocationEntity(
                id = "loc_hampi",
                name = "Virupaksha Temple, Hampi",
                description = "Part of the Group of Monuments at Hampi, a UNESCO World Heritage Site.",
                state = "Karnataka",
                city = "Hampi",
                district = "Vijayanagara",
                latitude = 15.3350,
                longitude = 76.4590,
                category = "Temple",
                subcategory = "UNESCO Heritage",
                historicalPeriod = "7th Century",
                significance = "Lord Virupaksha, Vijayanagara Empire",
                imageUrls = "https://example.com/hampi1.jpg",
                audioUrl = null,
                localLanguage = "Kannada",
                entryFee = "Free",
                openingHours = "6 AM - 6 PM",
                discoveryRadius = 200.0,
                rarity = RarityTier.LEGENDARY.name,
                tags = "Vijayanagara,UNESCO,Temple"
            ),
            CulturalLocationEntity(
                id = "loc_bengaluru_palace",
                name = "Bengaluru Palace",
                description = "Palace inspired by Windsor Castle in England.",
                state = "Karnataka",
                city = "Bengaluru",
                district = "Bengaluru Urban",
                latitude = 12.9988,
                longitude = 77.5921,
                category = "Monument",
                subcategory = "Palace",
                historicalPeriod = "1878",
                significance = "Tudor-style architecture",
                imageUrls = "https://example.com/bengaluru1.jpg",
                audioUrl = null,
                localLanguage = "Kannada",
                entryFee = "₹480",
                openingHours = "10 AM - 5:30 PM",
                discoveryRadius = 100.0,
                rarity = RarityTier.RARE.name,
                tags = "Tudor,Bengaluru,Heritage"
            ),
            CulturalLocationEntity(
                id = "loc_lalbagh",
                name = "Lalbagh Botanical Garden",
                description = "Historical botanical garden in Bengaluru.",
                state = "Karnataka",
                city = "Bengaluru",
                district = "Bengaluru Urban",
                latitude = 12.9507,
                longitude = 77.5848,
                category = "Nature",
                subcategory = "Garden",
                historicalPeriod = "1760",
                significance = "Glass House, Hyder Ali",
                imageUrls = "https://example.com/lalbagh.jpg",
                audioUrl = null,
                localLanguage = "Kannada",
                entryFee = "₹25",
                openingHours = "6 AM - 7 PM",
                discoveryRadius = 300.0,
                rarity = RarityTier.COMMON.name,
                tags = "Garden,Bengaluru,Hyder Ali"
            ),
            CulturalLocationEntity(
                id = "loc_vidhana_soudha",
                name = "Vidhana Soudha",
                description = "Seat of the state legislature of Karnataka.",
                state = "Karnataka",
                city = "Bengaluru",
                district = "Bengaluru Urban",
                latitude = 12.9796,
                longitude = 77.5906,
                category = "Government",
                subcategory = "Landmark",
                historicalPeriod = "1956",
                significance = "Neo-Dravidian architecture",
                imageUrls = "https://example.com/vidhana.jpg",
                audioUrl = null,
                localLanguage = "Kannada",
                entryFee = "Outside view only",
                openingHours = "24/7",
                discoveryRadius = 150.0,
                rarity = RarityTier.UNCOMMON.name,
                tags = "Government,Bengaluru,Architecture"
            )
        )
        dao.insertLocations(samples)
    }
}

package com.example.carehomeapp

/**
 * Data class representing a Care Home.
 */
data class CareHome(
    val id: String,
    val name: String,
    val location: String,
    val isAvailable: Boolean,
    val rating: Int,
    val imageRes: Int,
    val starIcons: List<Int>
)

/**
 * Enum representing the sorting options for the care home list.
 */
enum class SortOption {
    DISTANCE,
    RATING,
    NEWEST
}

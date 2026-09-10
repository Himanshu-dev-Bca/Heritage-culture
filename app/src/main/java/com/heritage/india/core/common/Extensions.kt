package com.heritage.india.core.common

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import kotlin.math.*

fun LatLng.distanceTo(other: LatLng): Double {
    val earthRadius = 6371000.0 // meters
    val dLat = Math.toRadians(other.latitude - this.latitude)
    val dLng = Math.toRadians(other.longitude - this.longitude)
    val a = sin(dLat / 2).pow(2) +
            cos(Math.toRadians(this.latitude)) * cos(Math.toRadians(other.latitude)) *
            sin(dLng / 2).pow(2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return earthRadius * c
}

fun Location.toLatLng(): LatLng = LatLng(this.latitude, this.longitude)

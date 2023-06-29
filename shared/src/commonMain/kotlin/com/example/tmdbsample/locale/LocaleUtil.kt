package com.example.tmdbsample.locale

import com.example.tmdbsample.models.Region

expect fun getDeviceLocaleCountryCode(): String

fun getDeviceRegion(): Region {
    val platformCountryCode = getDeviceLocaleCountryCode()
    return Region.values()
        .find { it.isoCode == platformCountryCode } ?: Region.Default
}
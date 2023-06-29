package com.example.tmdbsample.locale

import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale

actual fun getDeviceLocaleCountryCode(): String {
    return NSLocale.currentLocale.countryCode ?: "US"
}
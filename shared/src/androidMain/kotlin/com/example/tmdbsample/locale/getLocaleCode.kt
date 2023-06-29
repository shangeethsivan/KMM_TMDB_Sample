package com.example.tmdbsample.locale

import java.util.Locale

actual fun getDeviceLocaleCountryCode(): String {
    return Locale.getDefault().country
}
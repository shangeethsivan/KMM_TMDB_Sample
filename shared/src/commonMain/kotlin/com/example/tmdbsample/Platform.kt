package com.example.tmdbsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
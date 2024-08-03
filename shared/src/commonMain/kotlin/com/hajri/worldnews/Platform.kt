package com.hajri.worldnews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
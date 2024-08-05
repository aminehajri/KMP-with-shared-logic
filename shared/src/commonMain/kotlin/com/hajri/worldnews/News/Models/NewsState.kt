package com.hajri.worldnews.News.Models

data class NewsState(
    val news: List<NewsItem> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
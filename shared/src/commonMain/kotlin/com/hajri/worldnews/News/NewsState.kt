package com.hajri.worldnews.News

data class NewsState(
    val news: List<NewsItem> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
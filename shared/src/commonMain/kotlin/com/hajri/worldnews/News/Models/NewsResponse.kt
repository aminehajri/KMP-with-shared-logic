package com.hajri.worldnews.News.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    @SerialName("articles")
    val newsList: List<NewsItemResponse>
)

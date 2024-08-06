package com.hajri.worldnews.News.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsItemResponse(
    val source: NewsSource,
    val title: String,
    @SerialName("description")
    val desc: String?,
    val publishedAt: String,
    @SerialName("urlToImage")
    val imageUrl: String?
)

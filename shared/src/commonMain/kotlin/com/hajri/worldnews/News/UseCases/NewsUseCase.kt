package com.hajri.worldnews.News.UseCases

import com.hajri.worldnews.News.Models.NewsItem
import com.hajri.worldnews.News.Models.NewsItemResponse
import com.hajri.worldnews.News.RemoteDataSources.NewsRemoteDataSource
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class NewsUseCase(private val newsRemoteDataSource: NewsRemoteDataSource) {

    suspend fun getNews(): List<NewsItem> {
        val newsResponse = newsRemoteDataSource.fetchNewsList()
        return mapNews(newsResponse)
    }

    private fun mapNews(newsResponse: List<NewsItemResponse>): List<NewsItem> {
        return newsResponse
            .filter { item ->
                !item.imageUrl.isNullOrEmpty()
            }.map { item ->
                NewsItem(
                    title = item.title,
                    desc = item.desc
                        ?: "The publisher hasn't added any description for this article.",
                    date = getDaysAgoString(item.publishedAt),
                    imageUrl = item.imageUrl!!,
                    publisher = item.source.name
                )
            }
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }

}
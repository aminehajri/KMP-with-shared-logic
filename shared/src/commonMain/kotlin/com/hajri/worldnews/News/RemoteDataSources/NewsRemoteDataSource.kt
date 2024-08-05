package com.hajri.worldnews.News.RemoteDataSources

import com.hajri.worldnews.News.Models.NewsItemResponse
import com.hajri.worldnews.News.Models.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsRemoteDataSource(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "sport"

    // You can create your own key from : https://newsapi.org
    private val apiKey = ApiKeys.NEWS_API_KEY

    suspend fun fetchNewsList(): List<NewsItemResponse> {
        val response: NewsResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.newsList
    }
}
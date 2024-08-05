package com.hajri.worldnews.News.ViewModels

import com.hajri.worldnews.News.ViewModels.BaseViewModel
import com.hajri.worldnews.News.Models.NewsItem
import com.hajri.worldnews.News.Models.NewsState
import com.hajri.worldnews.News.RemoteDataSources.NewsRemoteDataSource
import com.hajri.worldnews.News.UseCases.NewsUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class NewsViewModel : BaseViewModel() {

    private val _newsState: MutableStateFlow<NewsState> =
        MutableStateFlow(NewsState(loading = true))
    val newsState: StateFlow<NewsState> = _newsState

   private val newsUseCase: NewsUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val remoteDataSource = NewsRemoteDataSource(httpClient = httpClient)

        newsUseCase = NewsUseCase(newsRemoteDataSource = remoteDataSource)

        getNews()
    }

    private fun getNews() {
        scope.launch {
            val fetchedNews = newsUseCase.getNews()
            _newsState.emit(NewsState(news = fetchedNews))
        }
    }

}
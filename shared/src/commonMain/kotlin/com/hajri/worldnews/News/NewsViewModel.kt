package com.hajri.worldnews.News

import com.hajri.worldnews.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : BaseViewModel() {

    private val _newsState: MutableStateFlow<NewsState> =
        MutableStateFlow(NewsState(loading = true))
    val newsState: StateFlow<NewsState> = _newsState

    private val newsList = listOf(
        NewsItem(
            title = "Share a piece of logic",
            content = "Improve your app’s stability by sharing an isolated and critical part of the app. Reuse the Kotlin code you already have to keep the applications in sync.",
            date = "01.01.2024",
            imageUrl = "https://images.unsplash.com/photo-1632006155272-b30a9f6f2aac?q=80&w=1886&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        NewsItem(
            title = "Share a piece of logic",
            content = "Improve your app’s stability by sharing an isolated and critical part of the app. Reuse the Kotlin code you already have to keep the applications in sync.",
            date = "01.01.2024",
            imageUrl = "https://images.unsplash.com/photo-1633936478473-e75c1252cccf?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        NewsItem(
            title = "Share a piece of logic",
            content = "Improve your app’s stability by sharing an isolated and critical part of the app. Reuse the Kotlin code you already have to keep the applications in sync.",
            date = "01.01.2024",
            imageUrl = "https://images.unsplash.com/photo-1556011573-875fbbf761fd?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        )
    )

    init {
        getNews()
    }

    //TODO("fetch news from API")
    private fun getNews() {
        scope.launch {
            fetchNews()
            delay(1000)
            _newsState.emit(NewsState(news = fetchNews()))
        }
    }

    suspend fun fetchNews(): List<NewsItem> = newsList

}
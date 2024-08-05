package com.hajri.worldnews.News.ViewModels

import com.hajri.worldnews.BaseViewModel
import com.hajri.worldnews.News.Models.NewsState
import com.hajri.worldnews.News.UseCases.NewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsUseCase: NewsUseCase
) : BaseViewModel() {

    private val _newsState: MutableStateFlow<NewsState> =
        MutableStateFlow(NewsState(loading = true))
    val newsState: StateFlow<NewsState> = _newsState

    init {
        getNews()
    }

    private fun getNews() {
        scope.launch {
            val fetchedNews = newsUseCase.getNews()
            _newsState.emit(NewsState(news = fetchedNews))
        }
    }

}
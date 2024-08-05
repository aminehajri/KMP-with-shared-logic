package com.hajri.worldnews.Di

import com.hajri.worldnews.News.ViewModels.NewsViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsInjector: KoinComponent {

    val newsViewModel: NewsViewModel by inject()
}
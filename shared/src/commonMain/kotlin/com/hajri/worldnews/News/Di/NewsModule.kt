package com.hajri.worldnews.News.Di

import com.hajri.worldnews.News.RemoteDataSources.NewsRemoteDataSource
import com.hajri.worldnews.News.UseCases.NewsUseCase
import com.hajri.worldnews.News.ViewModels.NewsViewModel
import org.koin.dsl.module

val newsModule = module {

    single<NewsRemoteDataSource> { NewsRemoteDataSource(get()) }
    single<NewsUseCase> { NewsUseCase(get()) }
    single<NewsViewModel> { NewsViewModel(get()) }
}
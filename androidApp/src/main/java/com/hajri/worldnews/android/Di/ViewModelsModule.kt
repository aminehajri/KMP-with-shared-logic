package com.hajri.worldnews.android.Di

import com.hajri.worldnews.News.ViewModels.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { NewsViewModel(get()) }
}
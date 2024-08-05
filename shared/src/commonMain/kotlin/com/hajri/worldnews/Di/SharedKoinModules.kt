package com.hajri.worldnews.Di

import com.hajri.worldnews.News.Di.newsModule

val sharedKoinModules = listOf(
    newsModule,
    networkModule
)
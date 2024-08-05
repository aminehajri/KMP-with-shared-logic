package com.hajri.worldnews.Di

import org.koin.core.context.startKoin

fun initKoin() {

    val modules = sharedKoinModules

    startKoin {
        modules(modules = modules)
    }
}
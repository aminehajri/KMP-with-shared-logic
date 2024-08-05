package com.hajri.worldnews.android

import android.app.Application
import com.hajri.worldnews.Di.sharedKoinModules
import com.hajri.worldnews.android.Di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@NewsApp)
            modules(modules = modules)
        }
    }
}
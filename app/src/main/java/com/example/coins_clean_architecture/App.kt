package com.example.coins_clean_architecture

import android.app.Application
import com.example.coins_clean_architecture.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(AppModule,viewModel))
        }
    }
}
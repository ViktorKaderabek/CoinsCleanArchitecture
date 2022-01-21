package com.example.coins_clean_architecture

import android.app.Application
import com.example.coins_clean_architecture.di.getApi
import com.example.coins_clean_architecture.di.getRepository
import com.example.coins_clean_architecture.di.getUseCase
import com.example.coins_clean_architecture.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(getRepository,viewModel, getApi, getUseCase))
        }
    }
}
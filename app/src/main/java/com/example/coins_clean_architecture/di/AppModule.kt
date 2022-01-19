package com.example.coins_clean_architecture.di

import com.example.coins_clean_architecture.common.Constants
import com.example.coins_clean_architecture.data.remote.CoinPaprikaApi
import com.example.coins_clean_architecture.data.repository.CoinRepositoryImpl
import com.example.coins_clean_architecture.domain.repository.CoinRepository
import com.example.coins_clean_architecture.domain.use_case.GetCoinsUseCase
import com.example.coins_clean_architecture.presentation.MainViewModel
import io.ktor.routing.RouteSelectorEvaluation.Companion.Constant
import org.koin.androidx.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val AppModule = module {

    fun getRepository() : CoinRepository {
        return CoinRepositoryImpl()
    }

    fun proivdePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    single { proivdePaprikaApi() }

    single { getRepository() }
}

val viewModel = module {
    viewModel{
        MainViewModel()
    }
}
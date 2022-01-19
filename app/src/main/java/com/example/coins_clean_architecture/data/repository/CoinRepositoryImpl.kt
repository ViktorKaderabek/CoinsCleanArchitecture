package com.example.coins_clean_architecture.data.repository

import com.example.coins_clean_architecture.data.remote.CoinPaprikaApi
import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem
import com.example.coins_clean_architecture.domain.repository.CoinRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CoinRepositoryImpl() : CoinRepository,KoinComponent {

    private val api : CoinPaprikaApi by inject()

    override suspend fun getCoins(): List<CoinsDtoItem> {
       return api.getCoins()
    }
}
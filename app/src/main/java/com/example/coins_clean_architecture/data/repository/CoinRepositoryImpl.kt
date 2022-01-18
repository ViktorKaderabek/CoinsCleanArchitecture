package com.example.coins_clean_architecture.data.repository

import com.example.coins_clean_architecture.data.remote.CoinPaprikaApi
import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem
import com.example.coins_clean_architecture.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val api : CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinsDtoItem> {
       return api.getCoins()
    }
}
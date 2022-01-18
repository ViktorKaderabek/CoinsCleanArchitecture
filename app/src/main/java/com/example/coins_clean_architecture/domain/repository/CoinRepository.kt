package com.example.coins_clean_architecture.domain.repository

import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem

interface CoinRepository {
    suspend fun getCoins() : List<CoinsDtoItem>
}
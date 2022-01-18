package com.example.coins_clean_architecture.data.remote

import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET
    suspend fun getCoins() : List<CoinsDtoItem>
}
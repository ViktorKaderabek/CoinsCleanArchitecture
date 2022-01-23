package com.example.coins_clean_architecture.data.repository

import android.util.Log
import com.example.coins_clean_architecture.common.Resource
import com.example.coins_clean_architecture.data.remote.CoinPaprikaApi
import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem
import com.example.coins_clean_architecture.data.remote.dto.toCoins
import com.example.coins_clean_architecture.domain.model.Coins
import com.example.coins_clean_architecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import java.io.IOException

class CoinRepositoryImpl(
private val api : CoinPaprikaApi)
: CoinRepository{



    override suspend fun getCoins(): List<CoinsDtoItem> {
       return api.getCoins()
    }



}
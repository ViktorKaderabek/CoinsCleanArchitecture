package com.example.coins_clean_architecture.domain.use_case

import com.example.coins_clean_architecture.common.Resource
import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem
import com.example.coins_clean_architecture.data.remote.dto.toCoins
import com.example.coins_clean_architecture.data.repository.CoinRepositoryImpl
import com.example.coins_clean_architecture.domain.model.Coins
import com.example.coins_clean_architecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase() : KoinComponent{

    private val repository: CoinRepository by inject()

    operator fun invoke(): Flow<Resource<List<Coins>>> = flow {

        try
        {
            emit(Resource.Loading<List<Coins>>())
            val coins = repository.getCoins().map { it.toCoins() }
            emit(Resource.Success<List<Coins>>(coins))
        }
        catch (e: HttpException)
        {
            emit(Resource.Error<List<Coins>>("Error has occured"))
        }
        catch (e: IOException)
        {
            emit(Resource.Error<List<Coins>>("Error has occured"))
        }

    }

}
package com.example.coins_clean_architecture.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins_clean_architecture.common.Resource
import com.example.coins_clean_architecture.domain.use_case.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel():ViewModel(),KoinComponent {

    private val useCase by inject<GetCoinsUseCase>()

    private val _state = mutableStateOf(CoinsListState())
    val state: State<CoinsListState> = _state

    private fun getCoins() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinsListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
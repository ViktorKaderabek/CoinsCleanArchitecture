package com.example.coins_clean_architecture.presentation

import com.example.coins_clean_architecture.data.remote.dto.CoinsDto
import com.example.coins_clean_architecture.data.remote.dto.CoinsDtoItem
import com.example.coins_clean_architecture.domain.model.Coins

data class CoinsListState(
    val isLoading : Boolean = false,
    var coins : List<Coins> = emptyList(),
    val error : String? = null
)

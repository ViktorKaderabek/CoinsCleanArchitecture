package com.example.coins_clean_architecture.data.remote.dto

import com.example.coins_clean_architecture.domain.model.Coins

data class CoinsDtoItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDtoItem.toCoins() : Coins {
    return Coins(
        id = id,
        is_active = is_active,
        name = name,
        symbol = symbol,
        type = type
    )
}
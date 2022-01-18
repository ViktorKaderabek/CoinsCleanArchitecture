package com.example.coins_clean_architecture.domain.model

data class Coins(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val symbol: String,
    val type: String
)
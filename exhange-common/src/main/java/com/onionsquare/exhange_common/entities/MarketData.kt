package com.onionsquare.exhange_common.entities

data class MarketData(
    val pair: String,
    val currentPrice: Double,
    val priceChange: Double,
    val priceChangePercentage: Double,
    val high: Double,
    val low: Double
)
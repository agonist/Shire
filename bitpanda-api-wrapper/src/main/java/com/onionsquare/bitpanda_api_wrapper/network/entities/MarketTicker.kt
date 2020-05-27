package com.onionsquare.bitpanda_api_wrapper.network.entities

import com.squareup.moshi.Json

data class MarketTicker(

    @Json(name = "instrument_code")
    val instrumentCode: String,

    @Json(name = "sequence")
    val sequence: Int,

    @Json(name = "time")
    val time: String,

    @Json(name = "state")
    val state: String,

    @Json(name = "is_frozen")
    val isFrozen: Short,

    @Json(name = "quote_volume")
    val quoteVolume: Double,

    @Json(name = "base_volume")
    val baseVolume: Double,

    @Json(name = "last_price")
    val lastPrice: Double,

    @Json(name = "best_bid")
    val bestBid: Double,

    @Json(name = "best_ask")
    val bestAsk: Double,

    @Json(name = "price_change")
    val priceChange: Double,

    @Json(name = "price_change_percentage")
    val priceChangePercentage: Double,

    @Json(name = "high")
    val high: Double,

    @Json(name = "low")
    val low: Double
)
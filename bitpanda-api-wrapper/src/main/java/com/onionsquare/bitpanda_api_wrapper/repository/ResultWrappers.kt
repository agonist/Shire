package com.onionsquare.bitpanda_api_wrapper.repository

import com.onionsquare.bitpanda_api_wrapper.network.entities.MarketTicker


sealed class MarketTickerResult {
    data class Success(val marketTickers: List<MarketTicker>) :
        MarketTickerResult()

    data class Error(val e: Exception) : MarketTickerResult()
}
package com.onionsquare.bitpanda_api_wrapper.network

import com.onionsquare.bitpanda_api_wrapper.network.entities.MarketTicker
import retrofit2.Response
import retrofit2.http.GET

interface BitpandaApi {

    @GET("/public/v1/market-ticker")
    suspend fun marketTicker(): Response<List<MarketTicker>>

}
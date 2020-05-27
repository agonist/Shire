package com.onionsquare.bitpanda_api_wrapper.repository

import kotlinx.coroutines.flow.Flow

interface BitpandaRepository {

    suspend fun marketData(): Flow<MarketTickerResult>

}
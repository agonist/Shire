package com.onionsquare.exhange_common.domain

import com.onionsquare.exhange_common.entities.MarketData
import kotlinx.coroutines.flow.Flow

interface GetLastMarketData {

    suspend fun getLastMarketData(): Flow<MarketDataState>

}

sealed class MarketDataState {
    object Init : MarketDataState()
    object Loading : MarketDataState()
    data class Success(val marketData: List<MarketData>) : MarketDataState()
    data class Error(val e: Exception) : MarketDataState()
}
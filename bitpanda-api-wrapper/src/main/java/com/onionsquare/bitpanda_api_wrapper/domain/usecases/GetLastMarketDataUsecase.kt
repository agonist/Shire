package com.onionsquare.bitpanda_api_wrapper.domain.usecases

import com.onionsquare.bitpanda_api_wrapper.domain.mapper.MarketTickerListMapper
import com.onionsquare.bitpanda_api_wrapper.repository.BitpandaRepository
import com.onionsquare.bitpanda_api_wrapper.repository.MarketTickerResult
import com.onionsquare.exhange_common.domain.GetLastMarketData
import com.onionsquare.exhange_common.domain.MarketDataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLastMarketDataUsecase(
    private val repoitory: BitpandaRepository,
    private val mapper: MarketTickerListMapper
) : GetLastMarketData {

    override suspend fun getLastMarketData(): Flow<MarketDataState> {
        return repoitory.marketData().map {
            when (it) {
                is MarketTickerResult.Success -> MarketDataState.Success(mapper.toMarketData(it.marketTickers))
                is MarketTickerResult.Error -> MarketDataState.Error(it.e)
            }
        }
    }
}
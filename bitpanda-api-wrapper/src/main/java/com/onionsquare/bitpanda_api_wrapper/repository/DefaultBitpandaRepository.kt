package com.onionsquare.bitpanda_api_wrapper.repository

import com.onionsquare.bitpanda_api_wrapper.network.BitpandaApi
import com.onionsquare.exhange_common.entities.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultBitpandaRepository(val bitpandaApi: BitpandaApi) : BaseRepository(),
    BitpandaRepository {

    override suspend fun marketData(): Flow<MarketTickerResult> {
        return flow {
            when (val result = apiCall { bitpandaApi.marketTicker() }) {
                is Result.Success -> emit(MarketTickerResult.Success(result.data))
                is Result.Error -> emit(MarketTickerResult.Error(result.exception))
            }
        }
    }
}

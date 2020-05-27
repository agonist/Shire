package com.onionsquare.bitpanda_api_wrapper.ioc

import com.onionsquare.bitpanda_api_wrapper.repository.BitpandaRepository
import com.onionsquare.bitpanda_api_wrapper.repository.DefaultBitpandaRepository
import com.onionsquare.bitpanda_api_wrapper.domain.usecases.GetLastMarketDataUsecase
import com.onionsquare.bitpanda_api_wrapper.domain.mapper.MarketTickerListMapper
import com.onionsquare.exhange_common.domain.GetLastMarketData
import org.koin.dsl.module

val bitpandaModule = module {
    single<BitpandaRepository> { DefaultBitpandaRepository(get()) }
    factory<GetLastMarketData> {
        GetLastMarketDataUsecase(
            get(),
            MarketTickerListMapper()
        )
    }
}
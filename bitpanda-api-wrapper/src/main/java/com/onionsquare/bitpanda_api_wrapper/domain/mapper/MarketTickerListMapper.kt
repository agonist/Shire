package com.onionsquare.bitpanda_api_wrapper.domain.mapper

import com.onionsquare.bitpanda_api_wrapper.network.entities.MarketTicker
import com.onionsquare.exhange_common.domain.mapper.CommonEntityMapper
import com.onionsquare.exhange_common.entities.MarketData

class MarketTickerListMapper : CommonEntityMapper<List<MarketTicker>> {

    override fun toMarketData(toConvert: List<MarketTicker>): List<MarketData> {
        val converted = arrayListOf<MarketData>()
        toConvert.forEach {
            converted.add(
                MarketData(
                    it.instrumentCode,
                    it.lastPrice,
                    it.priceChange,
                    it.priceChangePercentage,
                    it.high,
                    it.low
                )
            )
        }
        return converted
    }
}
package com.onionsquare.exhange_common.domain.mapper

import com.onionsquare.exhange_common.entities.MarketData

interface CommonEntityMapper<T> {

    fun toMarketData(toConvert: T): List<MarketData>

}
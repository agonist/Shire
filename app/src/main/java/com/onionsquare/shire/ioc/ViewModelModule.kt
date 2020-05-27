package com.onionsquare.shire.ioc

import com.onionsquare.shire.features.market.MarketViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MarketViewModel(get()) }
}
package com.onionsquare.shire.features.market

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onionsquare.exhange_common.domain.GetLastMarketData
import com.onionsquare.exhange_common.domain.MarketDataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MarketViewModel(val f: GetLastMarketData) : ViewModel() {

    val marketData: StateFlow<MarketDataState> get() = _marketData
    private val _marketData: MutableStateFlow<MarketDataState> =
        MutableStateFlow(MarketDataState.Init)

    fun test() {
        viewModelScope.launch {
            f.getLastMarketData()
                .onStart { _marketData.value = MarketDataState.Loading }
                .collect {
                    _marketData.value = it
                }
        }
    }

}
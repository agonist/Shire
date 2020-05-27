package com.onionsquare.shire.features.market

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.onionsquare.exhange_common.domain.MarketDataState
import com.onionsquare.exhange_common.entities.MarketData
import com.onionsquare.shire.R
import com.onionsquare.shire.utils.gone
import com.onionsquare.shire.utils.visible
import kotlinx.android.synthetic.main.fragment_market.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarketFragment : Fragment(R.layout.fragment_market) {

    private val viewModel: MarketViewModel by viewModel()
    private val itemAdapter = ItemAdapter<MarketDataItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fastAdapter = FastAdapter.with(itemAdapter)
        market_data_recycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = fastAdapter
        }

        lifecycleScope.launch {
            viewModel.marketData.collect {
                when (it) {
                    is MarketDataState.Loading -> {
                        market_data_progress.visible()
                        market_data_recycler.gone()
                    }
                    is MarketDataState.Success -> {
                        market_data_progress.gone()
                        market_data_recycler.visible()
                        addMarketData(it.marketData)
                    }
                    is MarketDataState.Error -> {
                    }
                }
            }
        }
        viewModel.test()
    }

    private fun addMarketData(items: List<MarketData>) {
        val marketDataItems = arrayListOf<MarketDataItem>()
        items.forEach {
            marketDataItems.add(MarketDataItem(it))
        }
        itemAdapter.add(marketDataItems)
    }
}


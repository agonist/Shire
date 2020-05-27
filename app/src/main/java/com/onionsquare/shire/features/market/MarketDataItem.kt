package com.onionsquare.shire.features.market

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.onionsquare.exhange_common.entities.MarketData
import com.onionsquare.shire.R
import kotlinx.android.synthetic.main.item_market_data.view.*

open class MarketDataItem(val marketData: MarketData) : AbstractItem<MarketDataItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.item_market_data
    override val type: Int
        get() = R.id.item_market_data

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(private val view: View) : FastAdapter.ViewHolder<MarketDataItem>(view) {
        override fun bindView(item: MarketDataItem, payloads: List<Any>) {
            view.market_data_pair.text = item.marketData.pair
            view.market_data_last_price.text = item.marketData.currentPrice.toString()
            view.market_data_percentage_change.text =
                item.marketData.priceChangePercentage.toString()
        }

        override fun unbindView(item: MarketDataItem) {
        }
    }

}
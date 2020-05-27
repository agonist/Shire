package com.onionsquare.shire

import android.app.Application
import com.onionsquare.bitpanda_api_wrapper.ioc.BitpandaModuleProvider
import com.onionsquare.bitpanda_api_wrapper.ioc.bitpandaModule
import com.onionsquare.bitpanda_api_wrapper.ioc.bitpandaNetworkModule
import com.onionsquare.shire.ioc.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShireApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShireApp)
            modules(listOf(viewModelModule))
            modules(BitpandaModuleProvider().provideModules())
        }

    }

}
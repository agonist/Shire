package com.onionsquare.bitpanda_api_wrapper.ioc

import org.koin.core.module.Module

class BitpandaModuleProvider {

    fun provideModules(): List<Module> {
        return listOf(bitpandaNetworkModule, bitpandaModule)
    }

}
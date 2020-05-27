package com.onionsquare.bitpanda_api_wrapper.ioc

import com.onionsquare.bitpanda_api_wrapper.network.BitpandaApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val bitpandaNetworkModule = module {
    single { provideMoshi() }
    single { provideOkhttpClient() }
    single {
        provideRetrofit(
            get(),
            get(),
            "https://api.exchange.bitpanda.com/public/"
        )
    }
    single { provideService(get()) }
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(40, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor())
        .build()
}


fun provideRetrofit(client: OkHttpClient, moshi: Moshi, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}


fun provideService(retrofit: Retrofit): BitpandaApi =
    retrofit.create(BitpandaApi::class.java)


private fun loggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}
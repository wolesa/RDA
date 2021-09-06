package com.wj.data

import com.wj.data.api.BreweriesApi
import com.wj.data.repo.BreweryRepoImpl
import com.wj.domain.repo.BreweryRepo
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    val BASE_URL = "https://api.openbrewerydb.org/"

    single<BreweryRepo> { BreweryRepoImpl(get()) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(get())
            .build()
    }

    single<BreweriesApi> {
        get<Retrofit>().create(
            BreweriesApi::class.java
        )
    }

}
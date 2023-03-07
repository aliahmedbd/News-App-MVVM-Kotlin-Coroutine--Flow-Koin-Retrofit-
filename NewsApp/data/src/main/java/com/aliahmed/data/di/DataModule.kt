package com.aliahmed.data.di

import android.content.Context
import com.aliahmed.data.network.APIClient
import com.aliahmed.data.network.APIService
import com.aliahmed.data.repository.DataRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single(named("data_repo")) { DataRepository(NetworkModule(androidContext())) }
}

class NetworkModule(val context: Context) {
    fun sourceOfNetwork(): APIService {
        return APIClient.create(context)
    }
}
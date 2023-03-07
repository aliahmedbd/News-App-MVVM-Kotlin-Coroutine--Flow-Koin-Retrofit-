package com.aliahmed.datamodule.di

import android.content.Context
import com.aliahmed.datamodule.network.APIClient
import com.aliahmed.datamodule.network.APIService
import com.aliahmed.datamodule.repository.DataRepository
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
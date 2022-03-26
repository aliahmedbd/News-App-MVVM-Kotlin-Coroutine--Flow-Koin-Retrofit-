package com.example.androidcleanarchitecture.di

import android.content.Context
import com.example.androidcleanarchitecture.network.APIClient
import com.example.androidcleanarchitecture.network.APIService
import com.example.androidcleanarchitecture.repository.DataRepository
import com.example.androidcleanarchitecture.viewmodel.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("data_repo")) { DataRepository(NetworkModule(androidContext())) }
    viewModel { NewsViewModel(get(named("data_repo"))) }
}

class NetworkModule(val context: Context) {
    fun sourceOfNetwork(): APIService {
        return APIClient.create()
    }
}
package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.network.APIClient
import com.example.newsapp.network.APIService
import com.example.newsapp.repository.DataRepository
import com.example.newsapp.viewmodel.NewsViewModel
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
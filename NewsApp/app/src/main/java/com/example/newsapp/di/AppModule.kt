package com.example.newsapp.di

import com.example.newsapp.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    viewModel { NewsViewModel(get(named("data_repo"))) }
}


package com.example.androidcleanarchitecture.di

import android.content.Context
import com.example.androidcleanarchitecture.network.APIClient
import com.example.androidcleanarchitecture.network.APIService
import org.koin.dsl.module

val appModule = module {

}

class NetworkModule (val context: Context) {
    fun sourceOfNetwork() : APIService {
        return APIClient.create()
    }
}
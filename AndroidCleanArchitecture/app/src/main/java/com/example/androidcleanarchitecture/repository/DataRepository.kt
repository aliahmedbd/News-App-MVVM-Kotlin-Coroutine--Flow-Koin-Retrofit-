package com.example.androidcleanarchitecture.repository

import com.example.androidcleanarchitecture.di.NetworkModule
import com.example.androidcleanarchitecture.model.NewsMainResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class DataRepository(var networkModule: NetworkModule) {

    suspend fun getNewsFromNetwork(): Flow<Response<NewsMainResponse>> {
        return flow<Response<NewsMainResponse>> {
            val response = networkModule.sourceOfNetwork().getNews()
            emit(response)
        }
    }
}
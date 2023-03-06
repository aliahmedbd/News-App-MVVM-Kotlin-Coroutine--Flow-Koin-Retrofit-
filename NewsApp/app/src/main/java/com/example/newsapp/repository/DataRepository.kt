package com.example.newsapp.repository

import com.example.newsapp.datamodel.NewsResponse
import com.example.newsapp.di.NetworkModule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class DataRepository(var networkModule: NetworkModule) {

    suspend fun getNewsFromNetwork(category : String, query: String?): Flow<Response<NewsResponse>> {
        return flow<Response<NewsResponse>> {
            val response = networkModule.sourceOfNetwork().getNews(category = category, query = query)
            emit(response)
        }
    }

    suspend fun getLatestHeadlines(country : String?= "UK"): Flow<Response<NewsResponse>> {
        return flow<Response<NewsResponse>> {
            val response = networkModule.sourceOfNetwork().getLatestHeadline(country)
            emit(response)
        }
    }
}
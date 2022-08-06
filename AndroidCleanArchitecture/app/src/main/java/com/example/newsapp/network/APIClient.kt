package com.example.newsapp.network

import com.example.newsapp.network.URL.baseURL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        private const val BASE_URL = baseURL

        fun create(): APIService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .addNetworkInterceptor{ chain ->
                    val request = chain.request()
                    request.newBuilder().addHeader("x-api-key", "1U9CeisPCnXgoZUOJqsDN0KDHY3FkXwvw1Lgu2BPTiw").build()
                    chain.proceed(request)
                }
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
        }
    }
}
package com.aliahmed.datamodule.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.aliahmed.datamodule.network.URL.baseURL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        private const val BASE_URL = baseURL

        fun create(context: Context): APIService {
            val client = OkHttpClient.Builder().apply {
                addInterceptor(BaseHeadersInterceptor())
                addInterceptor(ChuckerInterceptor(context = context))
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }.build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
        }
    }
}

class BaseHeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            header("x-api-key", URL.apiKey)
        }.build()
        return chain.proceed(request)
    }
}
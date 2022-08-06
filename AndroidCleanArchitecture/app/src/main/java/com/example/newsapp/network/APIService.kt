package com.example.newsapp.network

import com.example.newsapp.model.NewsMainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*

interface APIService {
    @GET(URL.GET_NEWS)
    @Headers("x-api-key: 1U9CeisPCnXgoZUOJqsDN0KDHY3FkXwvw1Lgu2BPTiw"  )
    suspend fun getNews(
        @Query("q") query: String? = "all",
//        @Query("from") from: String? = SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().time),
        @Query("topic") category: String? = "",
//        @Query("sortBy") sortBy: String? = "publishedAt",
//        @Query("apiKey") apiKey: String? = URL.apiKey
    ) : Response<NewsMainResponse>
}
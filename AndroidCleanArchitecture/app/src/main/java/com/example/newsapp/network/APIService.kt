package com.example.newsapp.network

import com.example.newsapp.model.NewsMainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {
    @GET(URL.GET_NEWS)
    @Headers("x-api-key: 1U9CeisPCnXgoZUOJqsDN0KDHY3FkXwvw1Lgu2BPTiw")
    suspend fun getNews(
        @Query("q") query: String? = "all",
        @Query("topic") category: String? = "",
    ): Response<NewsMainResponse>

    @GET(URL.GET_LATEST_NEWS)
    @Headers("x-api-key: 1U9CeisPCnXgoZUOJqsDN0KDHY3FkXwvw1Lgu2BPTiw")
    suspend fun getLatestHeadline(
        @Query("countries") countries : String? = "UK",
        @Query("page_size") pageSize : Int? = 10
    ) : Response<NewsMainResponse>
}
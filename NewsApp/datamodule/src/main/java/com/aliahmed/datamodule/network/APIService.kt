package com.aliahmed.datamodule.network

import com.aliahmed.datamodule.datamodel.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET(URL.GET_NEWS)
    suspend fun getNews(
        @Query("q") query: String? = "all",
        @Query("topic") category: String? = "",
    ): Response<NewsResponse>

    @GET(URL.GET_LATEST_NEWS)
    suspend fun getLatestHeadline(
        @Query("countries") countries : String? = "UK",
        @Query("page_size") pageSize : Int? = 10
    ) : Response<NewsResponse>
}
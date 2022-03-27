package com.example.androidcleanarchitecture.network

import com.example.androidcleanarchitecture.model.NewsMainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*

interface APIService {
    //https://newsapi.org/v2/everything?q=tesla&from=2022-02-26&sortBy=publishedAt&apiKey=83352fa505244e1c86f36d6af0ac59bb
    @GET(URL.GET_NEWS)
    public suspend fun getNews(
        @Query("q") query: String? = "tesla",
        @Query("from") from: String? = SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().time),
        @Query("sortBy") sortBy: String? = "publishedAt",
        @Query("apiKey") apiKey: String? = URL.apiKey
    ) : Response<NewsMainResponse>
}
package com.example.newsapp.model

import Article
import com.google.gson.annotations.SerializedName


data class NewsMainResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("total_hits") val totalHits: Int? = null,
    @SerializedName("page") val page: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("page_size") val pageSize: Int? = null,
    @SerializedName("articles") val articles: List<Article>? = null,
    @SerializedName("user_input") val userInput: UserInput? = null
)
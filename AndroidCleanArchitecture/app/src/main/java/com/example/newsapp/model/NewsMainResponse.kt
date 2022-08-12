package com.example.newsapp.model

import Articles
import com.google.gson.annotations.SerializedName


data class NewsMainResponse(
    @SerializedName("status") val status : String,
    @SerializedName("total_hits") val totalHits : Int,
    @SerializedName("page") val page : Int,
    @SerializedName("total_pages") val totalPages : Int,
    @SerializedName("page_size") val pageSize : Int,
    @SerializedName("articles") val articles : List<Articles>,
    @SerializedName("user_input") val userInput : UserInput
)
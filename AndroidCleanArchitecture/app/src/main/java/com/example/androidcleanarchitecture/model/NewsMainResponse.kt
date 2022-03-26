package com.example.androidcleanarchitecture.model

import com.google.gson.annotations.SerializedName


data class NewsMainResponse(

    @SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: ArrayList<Articles> = arrayListOf()

)
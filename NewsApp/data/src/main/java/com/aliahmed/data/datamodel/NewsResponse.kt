package com.aliahmed.data.datamodel


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("page_size")
    val pageSize: Int? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("total_hits")
    val totalHits: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("user_input")
    val userInput: UserInput? = null
)
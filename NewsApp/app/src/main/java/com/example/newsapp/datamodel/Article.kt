package com.example.newsapp.datamodel


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("authors")
    val authors: String? = null,
    @SerializedName("clean_url")
    val cleanUrl: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("excerpt")
    val excerpt: String? = null,
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("is_opinion")
    val isOpinion: Boolean? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("link")
    val link: String? = null,
    @SerializedName("media")
    val media: String? = null,
    @SerializedName("published_date")
    val publishedDate: String? = null,
    @SerializedName("published_date_precision")
    val publishedDatePrecision: String? = null,
    @SerializedName("rank")
    val rank: Int? = null,
    @SerializedName("rights")
    val rights: String? = null,
    @SerializedName("_score")
    val score: Double? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("topic")
    val topic: String? = null,
    @SerializedName("twitter_account")
    val twitterAccount: String? = null
)
package com.example.newsapp.model
import com.google.gson.annotations.SerializedName

data class Article(

    @SerializedName("title") val title: String? = null,
    // @SerializedName("author") val author : String,
    @SerializedName("published_date") val publishedDate: String? = null,
    @SerializedName("published_date_precision") val publishedDatePrecision: String? = null,
    @SerializedName("link") val link: String? = null,
    @SerializedName("clean_url") val cleanUrl: String? = null,
    @SerializedName("excerpt") val excerpt: String? = null,
    @SerializedName("summary") val summary: String? = null,
    @SerializedName("rights") val rights: String? = null,
    @SerializedName("rank") val rank: Int? = null,
    @SerializedName("topic") val topic: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("language") val language: String? = null,
    //@SerializedName("authors") val authors : List<String>,
    @SerializedName("media") val media: String? = null,
    @SerializedName("is_opinion") val isOpinion: Boolean? = null,
    @SerializedName("twitter_account") val twitterAccount: String? = null,
    @SerializedName("_score") val _core: Double? = null,
    @SerializedName("_id") val id: String? = null
)
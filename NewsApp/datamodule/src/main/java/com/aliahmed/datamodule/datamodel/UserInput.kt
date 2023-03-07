package com.aliahmed.datamodule.datamodel


import com.google.gson.annotations.SerializedName

data class UserInput(
    @SerializedName("countries")
    val countries: Any,
    @SerializedName("from")
    val from: String,
    @SerializedName("from_rank")
    val fromRank: Any,
    @SerializedName("lang")
    val lang: Any,
    @SerializedName("not_countries")
    val notCountries: Any,
    @SerializedName("not_lang")
    val notLang: Any,
    @SerializedName("not_sources")
    val notSources: List<Any>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("published_date_precision")
    val publishedDatePrecision: Any,
    @SerializedName("q")
    val q: String,
    @SerializedName("ranked_only")
    val rankedOnly: String,
    @SerializedName("search_in")
    val searchIn: List<String>,
    @SerializedName("size")
    val size: Int,
    @SerializedName("sort_by")
    val sortBy: String,
    @SerializedName("sources")
    val sources: Any,
    @SerializedName("to")
    val to: Any,
    @SerializedName("to_rank")
    val toRank: Int,
    @SerializedName("topic")
    val topic: Any
)
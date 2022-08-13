package com.example.newsapp.model

import com.google.gson.annotations.SerializedName

data class UserInput (
	@SerializedName("q") val q : String,
	@SerializedName("search_in") val search_in : List<String>,
	@SerializedName("lang") val lang : String,
	@SerializedName("not_lang") val not_lang : String,
	@SerializedName("countries") val countries : List<String>,
	@SerializedName("not_countries") val not_countries : String,
	@SerializedName("from") val from : String,
	@SerializedName("to") val to : String,
	@SerializedName("ranked_only") val ranked_only : Boolean,
	@SerializedName("from_rank") val from_rank : String,
	@SerializedName("to_rank") val to_rank : String,
	@SerializedName("sort_by") val sort_by : String,
	@SerializedName("page") val page : Int,
	@SerializedName("size") val size : Int,
	@SerializedName("sources") val sources : String,
	@SerializedName("not_sources") val not_sources : String,
	@SerializedName("topic") val topic : String,
	@SerializedName("published_date_precision") val published_date_precision : String
)
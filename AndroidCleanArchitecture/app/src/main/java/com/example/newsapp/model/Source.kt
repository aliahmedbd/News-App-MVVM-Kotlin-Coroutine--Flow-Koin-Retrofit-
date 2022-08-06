package com.example.newsapp.model

import com.google.gson.annotations.SerializedName


data class Source(

    @SerializedName("Id") val id : String,
    @SerializedName("Name") val name : String

)
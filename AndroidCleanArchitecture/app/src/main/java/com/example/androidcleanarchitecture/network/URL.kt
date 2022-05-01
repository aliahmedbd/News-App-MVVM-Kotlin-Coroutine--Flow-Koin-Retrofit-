package com.example.androidcleanarchitecture.network

import com.example.androidcleanarchitecture.BuildConfig

object URL {
    public const val apiKey : String = BuildConfig.API_KEY
    public const val baseURL : String = BuildConfig.BASE_URL

    public const val GET_NEWS = "top-headlines"
}
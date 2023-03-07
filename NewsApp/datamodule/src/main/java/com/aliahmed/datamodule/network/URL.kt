package com.aliahmed.datamodule.network

import com.aliahmed.datamodule.BuildConfig

object URL {
    const val apiKey : String = BuildConfig.API_KEY
    const val baseURL : String = BuildConfig.BASE_URL

    const val GET_NEWS = "search"
    const val GET_LATEST_NEWS = "latest_headlines"
}
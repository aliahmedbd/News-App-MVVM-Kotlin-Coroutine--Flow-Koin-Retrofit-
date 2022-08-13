package com.example.newsapp.util

import android.content.Context
import android.content.SharedPreferences
import com.example.newsapp.model.NewsMainResponse
import com.google.gson.Gson

const val SHARED_PREF_NAME = "NEWS"
const val COMPANY_DETAILS_STRING = "ARTICLES"

fun Context.saveCompanyDetailsSharedPref(news: NewsMainResponse?) {
    val mPrefs: SharedPreferences =
        this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    val prefsEditor = mPrefs.edit()
    val gson = Gson()
    val json = gson.toJson(news)
    prefsEditor.putString(COMPANY_DETAILS_STRING, json)
    prefsEditor.commit()
}

fun Context.getCompanyDetailsSharedPref(): NewsMainResponse? {
    val mPrefs: SharedPreferences =
        this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    mPrefs.edit()
    val gson = Gson()
    val json = mPrefs.getString(COMPANY_DETAILS_STRING, "")
    return if (json.equals("", ignoreCase = true)) {
        null
    } else gson.fromJson(json, NewsMainResponse::class.java)
}

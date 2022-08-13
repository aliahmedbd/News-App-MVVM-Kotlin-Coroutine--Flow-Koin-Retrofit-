package com.example.newsapp.viewmodel

import Article
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.NewsMainResponse
import com.example.newsapp.network.ResponseModel
import com.example.newsapp.repository.DataRepository
import com.example.newsapp.util.getCompanyDetailsSharedPref
import com.example.newsapp.util.saveCompanyDetailsSharedPref
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private var dataRepo: DataRepository) : ViewModel() {

    val uiUpdates =
        MutableStateFlow<ResponseModel<Response<NewsMainResponse>>>(ResponseModel.Idle("Idle State"))

    val latestHeadlineUpdate =
        MutableStateFlow<ResponseModel<Response<NewsMainResponse>>>(ResponseModel.Idle("Idle State"))

    val category = MutableStateFlow("")
    val newsURL = MutableStateFlow("")
    val keyword = MutableStateFlow("")

    suspend fun getNews(value: String, query: String?) {
        uiUpdates.emit(ResponseModel.Loading())
        dataRepo.getNewsFromNetwork(value, query).collect {
            viewModelScope.launch {
                if (it.isSuccessful)
                    uiUpdates.emit(ResponseModel.Success(it))
                else
                    uiUpdates.emit(ResponseModel.Error(it.message()))
            }
        }
    }

    suspend fun getLatestHeadline(country: String? = "UK") {
        latestHeadlineUpdate.emit(ResponseModel.Loading())
        dataRepo.getLatestHeadlines(country).collect {
            viewModelScope.launch {
                if (it.isSuccessful)
                    latestHeadlineUpdate.emit(ResponseModel.Success(it))
                else
                    latestHeadlineUpdate.emit(ResponseModel.Error(it.message()))
            }
        }
    }


    suspend fun transmitCategory(value: String) {
        category.emit(value)
    }

    suspend fun transmitNewsURL(value: String) {
        newsURL.emit(value)
    }

    suspend fun transmitKeyword(value: String) {
        keyword.emit(value)
    }

    fun saveArticle(article: Article, context: Context) {
        try {
            val prefArticle =
                Article(title = article.title, id = article.id)
            val articles = getSavedArticles(context)
            if (articles?.any { it.id == article.id } == true) {
                Toast.makeText(context, "Already in favorite.", Toast.LENGTH_LONG).show()
            } else {
                articles?.add(prefArticle)
                val newsMainResponse = NewsMainResponse(articles = articles)
                context.saveCompanyDetailsSharedPref(newsMainResponse)
                Toast.makeText(context, "Saved in favorite list.", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Log.e("error", e.message.toString())
        }

    }

    fun getSavedArticles(context: Context): ArrayList<Article>? {
        val newsMainResponse = context.getCompanyDetailsSharedPref()
        newsMainResponse?.let {
            return it.articles as ArrayList
        }
        return ArrayList()
    }
}
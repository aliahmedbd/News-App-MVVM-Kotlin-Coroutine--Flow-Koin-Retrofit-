package com.example.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.NewsMainResponse
import com.example.newsapp.network.ResponseModel
import com.example.newsapp.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
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

    suspend fun getLatestHeadline(country: String?= "UK") {
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
}
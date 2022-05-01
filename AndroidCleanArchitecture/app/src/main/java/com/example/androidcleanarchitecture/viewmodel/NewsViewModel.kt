package com.example.androidcleanarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcleanarchitecture.model.NewsMainResponse
import com.example.androidcleanarchitecture.network.ResponseModel
import com.example.androidcleanarchitecture.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private var dataRepo: DataRepository) : ViewModel() {

     val uiUpdates =
        MutableStateFlow<ResponseModel<Response<NewsMainResponse>>>(ResponseModel.Idle("Idle State"))

    suspend fun getNews() {
        uiUpdates.emit(ResponseModel.Loading())
        dataRepo.getNewsFromNetwork().collect {
            viewModelScope.launch {
                if (it.isSuccessful)
                    uiUpdates.emit(ResponseModel.Success(it))
                else
                    uiUpdates.emit(ResponseModel.Error(it.message()))
            }
        }
    }

}
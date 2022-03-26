package com.example.androidcleanarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidcleanarchitecture.model.NewsMainResponse
import com.example.androidcleanarchitecture.network.ResponseModel
import com.example.androidcleanarchitecture.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import retrofit2.Response

class NewsViewModel(private var dataRepo: DataRepository) : ViewModel() {

    private val uiUpdates =
        MutableStateFlow<ResponseModel<Response<NewsMainResponse>>>(ResponseModel.Idle("Idel State"))

    suspend fun getNews() {
        uiUpdates.emit(ResponseModel.Loading())
        dataRepo.getNewsFromNetwork().collect {
            if (it.isSuccessful)
                uiUpdates.emit(ResponseModel.Success(it))
            else
                uiUpdates.emit(ResponseModel.Error(it.message()))
        }

    }

}
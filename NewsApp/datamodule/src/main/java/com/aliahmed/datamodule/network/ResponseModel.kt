package com.aliahmed.datamodule.network

sealed class ResponseModel<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResponseModel<T>(data)

    class Error<T>(message: String?, data: T? = null) : ResponseModel<T>(data, message)

    class Loading<T> : ResponseModel<T>()

    class Idle<T>(message: String?) : ResponseModel<T>(null, message)
}

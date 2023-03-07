package com.aliahmed.datamodule.network

/**
 * ResponseModel is a sealed class that is used to represent the result of a network request.
 * It can be either a Success, Error, Loading or Idle response.
 *
 * @param T The type of the data to be returned.
 * @property data The data that is returned as part of the response.
 * @property message A message that provides additional information about the response.
 */
sealed class ResponseModel<T>(
    val data: T? = null,
    val message: String? = null
) {

    /**
     * Represents a successful response from the network request.
     *
     * @param data The data that was returned as part of the response.
     */
    class Success<T>(data: T) : ResponseModel<T>(data)

    /**
     * Represents an error response from the network request.
     *
     * @param message A message that provides additional information about the error.
     * @param data The data that was returned as part of the response (if any).
     */
    class Error<T>(message: String?, data: T? = null) : ResponseModel<T>(data, message)

    /**
     * Represents a response while the network request is still in progress.
     */
    class Loading<T> : ResponseModel<T>()

    /**
     * Represents an idle response, i.e. when no network request has been made yet.
     *
     * @param message A message that provides additional information about the response.
     */
    class Idle<T>(message: String?) : ResponseModel<T>(null, message)
}

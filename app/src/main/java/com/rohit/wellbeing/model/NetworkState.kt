package com.rohit.wellbeing.model

sealed class NetworkState<T>{
    class Loading<T> : NetworkState<T>()

    data class Success<T>(val data: T) : NetworkState<T>()

    data class Error<T>(val message: String) : NetworkState<T>()

    fun isLoading(): Boolean = this is Loading

    fun isSuccessful(): Boolean = this is Success

    fun isFailed(): Boolean = this is Error

    companion object {

        /**
         * Returns [NetworkState.Loading] instance.
         */
        fun <T> loading() = Loading<T>()

        /**
         * Returns [NetworkState.Success] instance.
         * @param data Data to emit with status.
         */
        fun <T> success(data: T) =
            Success(data)

        /**
         * Returns [NetworkState.Error] instance.
         * @param message Description of failure.
         */
        fun <T> error(message: String) =
            Error<T>(message)

    }
}

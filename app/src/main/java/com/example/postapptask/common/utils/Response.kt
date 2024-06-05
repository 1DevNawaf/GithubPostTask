package com.example.postapptask.common.utils

sealed class Response<T> {
    data class Loading<T>(val status: Boolean) : Response<T>()
    data class Success<T>(val data : T) : Response<T>()
    data class Error<T>(val errorCode: Int, val errorMsg: String) : Response<T>()
}
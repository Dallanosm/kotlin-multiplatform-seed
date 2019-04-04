package com.mpp.seed.common

sealed class Result {
    data class List<T>(val data: kotlin.collections.List<T>) : Result()
    data class Single<T>(val data: T) : Result()
    data class Update<T>(val data: T) : Result()
    data class Token<T>(val data: T, val token: String) : Result()
    data class Delete<T>(val data: Int) : Result()

    data class Error(val code: Int, val message: String) : Result()
}
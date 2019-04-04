package com.mpp.seed.common

sealed class Result {
    class Success<T> : Result()
    sealed class Error : Result() {
        sealed class Network : Error() {
            object NoInternet : Network()
            object ServerNotResponding : Network()
        }

        sealed class Local : Error() {
            object Write : Local()
        }
    }
}

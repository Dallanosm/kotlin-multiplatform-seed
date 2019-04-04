package com.mpp.seed.commonmobile.error

import com.mpp.seed.common.Result


interface ErrorConverter {
    fun convert(error: Result.Error): String
}
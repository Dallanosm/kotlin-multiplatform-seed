package com.mpp.seed.android.error

import android.content.Context
import com.mpp.seed.common.Result
import com.mpp.seed.commonmobile.error.ErrorConverter

class AndroidErrorConverter(private val context: Context) : ErrorConverter {

    override fun convert(error: Result.Error): String {
        // TODO "not implemented"
        return ""
    }
}
package com.nosmurf.android.error

import android.content.Context
import com.nosmurf.android.R
import com.nosmurf.common.domain.error.Error
import com.nosmurf.common.domain.error.ErrorHandler

class AndroidErrorHandler(private val context: Context) : ErrorHandler {

    override fun convert(error: Error): String =
        when (error) {
            else -> context.getString(R.string.default_error)
        }

}
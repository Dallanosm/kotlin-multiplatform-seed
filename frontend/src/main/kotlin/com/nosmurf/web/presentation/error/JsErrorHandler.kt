package com.nosmurf.web.presentation.error

import com.nosmurf.common.domain.error.Error
import com.nosmurf.common.domain.error.ErrorHandler

class JsErrorHandler : ErrorHandler {
    override fun convert(error: Error): String {
        return ""
    }
}
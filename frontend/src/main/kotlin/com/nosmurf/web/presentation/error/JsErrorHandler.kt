package com.nosmurf.web.presentation.error

import com.nosmurf.common.client.domain.error.Error
import com.nosmurf.common.client.domain.error.ErrorHandler


class JsErrorHandler : ErrorHandler {
    override fun convert(error: Error): String {
        return ""
    }
}
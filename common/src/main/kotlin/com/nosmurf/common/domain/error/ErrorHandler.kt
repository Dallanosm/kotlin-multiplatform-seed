package com.nosmurf.common.domain.error

interface ErrorHandler {
    fun convert(error: Error): String
}
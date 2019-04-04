package com.mpp.seed.common.constants

import kmulti.bignumber.BigDecimal

class Constants {
    companion object {
        const val DEFAULT_BOOLEAN = false
        const val DEFAULT_INT: Int = 0
        const val DEFAULT_LONG: Long = 0
        const val DEFAULT_DOUBLE: Double = 0.0
        val DEFAULT_BIG_DECIMAL = BigDecimal(DEFAULT_INT)
        const val DEFAULT_STRING = ""
    }
}
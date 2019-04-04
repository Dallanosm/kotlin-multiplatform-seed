package com.mpp.seed.commonmobile.executor

import kotlinx.coroutines.CoroutineDispatcher

interface Executor {
    val main: CoroutineDispatcher
}
package com.nosmurf.common.client.domain.executor

import kotlinx.coroutines.CoroutineDispatcher

interface Executor {
    val main: CoroutineDispatcher
}
package com.nosmurf.web.presentation.executor

import com.nosmurf.common.client.domain.executor.Executor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class JsExecutor : Executor {
    override val main: CoroutineDispatcher = Dispatchers.Default
}
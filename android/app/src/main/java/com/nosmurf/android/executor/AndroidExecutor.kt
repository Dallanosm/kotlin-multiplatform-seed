package com.nosmurf.android.executor

import com.nosmurf.common.domain.executor.Executor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidExecutor : Executor {
    override val main: CoroutineDispatcher = Dispatchers.Main
}
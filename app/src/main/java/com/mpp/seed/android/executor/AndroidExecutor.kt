package com.mpp.seed.android.executor

import com.mpp.seed.commonmobile.executor.Executor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidExecutor : Executor {
    override val main: CoroutineDispatcher = Dispatchers.Main
}
package com.nosmurf.desktop.data

import com.nosmurf.common.client.domain.executor.Executor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx

class DesktopExecutor : Executor {
    override val main: CoroutineDispatcher = Dispatchers.JavaFx
}
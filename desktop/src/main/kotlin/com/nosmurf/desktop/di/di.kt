package com.nosmurf.desktop.di

import com.nosmurf.desktop.data.DesktopErrorHandler
import com.nosmurf.desktop.data.DesktopExecutor
import com.nosmurf.desktop.data.DesktopLocalDataSource
import com.nosmurf.common.data.datasource.remote.CommonRemoteDataSource
import com.nosmurf.common.data.repository.CommonRepository
import com.nosmurf.common.domain.error.ErrorHandler
import com.nosmurf.common.domain.executor.Executor
import com.nosmurf.common.domain.repository.Repository

val executor: Executor = DesktopExecutor()

val errorHandler: ErrorHandler = DesktopErrorHandler()

val repository: Repository = CommonRepository(remote = CommonRemoteDataSource(), local = DesktopLocalDataSource())
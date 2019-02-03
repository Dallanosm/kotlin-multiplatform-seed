package com.nosmurf.desktop.di

import com.nosmurf.common.client.data.datasource.remote.CommonRemoteDataSource
import com.nosmurf.common.client.data.repository.CommonRepository
import com.nosmurf.common.client.domain.error.ErrorHandler
import com.nosmurf.common.client.domain.executor.Executor
import com.nosmurf.common.client.domain.repository.Repository
import com.nosmurf.desktop.data.DesktopErrorHandler
import com.nosmurf.desktop.data.DesktopExecutor
import com.nosmurf.desktop.data.DesktopLocalDataSource


val executor: Executor = DesktopExecutor()

val errorHandler: ErrorHandler = DesktopErrorHandler()

val repository: Repository = CommonRepository(remote = CommonRemoteDataSource(), local = DesktopLocalDataSource())
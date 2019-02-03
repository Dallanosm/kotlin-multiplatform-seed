package com.nosmurf.web.presentation.di

import com.nosmurf.web.data.JsLocalDataSource
import com.nosmurf.web.presentation.error.JsErrorHandler
import com.nosmurf.web.presentation.executor.JsExecutor
import com.nosmurf.common.data.datasource.remote.CommonRemoteDataSource
import com.nosmurf.common.data.repository.CommonRepository
import com.nosmurf.common.domain.error.ErrorHandler
import com.nosmurf.common.domain.executor.Executor
import com.nosmurf.common.domain.repository.Repository

val executor: Executor = JsExecutor()

val errorHandler: ErrorHandler = JsErrorHandler()

val remote = CommonRemoteDataSource()

val local = JsLocalDataSource()

val repository: Repository = CommonRepository(remote = remote, local = local)
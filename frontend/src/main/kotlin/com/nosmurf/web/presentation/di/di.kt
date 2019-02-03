package com.nosmurf.web.presentation.di

import com.nosmurf.common.client.data.datasource.remote.CommonRemoteDataSource
import com.nosmurf.common.client.data.repository.CommonRepository
import com.nosmurf.common.client.domain.error.ErrorHandler
import com.nosmurf.common.client.domain.executor.Executor
import com.nosmurf.common.client.domain.repository.Repository
import com.nosmurf.web.data.JsLocalDataSource
import com.nosmurf.web.presentation.error.JsErrorHandler
import com.nosmurf.web.presentation.executor.JsExecutor


val executor: Executor = JsExecutor()

val errorHandler: ErrorHandler = JsErrorHandler()

val remote = CommonRemoteDataSource()

val local = JsLocalDataSource()

val repository: Repository = CommonRepository(remote = remote, local = local)
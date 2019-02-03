package com.nosmurf.android

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.nosmurf.android.error.AndroidErrorHandler
import com.nosmurf.android.executor.AndroidExecutor
import com.nosmurf.android.storage.AndroidLocalDataSource
import com.nosmurf.common.client.data.datasource.local.LocalDataSource
import com.nosmurf.common.client.data.datasource.remote.CommonRemoteDataSource
import com.nosmurf.common.client.data.datasource.remote.RemoteDataSource
import com.nosmurf.common.client.data.repository.CommonRepository
import com.nosmurf.common.client.domain.error.ErrorHandler
import com.nosmurf.common.client.domain.executor.Executor
import com.nosmurf.common.client.domain.repository.Repository

fun app(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }
    bind<LocalDataSource>() with singleton { AndroidLocalDataSource(context = instance()) }
    bind<RemoteDataSource>() with singleton { CommonRemoteDataSource() }
    bind<Repository>() with singleton { CommonRepository(remote = instance(), local = instance()) }
    bind<Executor>() with singleton { AndroidExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = instance()) }
}
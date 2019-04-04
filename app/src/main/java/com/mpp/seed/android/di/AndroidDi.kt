package com.mpp.seed.android.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.mpp.seed.android.error.AndroidErrorConverter
import com.mpp.seed.android.executor.AndroidExecutor
import com.mpp.seed.android.network.buildClient
import com.mpp.seed.commonmobile.error.ErrorConverter
import com.mpp.seed.commonmobile.executor.Executor
import okhttp3.OkHttpClient

fun app(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }

    bind<Executor>() with singleton { AndroidExecutor() }
    bind<ErrorConverter>() with singleton { AndroidErrorConverter(context = instance()) }

    bind<OkHttpClient>() with singleton { buildClient() }
}

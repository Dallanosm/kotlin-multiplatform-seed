package com.mpp.seed.android.view

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import com.mpp.seed.android.di.app

class AndroidApp : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(app(this@AndroidApp))
    }

    override fun onCreate() {
        super.onCreate()
    }
}
package com.nosmurf.android

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy

class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(app(this@App))
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
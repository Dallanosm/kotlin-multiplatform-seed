package com.nosmurf.android.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.lazy
import com.nosmurf.android.App
import com.nosmurf.android.extensions.toast
import com.nosmurf.common.presentation.Presenter

abstract class RootActivity<out V : Presenter.View> : AppCompatActivity(), KodeinInjected, Presenter.View {

    abstract val presenter: Presenter<V>

    abstract val layoutResourceId: Int

    override val injector = KodeinInjector()

    abstract val activityModule: Kodein.Module

    val kodein by Kodein.lazy {
        extend((application as App).kodein)
        import(activityModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)

        initializeDI()
        initializeUI()
        registerListeners()

        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun initializeDI() {
        inject(kodein)
    }

    abstract fun initializeUI()

    abstract fun registerListeners()

    override fun showError(error: String) = toast(error)

    override fun showMessage(message: String) = toast(message, Toast.LENGTH_SHORT)

}
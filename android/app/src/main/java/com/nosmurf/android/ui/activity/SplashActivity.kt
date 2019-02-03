package com.nosmurf.android.ui.activity

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.nosmurf.android.R
import com.nosmurf.common.presentation.SplashPresenter
import com.nosmurf.common.presentation.SplashView

class SplashActivity : RootActivity<SplashView>(), SplashView {

    override val presenter: SplashPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_splash

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<SplashPresenter>() with provider {
            SplashPresenter(
                    view = this@SplashActivity,
                    errorHandler = instance()
            )
        }
    }

    override fun initializeUI() {

    }

    override fun registerListeners() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

}
package com.mpp.seed.android.view.activity

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.mpp.seed.android.R
import com.mpp.seed.commonmobile.presenter.SplashPresenter

class SplashActivity : RootActivity<SplashPresenter.View>(), SplashPresenter.View {

    override val presenter: SplashPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_splash

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<SplashPresenter>() with provider {
            SplashPresenter(
                    errorConverter = instance(),
                    executor = instance(),
                    view = this@SplashActivity
            )
        }
    }

    override fun initializeUI() {
        // TODO
    }

    override fun registerListeners() {
        // TODO
    }
}
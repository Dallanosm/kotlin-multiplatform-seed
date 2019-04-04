package com.mpp.seed.commonmobile.presenter

import com.mpp.seed.commonmobile.error.ErrorConverter
import com.mpp.seed.commonmobile.executor.Executor


class SplashPresenter(
        errorConverter: ErrorConverter,
        executor: Executor,
        view: View
) : Presenter<SplashPresenter.View>(errorConverter, executor, view) {

    override fun initialize() {
        // TODO
    }

    interface View : Presenter.View
}

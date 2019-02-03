package com.nosmurf.common.client.presentation

import com.nosmurf.common.client.domain.error.ErrorHandler

class SplashPresenter(view: SplashView, errorHandler: ErrorHandler) :
        Presenter<SplashView>(view = view, errorHandler = errorHandler) {

    override fun initialize() {

    }

    override fun destroy() {

    }

}


interface SplashView : Presenter.View {

}
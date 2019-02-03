package com.nosmurf.common.presentation

import com.nosmurf.common.domain.error.ErrorHandler

class SplashPresenter(view: SplashView, errorHandler: ErrorHandler) :
    Presenter<SplashView>(view = view, errorHandler = errorHandler) {

    override fun initialize() {

    }

    override fun destroy() {

    }

}


interface SplashView : Presenter.View {

}
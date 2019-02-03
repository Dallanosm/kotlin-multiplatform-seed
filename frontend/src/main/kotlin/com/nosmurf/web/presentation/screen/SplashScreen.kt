package com.nosmurf.web.presentation.screen

import com.nosmurf.web.presentation.di.errorHandler
import com.nosmurf.web.presentation.navigator.Screen
import com.nosmurf.common.presentation.SplashPresenter
import com.nosmurf.common.presentation.SplashView
import react.RBuilder
import react.RProps

class SplashScreen : RootScreen<SplashProps, SplashState, SplashView>(), SplashView {

    override val presenter: SplashPresenter = SplashPresenter(
            view = this,
            errorHandler = errorHandler
    )

    override fun RBuilder.render() {

    }

    override fun showError(error: String) {
        println(error)
    }

    override fun showMessage(message: String) {
        println(message)
    }
}

interface SplashState : ScreenState

interface SplashProps : RProps {
    var onDownloadFinished: (Screen) -> Unit
}

fun RBuilder.splash(downloadFinished: (Screen) -> Unit) = child(SplashScreen::class) {
    attrs.onDownloadFinished = downloadFinished
}
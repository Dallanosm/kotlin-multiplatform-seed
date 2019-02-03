package com.nosmurf.desktop.app

import com.nosmurf.desktop.app.Styles
import com.nosmurf.desktop.view.SplashView
import javafx.stage.Stage
import tornadofx.*

class MyApp : App(SplashView::class, Styles::class) {

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isMaximized = true
    }
}
package com.nosmurf.web.presentation.app

import com.nosmurf.web.presentation.navigator.Screen
import com.nosmurf.web.presentation.screen.splash
import react.*
import react.dom.div

abstract class App : RComponent<RProps, AppState>() {

    init {
        state = AppState()
    }

    override fun RBuilder.render() {
        div("app") {
            when (state.screen) {
                Screen.SPLASH -> splash { setState { screen = it } }

            }
        }
    }
}

class AppState : RState {
    var screen: Screen = Screen.SPLASH
}

fun RBuilder.app() = child(App::class) {}
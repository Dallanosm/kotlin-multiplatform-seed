package com.nosmurf.common.client.presentation

import com.nosmurf.common.client.domain.error.Error
import com.nosmurf.common.client.domain.error.ErrorHandler

abstract class Presenter<out V : Presenter.View>(protected val errorHandler: ErrorHandler, val view: V) {

    abstract fun initialize()

    abstract fun destroy()

    protected fun onError(callback: (String) -> Unit): (Error) -> Unit = {
        view.hideProgress()

        callback(errorHandler.convert(it))
    }

    interface View {
        fun showProgress()

        fun hideProgress()

        fun showError(error: String)

        fun showMessage(message: String)
    }
}
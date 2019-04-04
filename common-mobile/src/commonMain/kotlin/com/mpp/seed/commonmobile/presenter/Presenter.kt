package com.mpp.seed.commonmobile.presenter

import com.mpp.seed.common.Either
import com.mpp.seed.commonmobile.error.ErrorConverter
import com.mpp.seed.commonmobile.executor.Executor
import com.mpp.seed.common.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

abstract class Presenter<out V : Presenter.View>(
        private val errorConverter: ErrorConverter,
        executor: Executor,
        val view: V
) {

    private val job = SupervisorJob()

    abstract fun initialize()

    fun destroy() = job.cancel()

    protected val scope = CoroutineScope(job + executor.main)

    protected fun onError(error: Result.Error, callback: (String) -> Unit) {
        view.hideProgress()
        callback(errorConverter.convert(error))
    }

    protected fun <T> execute(useCase: Either<Result.Error, T>, success: (T) -> Unit, retry: () -> Unit) {
        when (useCase) {
            is Either.Left -> onError(useCase.error) { view.hideProgress() }
            is Either.Right -> {
                view.hideProgress()
                success(useCase.data)
            }
        }
    }

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showError(error: String)
        fun showRetry(message: String, callback: () -> Unit)
    }
}
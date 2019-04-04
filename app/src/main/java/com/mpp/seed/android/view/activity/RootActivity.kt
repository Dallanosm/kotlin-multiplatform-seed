package com.mpp.seed.android.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.lazy
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.mpp.seed.android.R
import com.mpp.seed.android.view.AndroidApp
import com.mpp.seed.commonmobile.presenter.Presenter
import kotlinx.android.synthetic.main.view_progress.*
import java.security.MessageDigest

abstract class RootActivity<out V : Presenter.View> : AppCompatActivity(), KodeinInjected, Presenter.View {

    abstract val presenter: Presenter<V>

    abstract val layoutResourceId: Int

    override val injector = KodeinInjector()

    abstract val activityModule: Kodein.Module

    private val progressView: View by lazy { progress }

    val kodein by Kodein.lazy {
        extend((application as AndroidApp).kodein)
        import(activityModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)

        initializeDI()
        initializeUI()
        registerListeners()

        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun initializeDI() {
        inject(kodein)
    }

    abstract fun initializeUI()

    abstract fun registerListeners()

    override fun showProgress() = progress.showMe()

    override fun hideProgress() = progress.hideMe()

    override fun showError(error: String) = toast(error)

    override fun showRetry(message: String, callback: () -> Unit) {
        snackbar(message, retryCallback = callback)
    }
}

fun AppCompatActivity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.snackbar(
        message: String,
        duration: Int = Snackbar.LENGTH_INDEFINITE,
        retry: String? = getString(R.string.retry),
        retryCallback: () -> Unit = {}
): Snackbar {
    val make = Snackbar.make(findViewById(android.R.id.content), message, duration)

    retry?.let {
        make.setAction(it) {
            retryCallback()
        }
    }

    make.show()

    return make
}

fun View.showMe() {
    visibility = View.VISIBLE
}

fun View.hideMe(gone: Boolean = true) {
    visibility = if (gone) View.GONE else View.INVISIBLE
}

fun TextInputLayout.showError(errorMsg: String) {
    this.isErrorEnabled = true
    this.error = errorMsg
}

fun TextInputLayout.hideError() {
    this.isErrorEnabled = false
}

fun AppCompatActivity.sha512(input: String) = hashString("SHA-512", input)

fun AppCompatActivity.sha256(input: String) = hashString("SHA-256", input)

fun AppCompatActivity.sha1(input: String) = hashString("SHA-1", input)

/**
 * Supported algorithms on Android:
 *
 * Algorithm	Supported API Levels
 * MD5          1+
 * SHA-1	    1+
 * SHA-224	    1-8,22+
 * SHA-256	    1+
 * SHA-384	    1+
 * SHA-512	    1+
 */
private fun AppCompatActivity.hashString(type: String, input: String): String {
    val HEX_CHARS = "0123456789ABCDEF"
    val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
    val result = StringBuilder(bytes.size * 2)

    bytes.forEach {
        val i = it.toInt()
        result.append(HEX_CHARS[i shr 4 and 0x0f])
        result.append(HEX_CHARS[i and 0x0f])
    }

    return result.toString()
}
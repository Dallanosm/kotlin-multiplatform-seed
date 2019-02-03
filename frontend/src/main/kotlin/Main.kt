import com.nosmurf.web.presentation.app.app

import react.dom.render
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    window.onload = {
        render(document.getElementById("app")) {
            app()
        }
    }
}
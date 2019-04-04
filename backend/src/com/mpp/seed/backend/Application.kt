package com.mpp.seed.backend

import com.mpp.seed.backend.database.initializeDb
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.basic
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.request.path
import io.ktor.websocket.WebSockets
import org.slf4j.event.Level
import java.time.Duration

const val AUTH = "auth"
const val REALM = "auth"
const val AUTH_USER = "auth"
const val AUTH_PASS = "auth"

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    // http://ktor.io/servers/features/https-redirect.html#testing
    // if (!testing) {
    //     install(HttpsRedirect) {
    //         // The port to redirect to. By default 443, the default HTTPS port.
    //         sslPort = 443
    //         // 301 Moved Permanently, or 302 Found redirect.
    //         permanentRedirect = true
    //     }
    // }

    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    install(Authentication) {
        basic(AUTH) {
            realm = REALM
            validate { if (it.name == AUTH_USER && it.password == AUTH_PASS) UserIdPrincipal(it.name) else null }
        }
    }

    install(ContentNegotiation) {
        gson {}
    }

    initializeDb()
    modules()
}


package com.nosmurf.backend

import io.ktor.application.install
import io.ktor.features.*
import io.ktor.gson.GsonConverter
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.slf4j.event.Level

fun main(args: Array<String>) {
    embeddedServer(Netty, 10000) {

        // Serialize json
        install(ContentNegotiation) {
            register(ContentType("[*", "*]"), GsonConverter())
            register(ContentType("*", "*"), GsonConverter())
            register(ContentType("text", "plain"), GsonConverter())
            gson {}
        }

        // Return custom errors (if needed)
        install(StatusPages)
        install(CORS) { anyHost() }
        install(DefaultHeaders)
        install(ConditionalHeaders)

        install(CallLogging) {
            level = Level.TRACE
        }

        // Modules
        main()
    }.start(wait = true)
}
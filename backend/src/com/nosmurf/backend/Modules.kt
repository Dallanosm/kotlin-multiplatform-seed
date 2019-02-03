package com.nosmurf.backend

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing

fun Application.main() {
    path()
}

fun Application.path() {
    routing {
        route("/") {
            //GET
            get { call.respond("Hello") }

            // POST

        }
    }
}
package com.mpp.seed.backend

import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

fun Application.modules() {
}

suspend fun <R : Result> ApplicationCall.respond(either: Either<Result.Error, R>) {
    when (either) {
        is Either.Left -> respond(HttpStatusCode(either.error.code, either.error.message), either.error)
        is Either.Right -> respond(either.data)
    }
}
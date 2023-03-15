package kz.tolegen.kinolarkmm.common.api

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


internal fun getHttpClient(
    httpClientEngine: HttpClientEngine,
    enableLogging: Boolean,
): HttpClient {
    val client = HttpClient(httpClientEngine) {
        followRedirects = true
        expectSuccess = true

        defaultRequest {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }


        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                encodeDefaults = true
            })
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = if (enableLogging) {
                LogLevel.ALL
            } else {
                LogLevel.NONE
            }
        }

    }
    return client
}
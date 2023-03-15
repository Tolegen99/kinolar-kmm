package kz.tolegen.kinolarkmm.common.api

import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.http.*
import kz.tolegen.kinolarkmm.common.api.entity.response.MovieListResponse
import kz.tolegen.kinolarkmm.common.entity.entity.MovieData

class ApiImpl(
    private val httpClientEngine: HttpClientEngine,
) : Api {

    private val httpClient = getHttpClient(
        httpClientEngine = httpClientEngine,
        enableLogging = true
    )

    override suspend fun getMovies(): List<MovieData> =
        httpClient.get("${NetworkConstants.api_endpoint}${NetworkConstants.popular}") {
            contentType(ContentType.Application.Json)
            parameter(NetworkConstants.PARAMS_API_KEY_FIELD, NetworkConstants.api_key)
            parameter(NetworkConstants.PARAMS_LANGUAGE_FIELD, NetworkConstants.PARAM_LANGUAGE_RU)
        }.body<MovieListResponse>().movies.toMovieData()
}
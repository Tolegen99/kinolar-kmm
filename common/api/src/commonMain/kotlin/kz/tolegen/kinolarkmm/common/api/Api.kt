package kz.tolegen.kinolarkmm.common.api

import kz.tolegen.kinolarkmm.common.api.entity.response.MovieListResponse
import kz.tolegen.kinolarkmm.common.entity.entity.MovieData

interface Api {
    suspend fun getMovies(): List<MovieData>
}
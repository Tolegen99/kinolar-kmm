package kz.tolegen.kinolarkmm.common.api

import kz.tolegen.kinolarkmm.common.api.entity.response.MovieResponse
import kz.tolegen.kinolarkmm.common.entity.entity.MovieData

fun MovieResponse.toMovieData() =
    MovieData(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        id = id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count,
    )

fun List<MovieResponse>.toMovieData() = map { it.toMovieData() }
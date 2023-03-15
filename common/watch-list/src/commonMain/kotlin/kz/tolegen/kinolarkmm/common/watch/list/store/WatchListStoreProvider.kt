package kz.tolegen.kinolarkmm.common.watch.list.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.reaktive.ReaktiveExecutor
import com.badoo.reaktive.coroutinesinterop.singleFromCoroutine
import com.badoo.reaktive.scheduler.ioScheduler
import com.badoo.reaktive.scheduler.mainScheduler
import com.badoo.reaktive.single.map
import com.badoo.reaktive.single.observeOn
import com.badoo.reaktive.single.subscribeOn
import com.badoo.reaktive.single.threadLocal
import kz.tolegen.kinolarkmm.common.api.Api
import kz.tolegen.kinolarkmm.common.api.entity.response.MovieResponse
import kz.tolegen.kinolarkmm.common.api.toMovieData
import kz.tolegen.kinolarkmm.common.entity.entity.MovieData
import kz.tolegen.kinolarkmm.common.entity.entity.MovieDataStub
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore.Intent
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore.State

internal class WatchListStoreProvider(
    private val storeFactory: StoreFactory,
    private val api: Api
) {

    fun provide(): WatchListStore =
        object : WatchListStore, Store<Intent, State, Nothing> by storeFactory.create(
            name = "WatchListStore",
            initialState = State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed class Result {
        data class MoviesLoaded(val movies: List<MovieDataStub>) : Result()
        object Cleared : Result()

    }

    private inner class ExecutorImpl : ReaktiveExecutor<Intent, Unit, State, Result, Nothing>() {

        override fun executeAction(action: Unit, getState: () -> State) {
            getMovies()
        }

        override fun executeIntent(intent: Intent, getState: () -> State) {
            when (intent) {
                Intent.Clear -> dispatch(Result.Cleared)
            }
        }

        private fun getMovies() {
            val result: List<MovieDataStub> = listOf(
                MovieDataStub("Кот в сапогах 2: Последнее желание"),
                MovieDataStub("Стук в хижине"),
                MovieDataStub("Кит"),
                MovieDataStub("Крушение"),
                MovieDataStub("Аватар: Путь воды"),
                MovieDataStub("Мой ужасный сосед")
            )
            dispatch(Result.MoviesLoaded(result))
        }
    }

    private object ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State =
            when (result) {
                is Result.MoviesLoaded -> copy(movies = result.movies)
                Result.Cleared -> copy(movies = emptyList())
            }
    }


}
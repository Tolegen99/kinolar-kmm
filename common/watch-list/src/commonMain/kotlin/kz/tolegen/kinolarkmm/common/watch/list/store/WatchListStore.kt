package kz.tolegen.kinolarkmm.common.watch.list.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.api.entity.response.MovieResponse
import kz.tolegen.kinolarkmm.common.entity.entity.MovieData
import kz.tolegen.kinolarkmm.common.entity.entity.MovieDataStub
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore.Intent
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore.State

internal interface WatchListStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        object Clear: Intent()
    }

    data class State(
        val movies: List<MovieDataStub> = emptyList()
    )
}
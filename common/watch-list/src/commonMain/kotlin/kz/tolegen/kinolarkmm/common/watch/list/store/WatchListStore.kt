package kz.tolegen.kinolarkmm.common.watch.list.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore.Intent
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore.State

internal interface WatchListStore : Store<Intent, State, Nothing> {

    sealed class Intent {
    }

    data class State(
        val movies: List<String> = emptyList() //TODO() change to MovieData
    )
}
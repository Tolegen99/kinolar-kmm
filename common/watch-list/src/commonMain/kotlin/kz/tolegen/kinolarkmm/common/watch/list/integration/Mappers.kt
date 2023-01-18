package kz.tolegen.kinolarkmm.common.watch.list.integration

import kz.tolegen.kinolarkmm.common.watch.list.WatchList
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore

internal val stateToModel: (WatchListStore.State) -> WatchList.Model =
    {
        WatchList.Model(
            movies = it.movies
        )
    }
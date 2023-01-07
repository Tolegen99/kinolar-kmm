package kz.tolegen.kinolarkmm.common.watch.list.flow.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.watch.list.flow.store.WatchListFlowStore.Intent
import kz.tolegen.kinolarkmm.common.watch.list.flow.store.WatchListFlowStore.State

internal interface WatchListFlowStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        data class ChangeSelectedBottomNavItem(val index: Int): Intent()
    }

    data class State(
        val selectedBottomNavItem: Int = 0
    )
}
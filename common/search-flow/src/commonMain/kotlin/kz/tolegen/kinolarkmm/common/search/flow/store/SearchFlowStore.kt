package kz.tolegen.kinolarkmm.common.search.flow.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.search.flow.store.SearchFlowStore.Intent
import kz.tolegen.kinolarkmm.common.search.flow.store.SearchFlowStore.State

internal interface SearchFlowStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        data class ChangeSelectedBottomNavItem(val index: Int): Intent()
    }

    data class State(
        val selectedBottomNavItem: Int = 0
    )
}
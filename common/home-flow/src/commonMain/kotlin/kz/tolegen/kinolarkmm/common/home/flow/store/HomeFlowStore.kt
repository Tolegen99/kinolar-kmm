package kz.tolegen.kinolarkmm.common.home.flow.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.home.flow.store.HomeFlowStore.Intent
import kz.tolegen.kinolarkmm.common.home.flow.store.HomeFlowStore.State

internal interface HomeFlowStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        data class ChangeSelectedBottomNavItem(val index: Int): Intent()
    }

    data class State(
        val selectedBottomNavItem: Int = 0
    )
}
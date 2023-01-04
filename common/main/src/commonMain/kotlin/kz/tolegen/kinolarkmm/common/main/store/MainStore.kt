package kz.tolegen.kinolarkmm.common.main.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.main.store.MainStore.Intent
import kz.tolegen.kinolarkmm.common.main.store.MainStore.State

internal interface MainStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        data class ChangeSelectedBottomNavItem(val index: Int): Intent()
    }

    data class State(
        val selectedBottomNavItem: Int = 0
    )
}
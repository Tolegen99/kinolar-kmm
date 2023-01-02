package kz.tolegen.kinolarkmm.common.main.store

import com.arkivanov.mvikotlin.core.store.Store
import kz.tolegen.kinolarkmm.common.main.store.MainStore.Intent
import kz.tolegen.kinolarkmm.common.main.store.MainStore.State

internal interface MainStore : Store<Intent, State, Nothing> {

    sealed class Intent {
    }

    data class State(
        val stub: Boolean = false
    )
}
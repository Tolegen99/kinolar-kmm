package kz.tolegen.kinolarkmm.common.search.flow.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.reaktive.ReaktiveExecutor
import kz.tolegen.kinolarkmm.common.search.flow.store.SearchFlowStore.Intent
import kz.tolegen.kinolarkmm.common.search.flow.store.SearchFlowStore.State

internal class SearchFlowStoreProvider(
    private val storeFactory: StoreFactory
) {

    fun provide() : SearchFlowStore =
        object : SearchFlowStore, Store<Intent, State, Nothing> by storeFactory.create(
            name = "SearchFlowStore",
            initialState = State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed class Result {
        data class SelectedBottomNavItemChanged(val index: Int): Result()
    }

    private inner class ExecutorImpl : ReaktiveExecutor<Intent, Unit, State, Result, Nothing>() {

        override fun executeAction(action: Unit, getState: () -> State) {
            super.executeAction(action, getState)
        }

        override fun executeIntent(intent: Intent, getState: () -> State) {
            when (intent) {
                is Intent.ChangeSelectedBottomNavItem -> dispatch(Result.SelectedBottomNavItemChanged(intent.index))
            }
            super.executeIntent(intent, getState)
        }
    }

    private object ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State =
            when (result) {
                is Result.SelectedBottomNavItemChanged -> copy(selectedBottomNavItem = result.index)
            }
    }
}
package kz.tolegen.kinolarkmm.common.watch.list.flow

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kz.tolegen.kinolarkmm.common.watch.list.WatchList

interface WatchListFlow {

    val childStack: Value<ChildStack<*, Child>>

    val models: Value<Model>

    fun bottomNavItemClicked(index: Int)

    sealed class Child {
        data class WatchListCh(val component: WatchList): Child()
        object Stub : Child()
    }

    sealed class Output {
        object Stub: Output()
    }

    data class Model(
        val selectedBottomNavItem: Int
    )
}
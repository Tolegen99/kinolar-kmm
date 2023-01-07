package kz.tolegen.kinolarkmm.common.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow
import kz.tolegen.kinolarkmm.common.search.flow.SearchFlow
import kz.tolegen.kinolarkmm.common.watch.list.flow.WatchListFlow

interface Main {

    val childStack: Value<ChildStack<*, Child>>

    val models: Value<Model>

    fun bottomNavItemClicked(index: Int)

    sealed class Child {
        data class HomeFlowCh(val component: HomeFlow): Child()
        data class SearchFlowCh(val component: SearchFlow): Child()
        data class WatchListFlowCh(val component: WatchListFlow): Child()
    }

    sealed class Output {
        object Stub: Output()
    }

    data class Model(
        val selectedBottomNavItem: Int
    )
}
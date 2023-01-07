package kz.tolegen.kinolarkmm.common.watch.list.flow.integration

import kz.tolegen.kinolarkmm.common.watch.list.flow.WatchListFlow
import kz.tolegen.kinolarkmm.common.watch.list.flow.store.WatchListFlowStore

internal val stateToModel: (WatchListFlowStore.State) -> WatchListFlow.Model =
    {
        WatchListFlow.Model(
            selectedBottomNavItem = it.selectedBottomNavItem
        )
    }
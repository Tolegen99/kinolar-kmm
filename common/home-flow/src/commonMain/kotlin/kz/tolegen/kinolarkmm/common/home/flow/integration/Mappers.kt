package kz.tolegen.kinolarkmm.common.home.flow.integration

import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow
import kz.tolegen.kinolarkmm.common.home.flow.store.HomeFlowStore


internal val stateToModel: (HomeFlowStore.State) -> HomeFlow.Model =
    {
        HomeFlow.Model(
            selectedBottomNavItem = it.selectedBottomNavItem
        )
    }
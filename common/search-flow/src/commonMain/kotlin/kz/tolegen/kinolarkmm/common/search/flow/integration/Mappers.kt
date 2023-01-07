package kz.tolegen.kinolarkmm.common.search.flow.integration

import kz.tolegen.kinolarkmm.common.search.flow.SearchFlow
import kz.tolegen.kinolarkmm.common.search.flow.store.SearchFlowStore


internal val stateToModel: (SearchFlowStore.State) -> SearchFlow.Model =
    {
        SearchFlow.Model(
            selectedBottomNavItem = it.selectedBottomNavItem
        )
    }
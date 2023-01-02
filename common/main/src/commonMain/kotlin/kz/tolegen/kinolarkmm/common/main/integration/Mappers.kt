package kz.tolegen.kinolarkmm.common.main.integration

import kz.tolegen.kinolarkmm.common.main.Main
import kz.tolegen.kinolarkmm.common.main.store.MainStore

internal val stateToModel: (MainStore.State) -> Main.Model =
    {
        Main.Model(
            stub = it.stub
        )
    }
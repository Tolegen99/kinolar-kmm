package kz.tolegen.kinolarkmm.common.ui.watchListFlow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.ui.watchListFlow.watchList.WatchListContent
import kz.tolegen.kinolarkmm.common.watch.list.flow.WatchListFlow

@Composable
fun WatchListFlowContent(component: WatchListFlow) {
    val model by component.models.subscribeAsState()
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade() + scale())
    ) {
        when (val child = it.instance) {
            is WatchListFlow.Child.WatchListCh -> WatchListContent(child.component)
            else -> {}
        }
    }
}
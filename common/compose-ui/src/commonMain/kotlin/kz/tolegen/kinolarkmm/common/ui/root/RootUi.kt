package kz.tolegen.kinolarkmm.common.ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import kz.tolegen.kinolarkmm.common.root.Root.Child
import kz.tolegen.kinolarkmm.common.root.integration.RootComponent
import kz.tolegen.kinolarkmm.common.ui.main.MainContent

@Composable
fun RootContent(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade() + scale())
    ) {
        when (val child = it.instance) {
            is Child.Main -> MainContent(child.component)
            else -> {}
        }
    }
}
package kz.tolegen.kinolarkmm.common.ui.homeFlow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow

@Composable
fun HomeFlowContent(component: HomeFlow) {
    val model by component.models.subscribeAsState()
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade() + scale())
    ) {
        when (val child = it.instance) {
            else -> {
                Box(modifier = Modifier.fillMaxSize().background(Color.Transparent)){
                    Text("HomeFlow")
                }            }
        }
    }
}
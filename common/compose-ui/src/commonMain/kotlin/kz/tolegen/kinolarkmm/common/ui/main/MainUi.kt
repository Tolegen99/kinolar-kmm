package kz.tolegen.kinolarkmm.common.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.main.Main
import kz.tolegen.kinolarkmm.common.main.Main.Child
import kz.tolegen.kinolarkmm.common.ui.homeFlow.HomeFlowContent
import kz.tolegen.kinolarkmm.common.ui.searchFlow.SearchFlowContent
import kz.tolegen.kinolarkmm.common.ui.theme.AppColors
import kz.tolegen.kinolarkmm.common.ui.theme.Res
import kz.tolegen.kinolarkmm.common.ui.watchListFlow.WatchListFlowContent

@Composable
fun MainContent(component: Main) {
    val stack by component.childStack.subscribeAsState()
    val model by component.models.subscribeAsState()

    Scaffold(
        content = {
            Box(modifier = Modifier.background(AppColors.background)) {
                Children(stack = stack, animation = stackAnimation(fade() + scale())) {
                    when (val child = it.instance) {
                        is Child.HomeFlowCh-> HomeFlowContent(child.component)
                        is Child.SearchFlowCh-> SearchFlowContent(child.component)
                        is Child.WatchListFlowCh-> WatchListFlowContent(child.component)
                    }
                }
            }
        },
        bottomBar = {
            BottomNav(
                items = listOf(
                    BottomNavItem(
                        name = Res.Strings.home,
                        contentDescription = Res.Strings.home,
                        icon = Res.Drawables.IC_HOME,
                        isSelected = model.selectedBottomNavItem == 0
                    ),
                    BottomNavItem(
                        name = Res.Strings.search,
                        contentDescription = Res.Strings.search,
                        icon = Res.Drawables.IC_SEARCH,
                        isSelected = model.selectedBottomNavItem == 1
                    ),
                    BottomNavItem(
                        name = Res.Strings.watch_list,
                        contentDescription = Res.Strings.watch_list,
                        icon = Res.Drawables.IC_SAVE,
                        isSelected = model.selectedBottomNavItem == 2
                    ),
                ),
                itemSelected = { component.bottomNavItemClicked(it) }
            )
        }
    )
}
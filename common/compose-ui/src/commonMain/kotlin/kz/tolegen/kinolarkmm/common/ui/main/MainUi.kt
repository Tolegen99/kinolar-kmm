package kz.tolegen.kinolarkmm.common.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.main.Main
import kz.tolegen.kinolarkmm.common.ui.theme.AppColors
import kz.tolegen.kinolarkmm.common.ui.theme.Res

@Composable
fun MainContent(component: Main) {
    val model by component.models.subscribeAsState()

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppColors.background),
            ) {
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
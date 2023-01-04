package kz.tolegen.kinolarkmm.common.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.tolegen.kinolarkmm.common.ui.component.imageResource
import kz.tolegen.kinolarkmm.common.ui.theme.AppColors
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables

@Composable
fun BottomNav(
    items: List<BottomNavItem>,
    itemSelected: (Int) -> Unit
) =
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        items.forEachIndexed { index, bottomNavItem ->
                Column(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp).clickable(
                        indication = null,
                        interactionSource = interactionSource
                    ) { itemSelected(index) },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageResource(bottomNavItem.icon),
                        tint = if (bottomNavItem.isSelected) AppColors.cerulean else AppColors.mid_gray,
                        contentDescription = bottomNavItem.contentDescription
                    )
                    Text(
                        text = bottomNavItem.name,
                        color = if (bottomNavItem.isSelected) AppColors.cerulean else AppColors.mid_gray,
                        fontSize = 12.sp
                    )
                }
        }
    }

data class BottomNavItem(
    val name: String,
    val contentDescription: String,
    val icon: Drawables,
    val isSelected: Boolean
)
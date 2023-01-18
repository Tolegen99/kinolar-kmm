package kz.tolegen.kinolarkmm.common.ui.watchListFlow.watchList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.ui.component.ImageButton
import kz.tolegen.kinolarkmm.common.ui.component.imageResource
import kz.tolegen.kinolarkmm.common.ui.theme.AppColors
import kz.tolegen.kinolarkmm.common.ui.theme.AppTypography
import kz.tolegen.kinolarkmm.common.ui.theme.Res
import kz.tolegen.kinolarkmm.common.watch.list.WatchList

@Composable
fun WatchListContent(component: WatchList) {
    val model by component.models.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent)) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            val interactionSource = remember { MutableInteractionSource() }
            Icon(
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 16.dp).clickable(
                    indication = null,
                    interactionSource = interactionSource
                ) { },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
            Text(
                text = Res.Strings.watch_list,
                modifier = Modifier.align(Alignment.Center).padding(top = 16.dp, bottom = 16.dp),
                style = AppTypography.Montserrat.SemiBold.Gallery.size16,
                maxLines = 1,
            )
            Icon(
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 16.dp).clickable(
                    indication = null,
                    interactionSource = interactionSource
                ) { },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Transparent
            )
        }

        if (model.movies.isEmpty()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = imageResource(Res.Drawables.IC_MAGIC_BOX),
                    contentDescription = "No movie",
                    tint = Color.Unspecified
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp, start = 32.dp, end = 32.dp),
                    text = Res.Strings.no_movie_yet,
                    style = AppTypography.Montserrat.SemiBold.AthensGray.size16spacing012
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp, start = 64.dp, end = 64.dp),
                    text = Res.Strings.find_your_movies_by,
                    style = AppTypography.Montserrat.Medium.Manatee.size12spacing012alignCenter
                )
            }
        }
    }

}
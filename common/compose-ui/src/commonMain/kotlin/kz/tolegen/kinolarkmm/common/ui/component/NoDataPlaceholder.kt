package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kz.tolegen.kinolarkmm.common.ui.theme.AppTypography
import kz.tolegen.kinolarkmm.common.ui.theme.Res

@Composable
fun NoDataBackground(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
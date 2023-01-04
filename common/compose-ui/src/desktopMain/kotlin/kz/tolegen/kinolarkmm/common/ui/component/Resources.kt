package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables

@Composable
actual fun imageResource(drawable: Drawables) =
    painterResource(
        when (drawable) {
            Drawables.IC_HOME -> "drawable/ic_home.xml"
            Drawables.IC_SEARCH -> "drawable/ic_search.xml"
            Drawables.IC_SAVE -> "drawable/ic_save.xml"
        }
    )


@Composable
actual fun Font(
    name: String,
    res: String,
    weight: FontWeight,
    style: FontStyle,
): Font = androidx.compose.ui.text.platform.Font("font/$res.ttf", weight, style)

actual fun bitmapImageResource(res: String): ImageBitmap {
    return useResource(res) { loadImageBitmap(it) }
}

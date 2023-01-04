package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kz.tolegen.kinolarkmm.common.ui.R
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables

@Composable
actual fun imageResource(drawable: Drawables): Painter {
    return painterResource(
        when (drawable) {
            Drawables.IC_HOME -> R.drawable.ic_home
            Drawables.IC_SEARCH -> R.drawable.ic_search
            Drawables.IC_SAVE -> R.drawable.ic_save
        }
    )
}

@Composable
actual fun Font(
    name: String,
    res: String,
    weight: FontWeight,
    style: FontStyle,
): Font {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(res, "font", context.packageName)
    return Font(id, weight, style)
}

//TODO() stub
@Composable
actual fun bitmapImageResource(res: String): ImageBitmap {
    return ImageBitmap(1, 1)
}

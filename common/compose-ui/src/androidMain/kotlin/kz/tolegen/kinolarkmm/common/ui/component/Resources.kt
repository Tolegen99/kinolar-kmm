package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import kz.tolegen.kinolarkmm.common.ui.R
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Fonts

@Composable
actual fun imageResource(drawable: Drawables): Painter {
    return painterResource(
        when (drawable) {
            Drawables.IC_HOME -> R.drawable.ic_home
            Drawables.IC_SEARCH -> R.drawable.ic_search
            Drawables.IC_SAVE -> R.drawable.ic_save
            Drawables.IC_MAGIC_BOX -> R.drawable.ic_magic_box
        }
    )
}

@Composable
actual fun font(font: Fonts): FontFamily =
    FontFamily(
        Font(
            when (font) {
                Fonts.MONTSERRAT_MEDIUM -> R.font.montserrat_medium
                Fonts.MONTSERRAT_SEMI_BOLD -> R.font.montserrat_semi_bold
                Fonts.POPPINS_MEDIUM -> R.font.poppins_medium
                Fonts.POPPINS_REGULAR -> R.font.poppins_regular
                Fonts.POPPINS_SEMI_BOLD -> R.font.poppins_semi_bold
                Fonts.ROBOTO_MEDIUM -> R.font.roboto_medium
            }
        )
    )

//TODO() stub
@Composable
actual fun bitmapImageResource(res: String): ImageBitmap {
    return ImageBitmap(1, 1)
}

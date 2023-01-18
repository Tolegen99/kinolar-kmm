package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Fonts

@Composable
actual fun imageResource(drawable: Drawables) =
    painterResource(
        when (drawable) {
            Drawables.IC_HOME -> "drawable/ic_home.xml"
            Drawables.IC_SEARCH -> "drawable/ic_search.xml"
            Drawables.IC_SAVE -> "drawable/ic_save.xml"
            Drawables.IC_MAGIC_BOX -> "drawable/ic_magic_box.xml"
        }
    )


@Composable
actual fun font(font: Fonts): FontFamily =
    FontFamily(
        Font(
            when (font) {
                Fonts.MONTSERRAT_MEDIUM -> "font/montserrat_medium.ttf"
                Fonts.MONTSERRAT_SEMI_BOLD -> "font/montserrat_semi_bold.ttf"
                Fonts.POPPINS_MEDIUM -> "font/poppins_medium.ttf"
                Fonts.POPPINS_REGULAR -> "font/poppins_regular.ttf"
                Fonts.POPPINS_SEMI_BOLD -> "font/poppins_semi_bold.ttf"
                Fonts.ROBOTO_MEDIUM -> "font/roboto_medium.ttf"
            }
        )
    )


actual fun bitmapImageResource(res: String): ImageBitmap {
    return useResource(res) { loadImageBitmap(it) }
}

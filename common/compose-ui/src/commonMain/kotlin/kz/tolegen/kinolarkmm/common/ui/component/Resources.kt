package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Fonts

@Composable
expect fun imageResource(drawable: Drawables): Painter

expect fun bitmapImageResource(res: String): ImageBitmap

@Composable
expect fun font(font: Fonts): FontFamily


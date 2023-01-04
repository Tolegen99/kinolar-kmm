package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kz.tolegen.kinolarkmm.common.ui.theme.Res.Drawables

@Composable
expect fun imageResource(drawable: Drawables): Painter

expect fun bitmapImageResource(res: String): ImageBitmap

@Composable
expect fun Font(name: String, res: String, weight: FontWeight, style: FontStyle): Font


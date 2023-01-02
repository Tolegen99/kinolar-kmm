package kz.tolegen.kinolarkmm.common.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object AppColors {
    val background by mutableStateOf(Color(0xFF242A32))
}

internal val LocalColors = staticCompositionLocalOf { AppColors }
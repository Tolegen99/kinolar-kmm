package kz.tolegen.kinolarkmm.common.ui.theme

import androidx.compose.runtime.Composable

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalColors.current
}
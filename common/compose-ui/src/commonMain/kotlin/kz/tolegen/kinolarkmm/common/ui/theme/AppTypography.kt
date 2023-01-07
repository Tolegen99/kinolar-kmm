package kz.tolegen.kinolarkmm.common.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kz.tolegen.kinolarkmm.common.ui.component.font

object AppTypography {
    object Montserrat {
        object Medium {
        }

        object SemiBold {
        }
    }

    object Poppins {
        object Medium {
        }
        object Regular {
        }
        object SemiBold {
        }
    }

    object Roboto {
        object Medium {
            object Cerulean {
                val sp12: TextStyle
                    @Composable
                    get() = TextStyle(
                        color = AppColors.cerulean,
                        fontSize = 12.sp,
                        fontFamily = font(Res.Fonts.ROBOTO_MEDIUM),
                    )
            }

            object MidGray {
                val sp12: TextStyle
                    @Composable
                    get() = TextStyle(
                        color = AppColors.mid_gray,
                        fontSize = 12.sp,
                        fontFamily = font(Res.Fonts.ROBOTO_MEDIUM),
                    )
            }
        }
    }
}
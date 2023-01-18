package kz.tolegen.kinolarkmm.common.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kz.tolegen.kinolarkmm.common.ui.component.font

object AppTypography {
    object Montserrat {
        object Medium {
            object Manatee {
                val size12spacing012alignCenter : TextStyle
                    @Composable
                    get() = TextStyle(
                        color = AppColors.manatee,
                        fontSize = 12.sp,
                        fontFamily = font(Res.Fonts.MONTSERRAT_MEDIUM),
                        letterSpacing = 0.12.sp,
                        textAlign = TextAlign.Center
                    )
            }
        }

        object SemiBold {
            object AthensGray {
                val size16spacing012 : TextStyle
                    @Composable
                    get() = TextStyle(
                        color = AppColors.athens_gray,
                        fontSize = 16.sp,
                        fontFamily = font(Res.Fonts.MONTSERRAT_SEMI_BOLD),
                        letterSpacing = 0.12.sp
                    )
            }
            object Gallery {
                val size16 : TextStyle
                @Composable
                get() = TextStyle(
                    color = AppColors.gallery,
                    fontSize = 16.sp,
                    fontFamily = font(Res.Fonts.MONTSERRAT_SEMI_BOLD)
                )
            }
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
                val size12: TextStyle
                    @Composable
                    get() = TextStyle(
                        color = AppColors.cerulean,
                        fontSize = 12.sp,
                        fontFamily = font(Res.Fonts.ROBOTO_MEDIUM),
                    )
            }

            object MidGray {
                val size12: TextStyle
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
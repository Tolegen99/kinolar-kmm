package kz.tolegen.kinolarkmm.common.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ImageButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit,
    tint: Color,
    tintPressed: Color = tint,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Icon(
        modifier = modifier.clickable(
            indication = null,
            interactionSource = interactionSource
        ) { onClick() },
        imageVector = imageVector,
        contentDescription = description,
        tint = if (isPressed) tintPressed else tint
    )
}
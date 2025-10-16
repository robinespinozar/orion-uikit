package com.raerossi.orion.ui_kit.info_displays.icon_with_text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * IconWithText - A composable that displays an icon and text content in a horizontal row.
 *
 * This component follows Material Design 3 guidelines and provides maximum flexibility
 * by accepting both icon and text as composable slots.
 *
 * @param icon The icon composable to display (leading position)
 * @param text The text composable to display (trailing position)
 * @param modifier Modifier to be applied to the component
 * @param spacing Spacing between icon and text
 * @param verticalAlignment Vertical alignment of icon and text
 */
@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    spacing: Dp = IconWithTextDefaults.spacing,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically
) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment
    ) {
        icon()
        Spacer(Modifier.width(spacing))
        text()
    }
}

@Preview
@Composable
private fun IconWithTextPreview() {
    Box(Modifier.background(MaterialTheme.colorScheme.background)) {
        IconWithText(
            modifier = Modifier.padding(16.dp),
            text = {
                Text(
                    text = "IconWithText Label",
                    color = Color.Black
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Yellow
                )
            }
        )
    }
}

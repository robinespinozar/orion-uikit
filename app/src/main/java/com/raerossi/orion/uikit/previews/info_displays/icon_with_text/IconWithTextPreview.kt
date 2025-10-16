package com.raerossi.orion.uikit.previews.info_displays.icon_with_text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.info_displays.icon_with_text.IconWithText
import com.raerossi.orion.ui_kit.spacers.VerticalSpacer
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@PreviewLightDark
@Composable
private fun IconWithTextPreview() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            // Basic usage
            IconWithText(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                text = {
                    Text(
                        text = "Basic IconWithText",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )

            VerticalSpacer(16)

            // With custom spacing
            IconWithText(
                icon = {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Check",
                        tint = Color(0xFF4CAF50)
                    )
                },
                text = {
                    Text(
                        text = "Custom spacing (16dp)",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                spacing = 16.dp
            )



            VerticalSpacer(16)

            // With custom colors
            IconWithText(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                },
                text = {
                    Text(
                        text = "Custom styled text",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            )

            VerticalSpacer(16)

            // Top alignment
            IconWithText(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                },
                text = {
                    Text(
                        text = "Top aligned with multiline text. This text is long enough to wrap to multiple lines.",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                verticalAlignment = Alignment.Top
            )

            VerticalSpacer(16)

            // Zero spacing
            IconWithText(
                icon = {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error
                    )
                },
                text = {
                    Text(
                        text = "No spacing (0dp)",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelLarge
                    )
                },
                spacing = 0.dp
            )
        }
    }
}

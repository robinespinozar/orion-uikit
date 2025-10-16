package com.raerossi.orion.ui_kit.info_displays.title_description

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Contains the default values used by [TitleDescription].
 *
 */
object TitleDescriptionDefaults {

    val spacing: Dp = 8.dp
    val compactSpacing: Dp = 4.dp

    val balancedTitleStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.headlineMedium

    val balancedDescriptionStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.bodyMedium

    @Composable
    fun colors(
        titleColor: Color = MaterialTheme.colorScheme.onSurface,
        descriptionColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ): TitleDescriptionColors = TitleDescriptionColors(
        titleColor = titleColor,
        descriptionColor = descriptionColor
    )

    val emphasizedTitleStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.headlineLarge

    val emphasizedDescriptionStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.bodySmall

    val compactTitleStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.headlineSmall

    val compactDescriptionStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.bodySmall
}
package com.raerossi.orion.ui_kit.title_description

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
 * This object follows Material Design 3 conventions:
 * - Provides sensible defaults based on MaterialTheme
 * - Uses @ReadOnlyComposable for optimization
 * - Offers predefined style variants for common use cases
 * - Allows customization through the colors() function
 */
object TitleDescriptionDefaults {
    
    /**
     * The default spacing between title and description.
     * 8.dp follows MD3 spacing guidelines for compact text groups.
     */
    val Spacing: Dp = 8.dp
    
    /**
     * The default text style for the title.
     * Uses MaterialTheme.typography.headlineSmall by default.
     */
    val titleStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.headlineSmall
    
    /**
     * The default text style for the description.
     * Uses MaterialTheme.typography.bodyMedium by default.
     */
    val descriptionStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.bodyMedium
    
    /**
     * Creates a [TitleDescriptionColors] with the provided colors or defaults from the theme.
     *
     * @param titleColor the color for the title text. Defaults to MaterialTheme.colorScheme.onSurface
     * @param descriptionColor the color for the description text. Defaults to MaterialTheme.colorScheme.onSurfaceVariant
     */
    @Composable
    fun colors(
        titleColor: Color = MaterialTheme.colorScheme.onSurface,
        descriptionColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ): TitleDescriptionColors = TitleDescriptionColors(
        titleColor = titleColor,
        descriptionColor = descriptionColor
    )
    
    /**
     * Emphasized title style variant.
     * Uses MaterialTheme.typography.displaySmall for larger emphasis.
     */
    val emphasizedTitleStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.displaySmall
    
    /**
     * Large title style variant.
     * Uses MaterialTheme.typography.headlineLarge for prominent titles.
     */
    val largeTitleStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.headlineLarge
}
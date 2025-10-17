package com.raerossi.orion.ui_kit.cards.stat_card.stat_card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingFlat
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * Contains the default values used by [StatCard].
 */
object StatCardDefaults {
    /**
     * Creates a [StatCardColors] that represents the default colors used in a [StatCard].
     *
     * @param containerColor The background color of the card container.
     * Defaults to [MaterialTheme.colorScheme.surface].
     * @param valueColor The color of the main value text.
     * Defaults to [MaterialTheme.colorScheme.onSurface].
     * @param labelColor The color of the label text.
     * Defaults to [MaterialTheme.colorScheme.onSurfaceVariant].
     * @param iconTint The tint color applied to the icon.
     * Defaults to [MaterialTheme.colorScheme.primary].
     * @param trendUpColor The color used for upward trends.
     * Defaults to green (#4CAF50).
     * @param trendDownColor The color used for downward trends.
     * Defaults to red (#F44336).
     * @param trendNeutralColor The color used for neutral trends.
     * Defaults to [MaterialTheme.colorScheme.onSurfaceVariant].
     */
    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        valueColor: Color = MaterialTheme.colorScheme.onSurface,
        labelColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        iconTint: Color = MaterialTheme.colorScheme.primary,
        trendUpColor: Color = Color(0xFF4CAF50),
        trendDownColor: Color = Color(0xFFF44336),
        trendNeutralColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ): StatCardColors = StatCardColors(
        containerColor = containerColor,
        valueColor = valueColor,
        labelColor = labelColor,
        iconTint = iconTint,
        trendUpColor = trendUpColor,
        trendDownColor = trendDownColor,
        trendNeutralColor = trendNeutralColor
    )

    /**
     * The default content padding used by [StatCard].
     *
     * @return [PaddingValues] of 16.dp on all sides
     */
    fun contentPadding(): PaddingValues = PaddingValues(16.dp)

    /**
     * The default shape used by [StatCard].
     *
     * Defaults to [MaterialTheme.shapes.medium].
     */
    val shape: Shape
        @Composable
        get() = MaterialTheme.shapes.medium

    /**
     * The default elevation used by [StatCard].
     *
     * @return [CardElevation] with default elevation of 2.dp
     */
    @Composable
    fun elevation(): CardElevation = CardDefaults.cardElevation(
        defaultElevation = 2.dp
    )

    /**
     * Returns the appropriate color for a given trend direction.
     *
     * @param direction The trend direction
     * @param colors The StatCard colors to use
     * @return The color corresponding to the trend direction
     */
    fun getTrendColor(
        direction: TrendDirection,
        colors: StatCardColors
    ): Color = when (direction) {
        TrendDirection.UP -> colors.trendUpColor
        TrendDirection.DOWN -> colors.trendDownColor
        TrendDirection.NEUTRAL -> colors.trendNeutralColor
    }

    /**
     * Returns the appropriate icon for a given trend direction.
     *
     * @param direction The trend direction
     * @return The icon vector corresponding to the trend direction
     */
    fun getTrendIcon(direction: TrendDirection): ImageVector = when (direction) {
        TrendDirection.UP -> Icons.AutoMirrored.Filled.TrendingUp
        TrendDirection.DOWN -> Icons.AutoMirrored.Filled.TrendingDown
        TrendDirection.NEUTRAL -> Icons.AutoMirrored.Filled.TrendingFlat
    }
}

package com.raerossi.orion.ui_kit.cards.expandable_card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Contains default values used by [ExpandableCard].
 */
object ExpandableCardDefaults {
    /**
     * The default shape for an ExpandableCard.
     */
    val shape: Shape
        @Composable get() = MaterialTheme.shapes.medium

    /**
     * The default tonal elevation for an ExpandableCard.
     */
    val tonalElevation: Dp = 1.dp

    /**
     * The default shadow elevation for an ExpandableCard.
     */
    val shadowElevation: Dp = 0.dp

    /**
     * The default padding for the header content.
     */
    val headerPadding: PaddingValues = PaddingValues(16.dp)

    /**
     * The default padding for the expandable content area.
     */
    val contentPadding: PaddingValues = PaddingValues(16.dp)

    /**
     * The default spacing between leading icon and title.
     */
    val iconSpacing: Dp = 12.dp

    val elevation: CardElevation
        @Composable get() = CardDefaults.elevatedCardElevation()

    /**
     * Creates [ExpandableCardColors] with default Material Design 3 colors.
     *
     * @param containerColor The background color of the card container
     * @param contentColor The color for content (text) inside the card
     * @param iconColor The color for icons
     * @param disabledContainerColor The background color when the card is disabled
     * @param disabledContentColor The content color when the card is disabled
     * @param disabledIconColor The icon color when the card is disabled
     */
    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledContainerColor: Color = MaterialTheme.colorScheme.surface.copy(alpha = 0.38f),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        disabledIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.38f)
    ): ExpandableCardColors = ExpandableCardColors(
        containerColor = containerColor,
        contentColor = contentColor,
        iconColor = iconColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        disabledIconColor = disabledIconColor
    )
}

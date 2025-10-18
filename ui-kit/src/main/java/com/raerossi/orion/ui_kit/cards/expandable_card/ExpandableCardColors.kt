package com.raerossi.orion.ui_kit.cards.expandable_card

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

/**
 * Represents the colors used by an [ExpandableCard] in different states.
 *
 * @param containerColor The background color of the card container
 * @param contentColor The color for content (text) inside the card
 * @param iconColor The color for icons (leading icon, chevron, action icons)
 * @param disabledContainerColor The background color when the card is disabled
 * @param disabledContentColor The content color when the card is disabled
 * @param disabledIconColor The icon color when the card is disabled
 */
@Immutable
data class ExpandableCardColors(
    val containerColor: Color,
    val contentColor: Color,
    val iconColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
    val disabledIconColor: Color
) {
    /**
     * Returns the container color based on the enabled state.
     *
     * @param enabled Whether the card is enabled
     */
    @Composable
    internal fun containerColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) containerColor else disabledContainerColor)
    }

    /**
     * Returns the content color based on the enabled state.
     *
     * @param enabled Whether the card is enabled
     */
    @Composable
    internal fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
    }

    /**
     * Returns the icon color based on the enabled state.
     *
     * @param enabled Whether the card is enabled
     */
    @Composable
    internal fun iconColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) iconColor else disabledIconColor)
    }
}

package com.raerossi.orion.ui_kit.cards.stat_card.stat_card

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Represents the color scheme for a [StatCard] component.
 *
 * @param containerColor The background color of the card container
 * @param valueColor The color of the main value text
 * @param labelColor The color of the label text
 * @param iconTint The tint color applied to the icon
 * @param trendUpColor The color used for upward trends (positive changes)
 * @param trendDownColor The color used for downward trends (negative changes)
 * @param trendNeutralColor The color used for neutral trends (no significant change)
 */
@Immutable
data class StatCardColors(
    val containerColor: Color,
    val valueColor: Color,
    val labelColor: Color,
    val iconTint: Color,
    val trendUpColor: Color,
    val trendDownColor: Color,
    val trendNeutralColor: Color
)

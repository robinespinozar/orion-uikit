package com.raerossi.orion.ui_kit.cards.stat_card.stat_card

/**
 * Represents the direction of a trend in a [StatCard].
 *
 * Used to determine the icon and color to display for the trend indicator.
 */
enum class TrendDirection {
    /**
     * Upward trend (positive change).
     * Displays trending up icon in green color.
     */
    UP,

    /**
     * Downward trend (negative change).
     * Displays trending down icon in red color.
     */
    DOWN,

    /**
     * Neutral trend (no significant change).
     * Displays flat trend icon in gray color.
     */
    NEUTRAL
}

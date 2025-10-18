package com.raerossi.orion.ui_kit.cards.expandable_card

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents an action button in the header of an [ExpandableCard].
 *
 * Actions are independent icon buttons that execute their own onClick callback
 * and do not trigger the expand/collapse behavior of the card.
 *
 * @param icon The icon to display for this action
 * @param contentDescription Content description for accessibility
 * @param onClick Callback invoked when this action is clicked
 * @param enabled Whether this action is enabled and clickable
 */
data class ExpandableCardAction(
    val icon: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit,
    val enabled: Boolean = true
)

package com.raerossi.orion.ui_kit.title_description

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Represents the colors used by a [TitleDescription] component.
 *
 * This follows Material Design 3 patterns for color configuration:
 * - Immutable data class for performance and predictability
 * - Separates title and description colors for flexibility
 * - Works with MaterialTheme.colorScheme for theming support
 *
 * @param titleColor the color for the title text
 * @param descriptionColor the color for the description text
 */
@Immutable
data class TitleDescriptionColors(
    val titleColor: Color,
    val descriptionColor: Color
)
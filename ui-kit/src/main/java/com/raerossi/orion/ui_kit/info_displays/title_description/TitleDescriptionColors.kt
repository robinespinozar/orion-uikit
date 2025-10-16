package com.raerossi.orion.ui_kit.info_displays.title_description

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Represents the colors used by a [TitleDescription] component.
 *
 * @param titleColor the color for the title text
 * @param descriptionColor the color for the description text
 */
@Immutable
data class TitleDescriptionColors(
    val titleColor: Color,
    val descriptionColor: Color
)
package com.raerossi.orion.ui_kit.selection.radio_button_group

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Contains default values used by RadioButtonGroup.
 */
object RadioButtonGroupDefaults {
    /**
     * Default spacing between radio button options
     */
    val spacing: Dp = 8.dp

    /**
     * Default padding applied to the entire group
     */
    val contentPadding: PaddingValues = PaddingValues(0.dp)

    /**
     * Default spacing between icon and label text
     */
    val iconSpacing: Dp = 12.dp

    /**
     * Creates default colors for a RadioButtonGroup based on Material Theme.
     *
     * @param selectedColor The color when selected
     * @param unselectedColor The color when not selected
     * @param disabledSelectedColor The color when selected and disabled
     * @param disabledUnselectedColor The color when not selected and disabled
     * @param textColor The color for labels
     * @param descriptionColor The color for descriptions
     * @param iconColor The color for icons
     */
    @Composable
    fun colors(
        selectedColor: Color = MaterialTheme.colorScheme.primary,
        unselectedColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledSelectedColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        disabledUnselectedColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        textColor: Color = MaterialTheme.colorScheme.onSurface,
        descriptionColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ): RadioButtonGroupColors = RadioButtonGroupColors(
        selectedColor = selectedColor,
        unselectedColor = unselectedColor,
        disabledSelectedColor = disabledSelectedColor,
        disabledUnselectedColor = disabledUnselectedColor,
        textColor = textColor,
        descriptionColor = descriptionColor,
        iconColor = iconColor
    )
}

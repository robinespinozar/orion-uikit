package com.raerossi.orion.ui_kit.selection.radio_button_group

import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

/**
 * Represents the colors used by a RadioButtonGroup in different states.
 *
 * @param selectedColor The color used when the radio button is selected
 * @param unselectedColor The color used when the radio button is not selected
 * @param disabledSelectedColor The color used when the radio button is selected and disabled
 * @param disabledUnselectedColor The color used when the radio button is not selected and disabled
 * @param textColor The color used for option labels
 * @param descriptionColor The color used for option descriptions
 * @param iconColor The color used for option icons
 */
data class RadioButtonGroupColors(
    val selectedColor: Color,
    val unselectedColor: Color,
    val disabledSelectedColor: Color,
    val disabledUnselectedColor: Color,
    val textColor: Color,
    val descriptionColor: Color,
    val iconColor: Color
) {
    /**
     * Returns RadioButtonColors for Material3 RadioButton component
     */
    @Composable
    internal fun radioButtonColors() = RadioButtonDefaults.colors(
        selectedColor = selectedColor,
        unselectedColor = unselectedColor,
        disabledSelectedColor = disabledSelectedColor,
        disabledUnselectedColor = disabledUnselectedColor
    )

    /**
     * Returns the text color based on enabled state
     */
    @Composable
    internal fun textColor(enabled: Boolean): State<Color> {
        val targetColor = if (enabled) textColor else textColor.copy(alpha = 0.38f)
        return rememberUpdatedState(targetColor)
    }

    /**
     * Returns the description color based on enabled state
     */
    @Composable
    internal fun descriptionColor(enabled: Boolean): State<Color> {
        val targetColor = if (enabled) descriptionColor else descriptionColor.copy(alpha = 0.38f)
        return rememberUpdatedState(targetColor)
    }

    /**
     * Returns the icon color based on enabled and selected states
     */
    @Composable
    internal fun iconColor(enabled: Boolean, selected: Boolean): State<Color> {
        val targetColor = when {
            !enabled -> iconColor.copy(alpha = 0.38f)
            selected -> selectedColor
            else -> iconColor
        }
        return rememberUpdatedState(targetColor)
    }
}

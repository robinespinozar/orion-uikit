package com.raerossi.orion.ui_kit.selection.radio_button_group

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data class representing a single radio button option.
 *
 * @param label The main text label for this option
 * @param description Optional secondary text displayed below the label
 * @param icon Optional icon displayed before the label
 * @param trailingContent Optional composable content displayed at the end of the option
 * @param enabled Whether this option is enabled and can be selected
 * @param detailText Optional clickable text link displayed at the end of the description (e.g., "Detail 3", "Learn more")
 * @param onDetailClick Optional callback invoked when the detail text is clicked
 */
data class RadioOption(
    val label: String,
    val description: String? = null,
    val icon: ImageVector? = null,
    val trailingContent: (@Composable () -> Unit)? = null,
    val enabled: Boolean = true,
    val detailText: String? = null,
    val onDetailClick: (() -> Unit)? = null
)

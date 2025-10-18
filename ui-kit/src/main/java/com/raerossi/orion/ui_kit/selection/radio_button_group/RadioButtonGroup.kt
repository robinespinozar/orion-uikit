package com.raerossi.orion.ui_kit.selection.radio_button_group

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Material Design 3 Radio Button Group component.
 *
 * A RadioButtonGroup displays a set of mutually exclusive options where only one can be selected
 * at a time. Supports both simple string options and rich RadioOption objects with icons,
 * descriptions, and custom content.
 *
 * Example usage with simple strings:
 * ```
 * var selectedIndex by remember { mutableStateOf(0) }
 * RadioButtonGroup(
 *     options = listOf("Option 1", "Option 2", "Option 3"),
 *     selectedIndex = selectedIndex,
 *     onOptionSelected = { selectedIndex = it }
 * )
 * ```
 *
 * Example usage with RadioOption:
 * ```
 * RadioButtonGroup(
 *     options = listOf(
 *         RadioOption(
 *             label = "Light Mode",
 *             description = "Bright theme",
 *             icon = Icons.Default.LightMode
 *         ),
 *         RadioOption(
 *             label = "Dark Mode",
 *             description = "Dark theme",
 *             icon = Icons.Default.DarkMode
 *         )
 *     ),
 *     selectedIndex = selectedIndex,
 *     onOptionSelected = { selectedIndex = it }
 * )
 * ```
 *
 * @param options List of string options to display
 * @param selectedIndex The index of the currently selected option
 * @param onOptionSelected Callback invoked when an option is selected, receives the option index
 * @param modifier Modifier to be applied to the group
 * @param enabled Whether the entire group is enabled
 * @param colors The colors to use for the radio buttons
 * @param spacing Spacing between radio button options
 * @param contentPadding Padding applied to the entire group
 */
@Composable
@JvmName("RadioButtonGroupStrings")
fun RadioButtonGroup(
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: RadioButtonGroupColors = RadioButtonGroupDefaults.colors(),
    spacing: Dp = RadioButtonGroupDefaults.spacing,
    contentPadding: PaddingValues = RadioButtonGroupDefaults.contentPadding
) {
    // Convert strings to RadioOption and delegate to main implementation
    val radioOptions = options.map { RadioOption(label = it) }
    RadioButtonGroup(
        options = radioOptions,
        selectedIndex = selectedIndex,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        spacing = spacing,
        contentPadding = contentPadding
    )
}

/**
 * Material Design 3 Radio Button Group component with rich options.
 *
 * @param options List of RadioOption objects to display
 * @param selectedIndex The index of the currently selected option
 * @param onOptionSelected Callback invoked when an option is selected, receives the option index
 * @param modifier Modifier to be applied to the group
 * @param enabled Whether the entire group is enabled
 * @param colors The colors to use for the radio buttons
 * @param spacing Spacing between radio button options
 * @param contentPadding Padding applied to the entire group
 */
@Composable
fun RadioButtonGroup(
    options: List<RadioOption>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: RadioButtonGroupColors = RadioButtonGroupDefaults.colors(),
    spacing: Dp = RadioButtonGroupDefaults.spacing,
    contentPadding: PaddingValues = RadioButtonGroupDefaults.contentPadding
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(contentPadding)
            .testTag("custom_radio_group"),
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        options.forEachIndexed { index, option ->
            RadioButtonOption(
                option = option,
                index = index,
                selected = index == selectedIndex,
                enabled = enabled && option.enabled,
                onClick = { onOptionSelected(index) },
                colors = colors
            )
        }
    }
}

/**
 * Internal composable for rendering a single radio button option.
 */
@Composable
private fun RadioButtonOption(
    option: RadioOption,
    index: Int,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
    colors: RadioButtonGroupColors
) {
    val textColor by colors.textColor(enabled)
    val descriptionColor by colors.descriptionColor(enabled)
    val iconColor by colors.iconColor(enabled, selected)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = enabled,
                onClick = onClick,
                role = Role.RadioButton
            )
            .testTag("radio_option_$index")
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null, // Click handled by Row
            enabled = enabled,
            colors = colors.radioButtonColors(),
            modifier = Modifier.testTag("radio_button_$index")
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Leading icon
        option.icon?.let { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.testTag("radio_option_icon_$index")
            )
            Spacer(modifier = Modifier.width(RadioButtonGroupDefaults.iconSpacing))
        }

        // Label and description
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = option.label,
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
            )

            // Description with optional detail link
            if (option.description != null || option.detailText != null) {
                val annotatedString = buildAnnotatedString {
                    // Add description if present
                    option.description?.let { description ->
                        withStyle(
                            style = SpanStyle(color = descriptionColor)
                        ) {
                            append(description)
                        }
                    }

                    // Add detail link if present
                    option.detailText?.let { detailText ->
                        if (option.description != null) {
                            append(" ")
                        }

                        pushStringAnnotation(
                            tag = "DETAIL_LINK",
                            annotation = "detail_click"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            append("($detailText)")
                        }
                        pop()
                    }
                }

                ClickableText(
                    text = annotatedString,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.testTag("radio_option_description_$index"),
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(
                            tag = "DETAIL_LINK",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            option.onDetailClick?.invoke()
                        }
                    }
                )
            }
        }

        // Trailing content
        option.trailingContent?.invoke()
    }
}

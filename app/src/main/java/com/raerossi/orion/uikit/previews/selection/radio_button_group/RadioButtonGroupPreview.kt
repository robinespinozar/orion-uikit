package com.raerossi.orion.uikit.previews.selection.radio_button_group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.selection.radio_button_group.RadioButtonGroup
import com.raerossi.orion.ui_kit.selection.radio_button_group.RadioOption
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@Preview(name = "Basic RadioButtonGroup", showBackground = true)
@Composable
private fun BasicRadioButtonGroupPreview() {
    OrionUiKitTheme {
        Surface {
            var selectedIndex by remember { mutableIntStateOf(0) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Basic Radio Button Group",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf("Option 1", "Option 2", "Option 3"),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}

@Preview(name = "RadioButtonGroup with Descriptions", showBackground = true)
@Composable
private fun RadioButtonGroupWithDescriptionsPreview() {
    OrionUiKitTheme {
        Surface {
            var selectedIndex by remember { mutableIntStateOf(0) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Subscription Plans",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Free",
                            description = "Basic features for personal use"
                        ),
                        RadioOption(
                            label = "Pro",
                            description = "Advanced features with priority support"
                        ),
                        RadioOption(
                            label = "Enterprise",
                            description = "Custom solutions for large teams"
                        )
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}

@Preview(name = "RadioButtonGroup with Icons", showBackground = true)
@Composable
private fun RadioButtonGroupWithIconsPreview() {
    OrionUiKitTheme {
        Surface {
            var selectedIndex by remember { mutableIntStateOf(0) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Theme Settings",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Light",
                            description = "Bright and clean interface",
                            icon = Icons.Default.LightMode
                        ),
                        RadioOption(
                            label = "Dark",
                            description = "Easy on the eyes at night",
                            icon = Icons.Default.DarkMode
                        ),
                        RadioOption(
                            label = "Auto",
                            description = "Follows system settings",
                            icon = Icons.Default.Brightness4
                        )
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}

@Preview(name = "RadioButtonGroup with Trailing Content", showBackground = true)
@Composable
private fun RadioButtonGroupWithTrailingContentPreview() {
    OrionUiKitTheme {
        Surface {
            var selectedIndex by remember { mutableIntStateOf(1) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Shipping Options",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Standard Shipping",
                            description = "5-7 business days",
                            trailingContent = {
                                Text(
                                    text = "Free",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        ),
                        RadioOption(
                            label = "Express Shipping",
                            description = "2-3 business days",
                            trailingContent = {
                                Text(
                                    text = "$9.99",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        ),
                        RadioOption(
                            label = "Next Day",
                            description = "Guaranteed tomorrow",
                            trailingContent = {
                                Text(
                                    text = "$19.99",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        )
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}

@Preview(name = "RadioButtonGroup - Disabled State", showBackground = true)
@Composable
private fun DisabledRadioButtonGroupPreview() {
    OrionUiKitTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Disabled Group",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf("Option 1", "Option 2", "Option 3"),
                    selectedIndex = 1,
                    onOptionSelected = {},
                    enabled = false
                )
            }
        }
    }
}

@Preview(name = "RadioButtonGroup - Individual Disabled Options", showBackground = true)
@Composable
private fun IndividualDisabledOptionsPreview() {
    OrionUiKitTheme {
        Surface {
            var selectedIndex by remember { mutableIntStateOf(0) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Privacy Settings",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Public",
                            description = "Anyone can see",
                            icon = Icons.Default.Public,
                            enabled = true
                        ),
                        RadioOption(
                            label = "Friends Only",
                            description = "Only your friends",
                            icon = Icons.Default.Person,
                            enabled = true
                        ),
                        RadioOption(
                            label = "Private",
                            description = "Premium feature",
                            icon = Icons.Default.Lock,
                            enabled = false
                        )
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}

@Preview(name = "All RadioButtonGroup Variants", showBackground = true)
@Composable
private fun AllRadioButtonGroupVariantsPreview() {
    OrionUiKitTheme {
        Surface {
            var basicSelected by remember { mutableIntStateOf(0) }
            var iconSelected by remember { mutableIntStateOf(1) }
            var shippingSelected by remember { mutableIntStateOf(0) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Basic
                Text(
                    text = "Basic Radio Group",
                    style = MaterialTheme.typography.titleLarge
                )
                RadioButtonGroup(
                    options = listOf("Option 1", "Option 2", "Option 3"),
                    selectedIndex = basicSelected,
                    onOptionSelected = { basicSelected = it }
                )

                HorizontalDivider()

                // With Icons
                Text(
                    text = "With Icons & Descriptions",
                    style = MaterialTheme.typography.titleLarge
                )
                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Light Mode",
                            description = "Bright interface",
                            icon = Icons.Default.LightMode
                        ),
                        RadioOption(
                            label = "Dark Mode",
                            description = "Dark interface",
                            icon = Icons.Default.DarkMode
                        )
                    ),
                    selectedIndex = iconSelected,
                    onOptionSelected = { iconSelected = it }
                )

                HorizontalDivider()

                // With Trailing Content
                Text(
                    text = "With Trailing Content",
                    style = MaterialTheme.typography.titleLarge
                )
                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Standard",
                            description = "5-7 days",
                            trailingContent = {
                                Text(
                                    text = "Free",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        ),
                        RadioOption(
                            label = "Express",
                            description = "2-3 days",
                            trailingContent = {
                                Text(
                                    text = "$9.99",
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                        )
                    ),
                    selectedIndex = shippingSelected,
                    onOptionSelected = { shippingSelected = it }
                )
            }
        }
    }
}

@Preview(name = "Dark Theme", uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RadioButtonGroupDarkPreview() {
    OrionUiKitTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var selectedIndex by remember { mutableIntStateOf(1) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Theme (Dark Mode)",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Light",
                            description = "Bright theme",
                            icon = Icons.Default.LightMode
                        ),
                        RadioOption(
                            label = "Dark",
                            description = "Dark theme",
                            icon = Icons.Default.DarkMode
                        ),
                        RadioOption(
                            label = "Auto",
                            description = "System default",
                            icon = Icons.Default.Brightness4
                        )
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}

@Preview(name = "RadioButtonGroup with Detail Links", showBackground = true)
@Composable
private fun RadioButtonGroupWithDetailLinksPreview() {
    OrionUiKitTheme {
        Surface {
            var selectedIndex by remember { mutableIntStateOf(2) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Select an option",
                    style = MaterialTheme.typography.headlineSmall
                )

                RadioButtonGroup(
                    options = listOf(
                        RadioOption(
                            label = "Item 1"
                        ),
                        RadioOption(
                            label = "Item 2",
                            description = "Description of item 2"
                        ),
                        RadioOption(
                            label = "Item 3",
                            description = "Description of item 3",
                            detailText = "Detail 3",
                            onDetailClick = {
                                // Handle detail click
                                println("Detail 3 clicked")
                            }
                        )
                    ),
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }
    }
}
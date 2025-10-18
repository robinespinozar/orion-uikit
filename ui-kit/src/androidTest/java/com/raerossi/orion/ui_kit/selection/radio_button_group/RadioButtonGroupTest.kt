package com.raerossi.orion.ui_kit.selection.radio_button_group

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * Tests for [RadioButtonGroup] following TDD (Test-Driven Development)
 *
 * Component requirements:
 * - Display a group of radio buttons with labels (vertical layout)
 * - Support string options and RadioOption data class
 * - Manage selection state (single selection)
 * - Support icons, descriptions, and trailing content per option
 * - Each option is clickable and triggers selection callback
 * - Visual feedback for selected/unselected states
 * - Support for enabled/disabled state (whole group and individual options)
 * - Customizable colors, spacing, and padding
 * - Material Design 3 styling
 * - Accessibility support with proper semantics
 *
 * Expected signature:
 * @Composable
 * fun RadioButtonGroup(
 *     options: List<String>,
 *     selectedIndex: Int,
 *     onOptionSelected: (Int) -> Unit,
 *     modifier: Modifier = Modifier,
 *     enabled: Boolean = true,
 *     colors: RadioButtonGroupColors = RadioButtonGroupDefaults.colors(),
 *     spacing: Dp = RadioButtonGroupDefaults.spacing,
 *     contentPadding: PaddingValues = RadioButtonGroupDefaults.contentPadding
 * )
 *
 * @Composable
 * fun RadioButtonGroup(
 *     options: List<RadioOption>,
 *     selectedIndex: Int,
 *     onOptionSelected: (Int) -> Unit,
 *     modifier: Modifier = Modifier,
 *     enabled: Boolean = true,
 *     colors: RadioButtonGroupColors = RadioButtonGroupDefaults.colors(),
 *     spacing: Dp = RadioButtonGroupDefaults.spacing,
 *     contentPadding: PaddingValues = RadioButtonGroupDefaults.contentPadding
 * )
 *
 * data class RadioOption(
 *     val label: String,
 *     val description: String? = null,
 *     val icon: ImageVector? = null,
 *     val trailingContent: (@Composable () -> Unit)? = null,
 *     val enabled: Boolean = true,
 *     val detailText: String? = null,
 *     val onDetailClick: (() -> Unit)? = null
 * )
 */
class RadioButtonGroupTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // ==================== Basic Display Tests ====================

    @Test
    fun radioButtonGroup_displaysAllOptions() {
        // Given: A RadioButtonGroup with three options
        val options = listOf("Option 1", "Option 2", "Option 3")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: All options should be displayed
        composeTestRule.onNodeWithText("Option 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Option 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Option 3").assertIsDisplayed()
    }

    @Test
    fun radioButtonGroup_displaysWithDescriptions() {
        // Given: A RadioButtonGroup with options that have descriptions
        val options = listOf(
            RadioOption(label = "Free", description = "Basic features"),
            RadioOption(label = "Pro", description = "All features")
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Labels and descriptions should be displayed
        composeTestRule.onNodeWithText("Free").assertIsDisplayed()
        composeTestRule.onNodeWithText("Basic features").assertIsDisplayed()
        composeTestRule.onNodeWithText("Pro").assertIsDisplayed()
        composeTestRule.onNodeWithText("All features").assertIsDisplayed()
    }

    @Test
    fun radioButtonGroup_displaysWithIcons() {
        // Given: A RadioButtonGroup with icons
        val options = listOf(
            RadioOption(
                label = "Light",
                icon = Icons.Default.LightMode,
            ),
            RadioOption(
                label = "Dark",
                icon = Icons.Default.DarkMode,
            )
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Icons should be displayed
        composeTestRule.onNodeWithTag("radio_option_icon_0").assertExists()
        composeTestRule.onNodeWithTag("radio_option_icon_1").assertExists()
    }

    @Test
    fun radioButtonGroup_displaysTrailingContent() {
        // Given: A RadioButtonGroup with trailing content
        val options = listOf(
            RadioOption(
                label = "Premium",
                trailingContent = { Text("$9.99") }
            ),
            RadioOption(
                label = "Basic",
                trailingContent = { Text("Free") }
            )
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Trailing content should be displayed
        composeTestRule.onNodeWithText("$9.99").assertIsDisplayed()
        composeTestRule.onNodeWithText("Free").assertIsDisplayed()
    }

    // ==================== Selection State Tests ====================

    @Test
    fun radioButtonGroup_firstOptionSelected_byDefault() {
        // Given: A RadioButtonGroup with selectedIndex = 0
        val options = listOf("Option 1", "Option 2", "Option 3")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: First radio button should be selected
        composeTestRule
            .onNodeWithTag("radio_button_0")
            .assertIsSelected()
    }

    @Test
    fun radioButtonGroup_correctOptionIsSelected() {
        // Given: A RadioButtonGroup with selectedIndex = 1
        val options = listOf("Option 1", "Option 2", "Option 3")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 1,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Second option should be selected, others not
        composeTestRule.onNodeWithTag("radio_button_0").assertIsNotSelected()
        composeTestRule.onNodeWithTag("radio_button_1").assertIsSelected()
        composeTestRule.onNodeWithTag("radio_button_2").assertIsNotSelected()
    }

    @Test
    fun radioButtonGroup_onlyOneOptionSelected_atATime() {
        // Given: A RadioButtonGroup
        val options = listOf("Option 1", "Option 2", "Option 3")

        // When: Different options are selected
        var selectedIndex = 0
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Initially first is selected
        composeTestRule.onNodeWithTag("radio_button_0").assertIsSelected()

        // Click second option
        composeTestRule.onNodeWithTag("radio_option_0").performClick()
        composeTestRule.waitForIdle()

        // Then: Only one should be selected at a time
        val selectedCount = (0..2).count { index ->
            try {
                composeTestRule.onNodeWithTag("radio_button_$index").assertIsSelected()
                true
            } catch (e: AssertionError) {
                false
            }
        }
        assert(selectedCount == 1) { "Expected exactly 1 selected option, but found $selectedCount" }
    }

    // ==================== Interaction Tests ====================

    @Test
    fun radioButtonGroup_optionIsClickable() {
        // Given: A RadioButtonGroup
        val options = listOf("Option 1", "Option 2")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Options should be clickable
        composeTestRule.onNodeWithTag("radio_option_0").assertHasClickAction()
        composeTestRule.onNodeWithTag("radio_option_1").assertHasClickAction()
    }

    @Test
    fun radioButtonGroup_clickOption_triggersCallback() {
        // Given: A RadioButtonGroup
        val options = listOf("Option 1", "Option 2", "Option 3")
        var selectedIndex = 0

        // When: An option is clicked
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Click second option
        composeTestRule.onNodeWithTag("radio_option_1").performClick()
        composeTestRule.waitForIdle()

        // Then: Callback should be triggered with correct index
        assert(selectedIndex == 1)
    }

    @Test
    fun radioButtonGroup_clickSelectedOption_doesNotChange() {
        // Given: A RadioButtonGroup with first option selected
        val options = listOf("Option 1", "Option 2")
        var selectedIndex = 0
        var callbackCount = 0

        // When: The selected option is clicked again
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = {
                        selectedIndex = it
                        callbackCount++
                    }
                )
            }
        }

        // Click the already selected option
        composeTestRule.onNodeWithTag("radio_option_0").performClick()
        composeTestRule.waitForIdle()

        // Then: Callback should still be triggered (standard radio behavior)
        assert(callbackCount == 1)
        assert(selectedIndex == 0)
    }

    @Test
    fun radioButtonGroup_switchBetweenOptions_updatesSelection() {
        // Given: A RadioButtonGroup
        val options = listOf("Option 1", "Option 2", "Option 3")
        var selectedIndex by mutableStateOf(0)

        // When: Different options are clicked
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Click option 2
        composeTestRule.onNodeWithTag("radio_option_1").performClick()
        composeTestRule.waitForIdle()
        assert(selectedIndex == 1)

        // Click option 3
        composeTestRule.onNodeWithTag("radio_option_2").performClick()
        composeTestRule.waitForIdle()
        assert(selectedIndex == 2)

        // Click option 1
        composeTestRule.onNodeWithTag("radio_option_0").performClick()
        composeTestRule.waitForIdle()
        assert(selectedIndex == 0)
    }

    // ==================== Enabled/Disabled Tests ====================

    @Test
    fun radioButtonGroup_disabledGroup_optionsNotClickable() {
        // Given: A disabled RadioButtonGroup
        val options = listOf("Option 1", "Option 2")
        var selectedIndex = 0

        // When: The component is rendered as disabled
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    enabled = false,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Click an option
        composeTestRule.onNodeWithTag("radio_option_1").performClick()
        composeTestRule.waitForIdle()

        // Then: Selection should not change
        assert(selectedIndex == 0)
    }

    @Test
    fun radioButtonGroup_disabledGroup_radioButtonsNotEnabled() {
        // Given: A disabled RadioButtonGroup
        val options = listOf("Option 1", "Option 2")

        // When: The component is rendered as disabled
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    enabled = false,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Radio buttons should not be enabled
        composeTestRule.onNodeWithTag("radio_button_0").assertIsNotEnabled()
        composeTestRule.onNodeWithTag("radio_button_1").assertIsNotEnabled()
    }

    @Test
    fun radioButtonGroup_individualOptionDisabled_notClickable() {
        // Given: A RadioButtonGroup with one disabled option
        val options = listOf(
            RadioOption(label = "Option 1", enabled = true),
            RadioOption(label = "Option 2", enabled = false),
            RadioOption(label = "Option 3", enabled = true)
        )
        var selectedIndex = 0

        // When: The disabled option is clicked
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Try to click the disabled option
        composeTestRule.onNodeWithTag("radio_option_1").performClick()
        composeTestRule.waitForIdle()

        // Then: Selection should not change
        assert(selectedIndex == 0)
    }

    @Test
    fun radioButtonGroup_individualOptionDisabled_radioButtonNotEnabled() {
        // Given: A RadioButtonGroup with one disabled option
        val options = listOf(
            RadioOption(label = "Option 1", enabled = true),
            RadioOption(label = "Option 2", enabled = false)
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Disabled option's radio button should not be enabled
        composeTestRule.onNodeWithTag("radio_button_0").assertIsEnabled()
        composeTestRule.onNodeWithTag("radio_button_1").assertIsNotEnabled()
    }

    // ==================== Styling Tests ====================

    @Test
    fun radioButtonGroup_appliesCustomModifier() {
        // Given: A RadioButtonGroup with custom modifier
        val options = listOf("Option 1", "Option 2")

        // When: The component is rendered with a test tag
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {},
                    modifier = Modifier.testTag("custom_radio_group")
                )
            }
        }

        // Then: The modifier should be applied
        composeTestRule.onNodeWithTag("custom_radio_group").assertExists()
    }

    @Test
    fun radioButtonGroup_usesDefaultColors() {
        // Given: A RadioButtonGroup without custom colors
        val options = listOf("Option 1", "Option 2")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Component should render successfully with defaults
        composeTestRule.onNodeWithText("Option 1").assertIsDisplayed()
    }

    @Test
    fun radioButtonGroup_acceptsCustomColors() {
        // Given: A RadioButtonGroup with custom colors
        val options = listOf("Option 1", "Option 2")

        // When: The component is rendered with custom colors
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {},
                    colors = RadioButtonGroupDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        unselectedColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }

        // Then: Component should render successfully
        composeTestRule.onNodeWithText("Option 1").assertIsDisplayed()
    }

    // ==================== Accessibility Tests ====================

    @Test
    fun radioButtonGroup_radioButtonsHaveRadioRole() {
        // Given: A RadioButtonGroup
        val options = listOf("Option 1", "Option 2")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Radio buttons should have Radio role
        composeTestRule
            .onNodeWithTag("radio_button_0")
            .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.RadioButton))
    }

    @Test
    fun radioButtonGroup_optionLabelsAreAccessible() {
        // Given: A RadioButtonGroup
        val options = listOf("Accessible Option 1", "Accessible Option 2")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Labels should be accessible
        composeTestRule.onNodeWithText("Accessible Option 1").assertExists()
        composeTestRule.onNodeWithText("Accessible Option 2").assertExists()
    }

    // ==================== Edge Cases Tests ====================

    @Test
    fun radioButtonGroup_singleOption_works() {
        // Given: A RadioButtonGroup with single option
        val options = listOf("Only Option")

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: The option should be displayed and selected
        composeTestRule.onNodeWithText("Only Option").assertIsDisplayed()
        composeTestRule.onNodeWithTag("radio_button_0").assertIsSelected()
    }

    @Test
    fun radioButtonGroup_manyOptions_allDisplayed() {
        // Given: A RadioButtonGroup with many options
        val options = (1..10).map { "Option $it" }

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: All options should exist
        options.forEach { option ->
            composeTestRule.onNodeWithText(option).assertExists()
        }
    }

    // ==================== Integration Tests ====================

    @Test
    fun radioButtonGroup_fullConfiguration_worksCorrectly() {
        // Given: A RadioButtonGroup with all features
        val options = listOf(
            RadioOption(
                label = "Premium",
                description = "All features",
                icon = Icons.Default.LightMode,
                trailingContent = { Text("$9.99") },
                enabled = true
            ),
            RadioOption(
                label = "Basic",
                description = "Limited features",
                icon = Icons.Default.DarkMode,
                trailingContent = { Text("Free") },
                enabled = true
            )
        )
        var selectedIndex by mutableStateOf(0)

        // When: The component is rendered with all options
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it },
                    modifier = Modifier.testTag("full_config_group")
                )
            }
        }

        // Then: All elements should be present and functional
        composeTestRule.onNodeWithText("Premium").assertIsDisplayed()
        composeTestRule.onNodeWithText("All features").assertIsDisplayed()
        composeTestRule.onNodeWithText("$9.99").assertIsDisplayed()
        composeTestRule.onNodeWithTag("radio_option_icon_0").assertExists()

        // Click second option
        composeTestRule.onNodeWithTag("radio_option_1").performClick()
        composeTestRule.waitForIdle()

        // Verify selection changed
        assert(selectedIndex == 1)
        composeTestRule.onNodeWithTag("radio_button_1").assertIsSelected()
    }

    @Test
    fun radioButtonGroup_stateManagement_persistsAcrossRecomposition() {
        // Given: A RadioButtonGroup with state
        var selectedIndex by mutableStateOf(0)
        val options = listOf("Option 1", "Option 2", "Option 3")

        // When: The component is rendered and selection changes
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Select second option
        composeTestRule.onNodeWithTag("radio_option_1").performClick()
        composeTestRule.waitForIdle()

        // Select third option
        composeTestRule.onNodeWithTag("radio_option_2").performClick()
        composeTestRule.waitForIdle()

        // Then: State should persist correctly
        assert(selectedIndex == 2)
        composeTestRule.onNodeWithTag("radio_button_2").assertIsSelected()
        composeTestRule.onNodeWithTag("radio_button_0").assertIsNotSelected()
        composeTestRule.onNodeWithTag("radio_button_1").assertIsNotSelected()
    }

    // ==================== Detail Link Tests ====================

    @Test
    fun radioButtonGroup_displaysDetailText() {
        // Given: A RadioButtonGroup with detail text
        val options = listOf(
            RadioOption(
                label = "Item 1",
                description = "Description of item 1",
                detailText = "Detail 1"
            )
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Detail text should be displayed
        composeTestRule.onNodeWithText("Description of item 1 (Detail 1)").assertIsDisplayed()
    }

    @Test
    fun radioButtonGroup_detailText_triggersCallback() {
        // Given: A RadioButtonGroup with detail text and callback
        var detailClicked = false
        val options = listOf(
            RadioOption(
                label = "Item 1",
                description = "Description",
                detailText = "Learn more",
                onDetailClick = { detailClicked = true }
            )
        )

        // When: The component is rendered and detail text is clicked
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Click the description (which contains the detail link)
        composeTestRule.onNodeWithTag("radio_option_description_0").performClick()

        // Then: Detail callback should be triggered
        assert(detailClicked)
    }

    @Test
    fun radioButtonGroup_detailTextWithoutDescription_displays() {
        // Given: A RadioButtonGroup with detail text but no description
        val options = listOf(
            RadioOption(
                label = "Item 1",
                detailText = "Learn more"
            )
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Then: Detail text should still be displayed
        composeTestRule.onNodeWithText("(Learn more)").assertIsDisplayed()
    }

    @Test
    fun radioButtonGroup_detailClick_doesNotSelectOption() {
        // Given: A RadioButtonGroup with detail link on unselected option
        var selectedIndex = 0
        var detailClicked = false
        val options = listOf(
            RadioOption(label = "Item 1"),
            RadioOption(
                label = "Item 2",
                description = "Description",
                detailText = "Details",
                onDetailClick = { detailClicked = true }
            )
        )

        // When: The detail link is clicked
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = selectedIndex,
                    onOptionSelected = { selectedIndex = it }
                )
            }
        }

        // Click the detail link (via description)
        composeTestRule.onNodeWithTag("radio_option_description_1").performClick()
        composeTestRule.waitForIdle()

        // Then: Detail callback triggered but option not selected
        assert(detailClicked)
        assert(selectedIndex == 0) // Should still be first option
    }

    @Test
    fun radioButtonGroup_multipleOptionsWithDetailLinks() {
        // Given: Multiple options with detail links
        var detail1Clicked = false
        var detail2Clicked = false
        val options = listOf(
            RadioOption(
                label = "Item 1",
                description = "Desc 1",
                detailText = "Detail 1",
                onDetailClick = { detail1Clicked = true }
            ),
            RadioOption(
                label = "Item 2",
                description = "Desc 2",
                detailText = "Detail 2",
                onDetailClick = { detail2Clicked = true }
            )
        )

        // When: The component is rendered
        composeTestRule.setContent {
            MaterialTheme {
                RadioButtonGroup(
                    options = options,
                    selectedIndex = 0,
                    onOptionSelected = {}
                )
            }
        }

        // Click first detail link
        composeTestRule.onNodeWithTag("radio_option_description_0").performClick()
        assert(detail1Clicked)
        assert(!detail2Clicked)

        // Click second detail link
        composeTestRule.onNodeWithTag("radio_option_description_1").performClick()
        assert(detail2Clicked)
    }
}

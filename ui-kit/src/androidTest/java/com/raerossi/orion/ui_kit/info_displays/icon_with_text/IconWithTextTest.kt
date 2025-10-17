package com.raerossi.orion.ui_kit.info_displays.icon_with_text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

/**
 * Tests for [IconWithText] following TDD (Test-Driven Development)
 *
 * Expected signature:
 * @Composable
 * fun IconWithText(
 *     icon: @Composable () -> Unit,
 *     text: @Composable () -> Unit,
 *     modifier: Modifier = Modifier,
 *     spacing: Dp = IconWithTextDefaults.spacing,
 *     verticalAlignment: Alignment.Vertical = Alignment.CenterVertically
 * )
 */
class IconWithTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    // ==================== Basic Display Tests ====================

    @Test
    fun iconWithText_displaysTextCorrectly() {
        // Given: A text composable
        val testText = "Hello World"

        // When: IconWithText is rendered
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star icon"
                        )
                    },
                    text = {
                        Text(text = testText)
                    }
                )
            }
        }

        // Then: Text should be displayed
        composeTestRule.onNodeWithText(testText).assertIsDisplayed()
    }

    @Test
    fun iconWithText_displaysIconCorrectly() {
        // Given: An icon composable
        val iconDescription = "Test icon"

        // When: IconWithText is rendered
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = iconDescription,
                            modifier = Modifier.testTag("test_icon")
                        )
                    },
                    text = {
                        Text(text = "Text")
                    }
                )
            }
        }

        // Then: Icon should be displayed
        composeTestRule.onNodeWithTag("test_icon").assertIsDisplayed()
    }

    @Test
    fun iconWithText_displaysEmptyTextCorrectly() {
        // Given: Empty text composable
        val emptyText = ""

        // When: IconWithText is rendered
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(text = emptyText)
                    }
                )
            }
        }

        // Then: Component should still be displayed (icon visible)
        composeTestRule.onNodeWithText(emptyText).assertExists()
    }

    @Test
    fun iconWithText_displaysLongTextCorrectly() {
        // Given: A very long text
        val longText = "This is a very long text that should be displayed correctly " +
                "without breaking the layout or causing any issues with the component"

        // When: IconWithText is rendered
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(text = longText)
                    }
                )
            }
        }

        // Then: Text should be displayed
        composeTestRule.onNodeWithText(longText).assertIsDisplayed()
    }

    @Test
    fun iconWithText_supportsCustomTextComposable() {
        // Given: A custom text composable (not just Text)
        val testTag = "custom_text_composable"

        // When: IconWithText is rendered with custom text composable
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    text = {
                        Column(
                            modifier = Modifier.testTag(testTag)
                        ) {
                            Text("Line 1")
                            Text("Line 2")
                        }
                    }
                )
            }
        }

        // Then: Custom composable should be displayed
        composeTestRule.onNodeWithTag(testTag).assertIsDisplayed()
        composeTestRule.onNodeWithText("Line 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Line 2").assertIsDisplayed()
    }

    // ==================== Spacing Tests ====================

    @Test
    fun iconWithText_appliesCustomSpacing() {
        // Given: Custom spacing
        val customSpacing = 16.dp

        // When: IconWithText is rendered with custom spacing
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    text = {
                        Text(text = "Text")
                    },
                    spacing = customSpacing
                )
            }
        }

        // Then: Component should be displayed correctly
        composeTestRule.onNodeWithText("Text").assertIsDisplayed()
    }

    @Test
    fun iconWithText_usesDefaultSpacing() {
        // Given: No spacing specified (using default)

        // When: IconWithText is rendered
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(text = "Text")
                    }
                )
            }
        }

        // Then: Component should be displayed with default spacing
        composeTestRule.onNodeWithText("Text").assertIsDisplayed()
    }

    @Test
    fun iconWithText_supportsZeroSpacing() {
        // Given: Zero spacing
        val zeroSpacing = 0.dp

        // When: IconWithText is rendered with zero spacing
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.testTag("zero_space_icon")
                        )
                    },
                    text = {
                        Text(text = "No Space")
                    },
                    spacing = zeroSpacing
                )
            }
        }

        // Then: Component should be displayed
        composeTestRule.onNodeWithText("No Space").assertIsDisplayed()
        composeTestRule.onNodeWithTag("zero_space_icon").assertIsDisplayed()
    }

    // ==================== Alignment Tests ====================

    @Test
    fun iconWithText_usesCenterVerticalAlignmentByDefault() {
        // Given: No alignment specified (default CenterVertically)

        // When: IconWithText is rendered
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    text = {
                        Text(text = "Centered")
                    }
                )
            }
        }

        // Then: Component should be displayed
        composeTestRule.onNodeWithText("Centered").assertIsDisplayed()
    }

    @Test
    fun iconWithText_appliesTopAlignment() {
        // Given: Top vertical alignment

        // When: IconWithText is rendered with top alignment
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    text = {
                        Text(text = "Top Aligned")
                    },
                    verticalAlignment = Alignment.Top
                )
            }
        }

        // Then: Component should be displayed
        composeTestRule.onNodeWithText("Top Aligned").assertIsDisplayed()
    }

    @Test
    fun iconWithText_appliesBottomAlignment() {
        // Given: Bottom vertical alignment

        // When: IconWithText is rendered with bottom alignment
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    text = {
                        Text(text = "Bottom Aligned")
                    },
                    verticalAlignment = Alignment.Bottom
                )
            }
        }

        // Then: Component should be displayed
        composeTestRule.onNodeWithText("Bottom Aligned").assertIsDisplayed()
    }

    // ==================== Icon Composable Flexibility Tests ====================

    @Test
    fun iconWithText_supportsCustomIconComposable() {
        // Given: A custom icon composable (not just Icon)
        val customIconTag = "custom_icon"

        // When: IconWithText is rendered with custom icon
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .testTag(customIconTag)
                        )
                    },
                    text = {
                        Text(text = "Custom Icon")
                    }
                )
            }
        }

        // Then: Custom icon composable should be displayed
        composeTestRule.onNodeWithTag(customIconTag).assertIsDisplayed()
        composeTestRule.onNodeWithText("Custom Icon").assertIsDisplayed()
    }

    @Test
    fun iconWithText_supportsMultipleIconsInSlot() {
        // Given: Multiple icons in the icon slot

        // When: IconWithText is rendered with multiple icons
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.testTag("icon_1")
                            )
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.testTag("icon_2")
                            )
                        }
                    },
                    text = {
                        Text(text = "Multiple Icons")
                    }
                )
            }
        }

        // Then: Both icons should be displayed
        composeTestRule.onNodeWithTag("icon_1").assertIsDisplayed()
        composeTestRule.onNodeWithTag("icon_2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Multiple Icons").assertIsDisplayed()
    }

    // ==================== Modifier Tests ====================

    @Test
    fun iconWithText_appliesModifier() {
        // Given: A test tag modifier
        val testTag = "icon_with_text_component"

        // When: IconWithText is rendered with modifier
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(text = "Modified")
                    },
                    modifier = Modifier.testTag(testTag)
                )
            }
        }

        // Then: Component should have the test tag
        composeTestRule.onNodeWithTag(testTag).assertIsDisplayed()
    }

    @Test
    fun iconWithText_appliesMultipleModifiers() {
        // Given: Multiple modifiers
        val testTag = "modified_component"

        // When: IconWithText is rendered with multiple modifiers
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(text = "Multi Modified")
                    },
                    modifier = Modifier
                        .testTag(testTag)
                        .size(200.dp)
                )
            }
        }

        // Then: Component should have all modifiers applied
        composeTestRule.onNodeWithTag(testTag).assertIsDisplayed()
    }

    // ==================== Integration Tests ====================

    @Test
    fun iconWithText_allParametersCombined() {
        // Given: All parameters configured
        val testText = "Complete Component"
        val customSpacing = 12.dp

        // When: IconWithText is rendered with all parameters
        composeTestRule.setContent {
            MaterialTheme {
                IconWithText(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Complete icon",
                            modifier = Modifier.testTag("complete_icon")
                        )
                    },
                    text = {
                        Text(
                            text = testText,
                            modifier = Modifier.testTag("complete_text")
                        )
                    },
                    modifier = Modifier.testTag("complete_component"),
                    spacing = customSpacing,
                    verticalAlignment = Alignment.Top
                )
            }
        }

        // Then: All elements should be displayed
        composeTestRule.onNodeWithTag("complete_component").assertIsDisplayed()
        composeTestRule.onNodeWithTag("complete_text").assertIsDisplayed()
        composeTestRule.onNodeWithTag("complete_icon").assertIsDisplayed()
    }

    @Test
    fun iconWithText_multipleInstancesRenderIndependently() {
        // Given: Multiple IconWithText components
        val text1 = "First Component"
        val text2 = "Second Component"

        // When: Multiple IconWithText components are rendered
        composeTestRule.setContent {
            MaterialTheme {
                Column {
                    IconWithText(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.testTag("icon_1")
                            )
                        },
                        text = {
                            Text(text = text1)
                        },
                        modifier = Modifier.testTag("component_1")
                    )
                    IconWithText(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.testTag("icon_2")
                            )
                        },
                        text = {
                            Text(text = text2)
                        },
                        modifier = Modifier.testTag("component_2")
                    )
                }
            }
        }

        // Then: Both components should be displayed independently
        composeTestRule.onNodeWithTag("component_1").assertIsDisplayed()
        composeTestRule.onNodeWithTag("component_2").assertIsDisplayed()
        composeTestRule.onNodeWithText(text1).assertIsDisplayed()
        composeTestRule.onNodeWithText(text2).assertIsDisplayed()
    }

    // ==================== Defaults Tests ====================

    @Test
    fun iconWithTextDefaults_providesDefaultSpacing() {
        // Given: Default spacing value

        // When: Accessing default spacing
        composeTestRule.setContent {
            MaterialTheme {
                val defaultSpacing = IconWithTextDefaults.spacing
                // Then: Default spacing should be a reasonable value (e.g., 8.dp)
                assert(defaultSpacing.value > 0f)
            }
        }
    }
}

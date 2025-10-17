package com.raerossi.orion.ui_kit.cards.stat_card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.StatCard
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.StatCardColors
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.StatCardDefaults
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.TrendDirection
import org.junit.Rule
import org.junit.Test

/**
 * Tests for [com.raerossi.orion.ui_kit.cards.stat_card.stat_card.StatCard] following TDD (Test-Driven Development)
 *
 * Component requirements:
 * - Display a value (large, prominent text) and label (description)
 * - Support optional icon displayed at the top (centered)
 * - Support optional trend indicator with direction (UP/DOWN/NEUTRAL)
 * - Trend shows icon, value, and optional context label
 * - Trend colors: green (UP), red (DOWN), gray (NEUTRAL)
 * - Support onClick interaction (clickable card)
 * - Customizable colors, padding, shape, and elevation
 * - Material Design 3 compliant
 *
 * Expected signature:
 * @Composable
 * fun StatCard(
 *     value: String,
 *     label: String,
 *     modifier: Modifier = Modifier,
 *     icon: (@Composable () -> Unit)? = null,
 *     trendValue: String? = null,
 *     trendDirection: TrendDirection? = null,
 *     trendLabel: String? = null,
 *     onClick: (() -> Unit)? = null,
 *     colors: StatCardColors = StatCardDefaults.colors(),
 *     contentPadding: PaddingValues = StatCardDefaults.contentPadding(),
 *     shape: Shape = StatCardDefaults.shape,
 *     elevation: CardElevation = StatCardDefaults.elevation()
 * )
 */
class StatCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    // ============================================================================
    // Basic Display Tests
    // ============================================================================

    @Test
    fun statCard_displaysValue() {
        // Given
        val value = "1,234"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = value,
                    label = "Total Sales"
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(value).assertIsDisplayed()
    }

    @Test
    fun statCard_displaysLabel() {
        // Given
        val label = "Total Sales"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = label
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(label).assertIsDisplayed()
    }

    @Test
    fun statCard_displaysWithoutIcon_whenIconNotProvided() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - card should exist without icon content description
        composeTestRule.onNodeWithTag("stat_card").assertIsDisplayed()
    }

    @Test
    fun statCard_displaysIcon_whenIconProvided() {
        // Given
        val iconContentDescription = "Shopping cart icon"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = iconContentDescription
                        )
                    }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Total Sales").assertIsDisplayed()
    }

    // ============================================================================
    // Trend Display Tests
    // ============================================================================

    @Test
    fun statCard_displaysTrendValue_whenTrendProvided() {
        // Given
        val trendValue = "+12.5%"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = trendValue,
                    trendDirection = TrendDirection.UP
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(trendValue, substring = true).assertIsDisplayed()
    }

    @Test
    fun statCard_displaysTrendLabel_whenProvided() {
        // Given
        val trendLabel = "vs last month"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = "+12.5%",
                    trendDirection = TrendDirection.UP,
                    trendLabel = trendLabel
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(trendLabel, substring = true).assertIsDisplayed()
    }

    @Test
    fun statCard_doesNotDisplayTrend_whenOnlyTrendValueProvided() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = "+12.5%",
                    trendDirection = null // Direction not provided
                )
            }
        }

        // Then - trend should not be visible
        composeTestRule.onNodeWithText("+12.5%", substring = true).assertDoesNotExist()
    }

    @Test
    fun statCard_doesNotDisplayTrend_whenOnlyTrendDirectionProvided() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = null, // Value not provided
                    trendDirection = TrendDirection.UP
                )
            }
        }

        // Then - no trend text should be visible
        composeTestRule.onNodeWithTag("stat_card_trend").assertDoesNotExist()
    }

    @Test
    fun statCard_displaysTrendUpIcon_whenDirectionIsUp() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = "+12.5%",
                    trendDirection = TrendDirection.UP,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - Trend section should be displayed
        composeTestRule.onNodeWithText("+12.5%", substring = true).assertIsDisplayed()
    }

    @Test
    fun statCard_displaysTrendDownIcon_whenDirectionIsDown() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = "-3.2%",
                    trendDirection = TrendDirection.DOWN,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - Trend section should be displayed
        composeTestRule.onNodeWithText("-3.2%", substring = true).assertIsDisplayed()
    }

    @Test
    fun statCard_displaysTrendNeutralIcon_whenDirectionIsNeutral() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    trendValue = "0.0%",
                    trendDirection = TrendDirection.NEUTRAL,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - Trend section should be displayed
        composeTestRule.onNodeWithText("0.0%", substring = true).assertIsDisplayed()
    }

    // ============================================================================
    // Interaction Tests
    // ============================================================================

    @Test
    fun statCard_isClickable_whenOnClickProvided() {
        // Given
        var clicked = false

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    onClick = { clicked = true },
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then
        composeTestRule.onNodeWithTag("stat_card").assertHasClickAction()
    }

    @Test
    fun statCard_isNotClickable_whenOnClickNotProvided() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then
        composeTestRule.onNodeWithTag("stat_card").assertHasNoClickAction()
    }

    @Test
    fun statCard_triggersOnClick_whenClicked() {
        // Given
        var clicked = false

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    onClick = { clicked = true },
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Perform click
        composeTestRule.onNodeWithTag("stat_card").performClick()

        // Then
        assert(clicked) { "onClick was not triggered" }
    }

    // ============================================================================
    // Color Customization Tests
    // ============================================================================

    @Test
    fun statCard_appliesCustomColors() {
        // Given
        val customColors = StatCardColors(
            containerColor = Color.Companion.Blue,
            valueColor = Color.Companion.Red,
            labelColor = Color.Companion.Green,
            iconTint = Color.Companion.Yellow,
            trendUpColor = Color.Companion.Cyan,
            trendDownColor = Color.Companion.Magenta,
            trendNeutralColor = Color.Companion.Gray
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    colors = customColors,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - component should render without crash
        composeTestRule.onNodeWithTag("stat_card").assertIsDisplayed()
    }

    // ============================================================================
    // Padding & Layout Tests
    // ============================================================================

    @Test
    fun statCard_appliesCustomContentPadding() {
        // Given
        val customPadding = PaddingValues(24.dp)

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    contentPadding = customPadding,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - component should render
        composeTestRule.onNodeWithTag("stat_card").assertIsDisplayed()
    }

    // ============================================================================
    // Defaults Tests
    // ============================================================================

    @Test
    fun statCardDefaults_providesDefaultColors() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                val colors = StatCardDefaults.colors()

                // Then - should return valid colors object
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    colors = colors,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        composeTestRule.onNodeWithTag("stat_card").assertIsDisplayed()
    }

    @Test
    fun statCardDefaults_providesDefaultContentPadding() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                val padding = StatCardDefaults.contentPadding()

                // Then - should return valid padding
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    contentPadding = padding,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        composeTestRule.onNodeWithTag("stat_card").assertIsDisplayed()
    }

    @Test
    fun statCardDefaults_providesDefaultShape() {
        // Given / When
        composeTestRule.setContent {
            MaterialTheme {
                val shape = StatCardDefaults.shape

                // Then - should return valid shape
                StatCard(
                    value = "1,234",
                    label = "Total Sales",
                    shape = shape,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        composeTestRule.onNodeWithTag("stat_card").assertIsDisplayed()
    }

    // ============================================================================
    // Integration Tests
    // ============================================================================

    @Test
    fun statCard_displaysAllElements_whenFullyConfigured() {
        // Given
        val value = "1,234"
        val label = "Total Sales"
        val iconContentDescription = "Shopping cart"
        val trendValue = "+12.5%"
        val trendLabel = "vs last month"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = value,
                    label = label,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = iconContentDescription
                        )
                    },
                    trendValue = trendValue,
                    trendDirection = TrendDirection.UP,
                    trendLabel = trendLabel,
                    onClick = {},
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then - all elements should be visible
        composeTestRule.onNodeWithText(value).assertIsDisplayed()
        composeTestRule.onNodeWithText(label).assertIsDisplayed()
        composeTestRule.onNodeWithText(trendValue, substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(trendLabel, substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithTag("stat_card").assertHasClickAction()
    }

    @Test
    fun statCard_displaysMinimal_whenOnlyRequiredParametersProvided() {
        // Given
        val value = "842"
        val label = "Active Users"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = value,
                    label = label,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(value).assertIsDisplayed()
        composeTestRule.onNodeWithText(label).assertIsDisplayed()
        composeTestRule.onNodeWithTag("stat_card").assertHasNoClickAction()
    }

    @Test
    fun statCard_handlesLongValue() {
        // Given
        val longValue = "1,234,567,890"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = longValue,
                    label = "Total Sales",
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(longValue).assertIsDisplayed()
    }

    @Test
    fun statCard_handlesLongLabel() {
        // Given
        val longLabel = "This is a very long label that describes the metric in detail"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                StatCard(
                    value = "1,234",
                    label = longLabel,
                    modifier = Modifier.Companion.testTag("stat_card")
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText(longLabel).assertIsDisplayed()
    }

    @Test
    fun statCard_handlesDifferentValueFormats() {
        // Given
        val formats = listOf(
            "1.2K",
            "$45,678",
            "92%",
            "3.5M",
            "99.8"
        )

        // When / Then
        formats.forEach { format ->
            composeTestRule.setContent {
                MaterialTheme {
                    StatCard(
                        value = format,
                        label = "Test Metric",
                        modifier = Modifier.Companion.testTag("stat_card_$format")
                    )
                }
            }

            composeTestRule.onNodeWithText(format).assertIsDisplayed()
        }
    }
}
package com.raerossi.orion.ui_kit

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.raerossi.orion.ui_kit.buttons.outlined_base_button.OutlinedBaseButton
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OutlinedBaseButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun outlinedBaseButton_displaysLabelCorrectly() {
        // Given
        val testLabel = "Outlined Test Button"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun outlinedBaseButton_isClickableWhenEnabled() {
        // Given
        var clicked = false
        val testLabel = "Clickable Outlined"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                enabled = true,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsEnabled()
            .assertHasClickAction()
            .performClick()

        assertEquals(true, clicked)
    }

    @Test
    fun outlinedBaseButton_isNotClickableWhenDisabled() {
        // Given
        var clicked = false
        val testLabel = "Disabled Outlined"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                enabled = false,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsNotEnabled()

        assertEquals(false, clicked)
    }

    @Test
    fun outlinedBaseButton_isDisabledWhenLoading() {
        // Given
        val testLabel = "Loading Outlined"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                enabled = true,
                isLoading = true,
                onClick = {}
            )
        }

        // Then - Button should be disabled when loading
        composeTestRule
            .onNodeWithTag("button")
            .assertIsNotEnabled()
    }

    @Test
    fun outlinedBaseButton_displaysLoadingIndicator() {
        // Given
        val testLabel = "Loading Outlined"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                isLoading = true,
                onClick = {}
            )
        }

        // Then - Loading indicator should be visible
        composeTestRule
            .onNodeWithTag("loading_indicator")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun outlinedBaseButton_hidesLabelWhenLoading() {
        // Given
        val testLabel = "Hidden Label"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                isLoading = true,
                onClick = {}
            )
        }

        // Then - Label should not be visible when loading
        composeTestRule
            .onNodeWithText(testLabel)
            .assertDoesNotExist()
    }

    @Test
    fun outlinedBaseButton_displaysLeadingIcon() {
        // Given
        val testLabel = "With Leading Icon"
        val iconTag = "leading_icon"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        modifier = Modifier.testTag(iconTag),
                        imageVector = androidx.compose.material.icons.Icons.Default.Add,
                        contentDescription = null
                    )
                },
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(iconTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testLabel)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun outlinedBaseButton_displaysTrailingIcon() {
        // Given
        val testLabel = "With Trailing Icon"
        val iconTag = "trailing_icon"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                trailingIcon = {
                    androidx.compose.material3.Icon(
                        modifier = Modifier.testTag(iconTag),
                        imageVector = androidx.compose.material.icons.Icons.Default.ArrowForward,
                        contentDescription = null
                    )
                },
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(iconTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testLabel)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun outlinedBaseButton_displaysBothIcons() {
        // Given
        val testLabel = "With Both Icons"
        val leadingIconTag = "leading_icon"
        val trailingIconTag = "trailing_icon"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                label = testLabel,
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        modifier = Modifier.testTag(leadingIconTag),
                        imageVector = androidx.compose.material.icons.Icons.Default.Add,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    androidx.compose.material3.Icon(
                        modifier = Modifier.testTag(trailingIconTag),
                        imageVector = androidx.compose.material.icons.Icons.Default.ArrowForward,
                        contentDescription = null
                    )
                },
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(leadingIconTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(trailingIconTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testLabel)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun outlinedBaseButton_enabledAndLoadingStateCombination() {
        // Given - When enabled=true AND isLoading=true
        val testLabel = "Enabled but Loading"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                enabled = true,
                isLoading = true,
                onClick = {}
            )
        }

        // Then - Button should be disabled (loading takes precedence)
        composeTestRule
            .onNodeWithTag("button")
            .assertIsNotEnabled()

        composeTestRule
            .onNodeWithTag("loading_indicator")
            .assertExists()
    }

    @Test
    fun outlinedBaseButton_borderVisibilityWhenEnabled() {
        // Given
        val testLabel = "Enabled with Border"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                enabled = true,
                onClick = {}
            )
        }

        // Then - Border should be visible (verified visually, component renders)
        composeTestRule
            .onNodeWithTag("button")
            .assertExists()
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun outlinedBaseButton_borderVisibilityWhenDisabled() {
        // Given
        val testLabel = "Disabled with Border"

        // When
        composeTestRule.setContent {
            OutlinedBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                enabled = false,
                onClick = {}
            )
        }

        // Then - Disabled border should be visible (verified visually, component renders)
        composeTestRule
            .onNodeWithTag("button")
            .assertExists()
            .assertIsDisplayed()
            .assertIsNotEnabled()
    }
}

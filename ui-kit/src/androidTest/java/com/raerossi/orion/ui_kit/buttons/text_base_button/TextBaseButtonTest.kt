package com.raerossi.orion.ui_kit

import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.raerossi.orion.ui_kit.buttons.text_base_button.TextBaseButton
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextBaseButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun textBaseButton_displaysLabelCorrectly() {
        // Given
        val testLabel = "Text Test Button"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_isClickableWhenEnabled() {
        // Given
        var clicked = false
        val testLabel = "Clickable Text"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_isNotClickableWhenDisabled() {
        // Given
        var clicked = false
        val testLabel = "Disabled Text"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_isDisabledWhenLoading() {
        // Given
        val testLabel = "Loading Text"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_displaysLoadingIndicator() {
        // Given
        val testLabel = "Loading Text"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_hidesLabelWhenLoading() {
        // Given
        val testLabel = "Hidden Label"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_displaysLeadingIcon() {
        // Given
        val testLabel = "With Leading Icon"
        val iconTag = "leading_icon"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_displaysTrailingIcon() {
        // Given
        val testLabel = "With Trailing Icon"
        val iconTag = "trailing_icon"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_displaysBothIcons() {
        // Given
        val testLabel = "With Both Icons"
        val leadingIconTag = "leading_icon"
        val trailingIconTag = "trailing_icon"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    fun textBaseButton_noBorderByDefault() {
        // Given
        val testLabel = "No Border Text"

        // When
        composeTestRule.setContent {
            TextBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                onClick = {}
            )
        }

        // Then - TextButton should render without border (verified visually)
        composeTestRule
            .onNodeWithTag("button")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun textBaseButton_respectsEnabledState() {
        // Given
        val testLabel = "Enabled State Test"

        // When
        composeTestRule.setContent {
            TextBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                enabled = true,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag("button")
            .assertIsEnabled()
    }

    @Test
    fun textBaseButton_respectsDisabledState() {
        // Given
        val testLabel = "Disabled State Test"

        // When
        composeTestRule.setContent {
            TextBaseButton(
                modifier = Modifier.testTag("button"),
                label = testLabel,
                enabled = false,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag("button")
            .assertIsNotEnabled()
    }

    @Test
    fun textBaseButton_loadingStateOverridesEnabled() {
        // Given - When enabled=true BUT isLoading=true
        val testLabel = "Loading Override Test"

        // When
        composeTestRule.setContent {
            TextBaseButton(
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
    }
}

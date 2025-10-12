package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

/**
 * Tests para BaseButton siguiendo TDD (Test-Driven Development)
 * 
 * Estos tests definen el comportamiento esperado del componente BaseButton:
 * - Debe mostrar el label correctamente
 * - Debe ser clickeable cuando está habilitado
 * - No debe ser clickeable cuando está deshabilitado
 * - Debe mostrar iconos leading y trailing cuando se proporcionan
 * - Debe mostrar CircularProgressIndicator cuando isLoading=true
 * - No debe mostrar contenido cuando isLoading=true
 * - No debe ser clickeable cuando isLoading=true
 */
class BaseButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun baseButton_displaysLabelCorrectly() {
        // Given
        val testLabel = "Click Me"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }

    @Test
    fun baseButton_isClickableWhenEnabled() {
        // Given
        var clicked = false
        val testLabel = "Enabled Button"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                enabled = true,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsEnabled()
            .performClick()

        assert(clicked) { "Button should be clickable when enabled" }
    }

    @Test
    fun baseButton_isNotClickableWhenDisabled() {
        // Given
        var clicked = false
        val testLabel = "Disabled Button"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                enabled = false,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsNotEnabled()

        // Intentar hacer click (no debería ejecutarse)
        composeTestRule
            .onNodeWithText(testLabel)
            .performClick()

        assert(!clicked) { "Button should not be clickable when disabled" }
    }

    @Test
    fun baseButton_displaysLeadingIcon() {
        // Given
        val testLabel = "Button with Leading Icon"
        val leadingIconContentDescription = "Leading Icon"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Add ,
                        contentDescription = leadingIconContentDescription,
                        modifier = Modifier.size(18.dp)
                    )
                },
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(leadingIconContentDescription)
            .assertIsDisplayed()
    }

    @Test
    fun baseButton_displaysTrailingIcon() {
        // Given
        val testLabel = "Button with Trailing Icon"
        val trailingIconContentDescription = "Trailing Icon"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowOutward,
                        contentDescription = trailingIconContentDescription,
                        modifier = Modifier.size(18.dp)
                    )
                },
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(trailingIconContentDescription)
            .assertIsDisplayed()
    }

    @Test
    fun baseButton_displaysBothIcons() {
        // Given
        val testLabel = "Button with Both Icons"
        val leadingIconContentDescription = "Leading Icon"
        val trailingIconContentDescription = "Trailing Icon"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = leadingIconContentDescription,
                        modifier = Modifier.size(18.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowOutward,
                        contentDescription = trailingIconContentDescription,
                        modifier = Modifier.size(18.dp)
                    )
                },
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(leadingIconContentDescription)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithContentDescription(trailingIconContentDescription)
            .assertIsDisplayed()
    }

    @Test
    fun baseButton_showsProgressIndicatorWhenLoading() {
        // Given
        val testLabel = "Loading Button"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                isLoading = true,
                onClick = {}
            )
        }

        // Then - Debe mostrar el CircularProgressIndicator
        composeTestRule
            .onNodeWithTag("loading_indicator")
            .assertIsDisplayed()
    }

    @Test
    fun baseButton_hidesContentWhenLoading() {
        // Given
        val testLabel = "Loading Button"
        val leadingIconContentDescription = "Leading Icon"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                isLoading = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = leadingIconContentDescription,
                        modifier = Modifier.size(18.dp)
                    )
                },
                onClick = {}
            )
        }

        // Then - No debe mostrar el label ni los iconos cuando está loading
        composeTestRule
            .onNodeWithText(testLabel)
            .assertDoesNotExist()
        
        composeTestRule
            .onNodeWithContentDescription(leadingIconContentDescription)
            .assertDoesNotExist()
    }

    @Test
    fun baseButton_isNotClickableWhenLoading() {
        // Given
        var clicked = false
        val testLabel = "Loading Button"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                isLoading = true,
                onClick = { clicked = true }
            )
        }

        // Then - El botón no debe ser clickeable
        composeTestRule
            .onNodeWithTag("loading_indicator")
            .assertIsDisplayed()

        // Intentar hacer click en el botón (no debería ejecutarse el onClick)
        composeTestRule
            .onRoot()
            .performClick()

        assert(!clicked) { "Button should not be clickable when loading" }
    }

    @Test
    fun baseButton_showsContentWhenNotLoading() {
        // Given
        val testLabel = "Normal Button"

        // When
        composeTestRule.setContent {
            BaseButton(
                label = testLabel,
                isLoading = false,
                onClick = {}
            )
        }

        // Then - Debe mostrar el contenido normal
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
        
        // No debe mostrar el loading indicator
        composeTestRule
            .onNodeWithTag("loading_indicator")
            .assertDoesNotExist()
    }
}
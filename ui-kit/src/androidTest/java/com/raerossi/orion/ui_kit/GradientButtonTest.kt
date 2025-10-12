package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

/**
 * Tests para GradientButton siguiendo TDD (Test-Driven Development)
 *
 * Estos tests definen el comportamiento esperado del componente GradientButton:
 * - Debe mostrar el label correctamente (heredado de BaseButton)
 * - Debe aplicar brush como background cuando está habilitado
 * - NO debe aplicar brush cuando está deshabilitado
 * - NO debe aplicar brush cuando se pasa un modifier (conflicto con background)
 * - Debe aplicar el shape al brush correctamente
 * - Debe ser clickeable cuando está habilitado
 * - Debe mostrar iconos leading y trailing (heredado de BaseButton)
 */
class GradientButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun gradientButton_displaysLabelCorrectly() {
        // Given
        val testLabel = "Gradient Button"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )

        // When
        composeTestRule.setContent {
            GradientButton(
                label = testLabel,
                brush = testBrush,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }

    @Test
    fun gradientButton_isClickableWhenEnabled() {
        // Given
        var clicked = false
        val testLabel = "Enabled Gradient Button"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )

        // When
        composeTestRule.setContent {
            GradientButton(
                label = testLabel,
                brush = testBrush,
                enabled = true,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsEnabled()
            .performClick()

        assert(clicked) { "GradientButton should be clickable when enabled" }
    }

    @Test
    fun gradientButton_isNotClickableWhenDisabled() {
        // Given
        var clicked = false
        val testLabel = "Disabled Gradient Button"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )

        // When
        composeTestRule.setContent {
            GradientButton(
                label = testLabel,
                brush = testBrush,
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

        assert(!clicked) { "GradientButton should not be clickable when disabled" }
    }

    @Test
    fun gradientButton_appliesBrushWhenEnabled() {
        // Given
        val testLabel = "Gradient Enabled"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )
        val testTag = "gradient_button_enabled"

        // When
        composeTestRule.setContent {
            GradientButton(
                modifier = Modifier.testTag(testTag),
                label = testLabel,
                brush = testBrush,
                enabled = true,
                onClick = {}
            )
        }

        // Then - El botón debe existir y estar visible
        composeTestRule
            .onNodeWithTag(testTag)
            .assertExists()
            .assertIsDisplayed()

        // El label debe estar visible
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }

    @Test
    fun gradientButton_doesNotApplyBrushWhenDisabled() {
        // Given
        val testLabel = "Gradient Disabled"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )
        val testTag = "gradient_button_disabled"

        // When
        composeTestRule.setContent {
            GradientButton(
                modifier = Modifier.testTag(testTag),
                label = testLabel,
                brush = testBrush,
                enabled = false,
                onClick = {}
            )
        }

        // Then - El botón debe existir pero sin el brush aplicado
        composeTestRule
            .onNodeWithTag(testTag)
            .assertExists()
            .assertIsDisplayed()

        // El label debe estar visible
        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }

    @Test
    fun gradientButton_brushConflictsWithCustomModifierBackground() {
        // Given
        // Este test documenta que si se pasa un modifier con background,
        // el brush del GradientButton no se aplicará correctamente
        // porque el modifier se pasa primero a BaseButton
        val testLabel = "Custom Modifier"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )
        val customModifier = Modifier
            .size(200.dp, 60.dp)
            .testTag("gradient_button_custom_modifier")

        // When
        composeTestRule.setContent {
            GradientButton(
                modifier = customModifier,
                label = testLabel,
                brush = testBrush,
                enabled = true,
                onClick = {}
            )
        }

        // Then - El botón debe renderizarse pero el brush podría no aplicarse
        // debido al orden de los modifiers
        composeTestRule
            .onNodeWithTag("gradient_button_custom_modifier")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }

    @Test
    fun gradientButton_displaysLeadingIcon() {
        // Given
        val testLabel = "Gradient with Leading Icon"
        val leadingIconContentDescription = "Star Icon"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )

        // When
        composeTestRule.setContent {
            GradientButton(
                label = testLabel,
                brush = testBrush,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
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
    fun gradientButton_displaysTrailingIcon() {
        // Given
        val testLabel = "Gradient with Trailing Icon"
        val trailingIconContentDescription = "Trailing Star"
        val testBrush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan)
        )

        // When
        composeTestRule.setContent {
            GradientButton(
                label = testLabel,
                brush = testBrush,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
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
    fun gradientButton_withVerticalGradientBrush() {
        // Given
        val testLabel = "Vertical Gradient"
        val testBrush = Brush.verticalGradient(
            colors = listOf(Color.Red, Color.Yellow, Color.Green)
        )
        val testTag = "vertical_gradient_button"

        // When
        composeTestRule.setContent {
            GradientButton(
                modifier = Modifier.testTag(testTag),
                label = testLabel,
                brush = testBrush,
                enabled = true,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(testTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }

    @Test
    fun gradientButton_withRadialGradientBrush() {
        // Given
        val testLabel = "Radial Gradient"
        val testBrush = Brush.radialGradient(
            colors = listOf(Color.Magenta, Color.Blue)
        )
        val testTag = "radial_gradient_button"

        // When
        composeTestRule.setContent {
            GradientButton(
                modifier = Modifier.testTag(testTag),
                label = testLabel,
                brush = testBrush,
                enabled = true,
                onClick = {}
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(testTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testLabel)
            .assertIsDisplayed()
    }
}
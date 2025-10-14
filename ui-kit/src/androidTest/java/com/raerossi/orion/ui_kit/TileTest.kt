package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

/**
 * Tests unitarios para componente Tile siguiendo TDD (Test-Driven Development)
 * 
 * Estos tests definen el comportamiento esperado del componente Tile:
 * - Debe mostrar el contenido/texto requerido
 * - Debe aceptar y aplicar modifier personalizado
 * - Debe mostrar el leadingIcon cuando se proporciona (opcional)
 * - Debe mostrar el trailingIcon cuando se proporciona (opcional)
 * - Debe funcionar sin iconos (solo contenido)
 * - Debe mostrar ambos iconos cuando se proporcionan
 * - Debe aplicar colores personalizados
 * - Debe ser clickeable cuando se proporciona onClick
 * - No debe ser clickeable cuando está deshabilitado
 */
class TileTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // ==================== Content/Text Tests ====================

    @Test
    fun tile_displaysContentCorrectly() {
        // Given
        val testContent = "Tile Content"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_requiresContent() {
        // Given
        val testContent = "Required Content"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent
            )
        }

        // Then - El contenido debe existir siempre
        composeTestRule
            .onNodeWithText(testContent)
            .assertExists()
    }

    @Test
    fun tile_displaysLongContent() {
        // Given
        val longContent = "This is a very long content text that should be displayed in the Tile component without any issues"

        // When
        composeTestRule.setContent {
            Tile(
                content = longContent
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(longContent)
            .assertIsDisplayed()
    }

    // ==================== Modifier Tests ====================

    @Test
    fun tile_acceptsCustomModifier() {
        // Given
        val testContent = "Tile with Modifier"
        val customTestTag = "custom_tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                modifier = Modifier.testTag(customTestTag)
            )
        }

        // Then - Debe aceptar y aplicar el modifier
        composeTestRule
            .onNodeWithTag(customTestTag)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun tile_appliesDefaultModifier() {
        // Given
        val testContent = "Default Tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertExists()
    }

    // ==================== LeadingIcon Tests ====================

    @Test
    fun tile_displaysLeadingIcon() {
        // Given
        val testContent = "Tile with Leading Icon"
        val leadingIconContentDescription = "Home Icon"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = leadingIconContentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(leadingIconContentDescription)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithoutLeadingIcon() {
        // Given
        val testContent = "Tile without Leading Icon"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                leadingIcon = null
            )
        }

        // Then - Debe funcionar sin leading icon
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    // ==================== TrailingIcon Tests ====================

    @Test
    fun tile_displaysTrailingIcon() {
        // Given
        val testContent = "Tile with Trailing Icon"
        val trailingIconContentDescription = "Settings Icon"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = trailingIconContentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(trailingIconContentDescription)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithoutTrailingIcon() {
        // Given
        val testContent = "Tile without Trailing Icon"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                trailingIcon = null
            )
        }

        // Then - Debe funcionar sin trailing icon
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    // ==================== Both Icons Tests ====================

    @Test
    fun tile_displaysBothIcons() {
        // Given
        val testContent = "Tile with Both Icons"
        val leadingIconContentDescription = "Leading Icon"
        val trailingIconContentDescription = "Trailing Icon"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = leadingIconContentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = trailingIconContentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }

        // Then - Debe mostrar ambos iconos y el contenido
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription(leadingIconContentDescription)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription(trailingIconContentDescription)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithoutAnyIcons() {
        // Given
        val testContent = "Tile without Any Icons"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent
            )
        }

        // Then - Debe funcionar solo con contenido
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    // ==================== Custom Colors Tests ====================

    @Test
    fun tile_appliesCustomBackgroundColor() {
        // Given
        val testContent = "Tile with Custom Background"
        val tileTag = "colored_tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                backgroundColor = Color.Blue,
                modifier = Modifier.testTag(tileTag)
            )
        }

        // Then - Debe existir y mostrar el contenido
        composeTestRule
            .onNodeWithTag(tileTag)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_appliesCustomTextColor() {
        // Given
        val testContent = "Tile with Custom Text Color"
        val tileTag = "text_colored_tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                textColor = Color.Red,
                modifier = Modifier.testTag(tileTag)
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(tileTag)
            .assertExists()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_appliesCustomIconColor() {
        // Given
        val testContent = "Tile with Custom Icon Color"
        val iconDescription = "Colored Icon"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                iconColor = Color.Green,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = iconDescription,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(iconDescription)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_appliesMultipleCustomColors() {
        // Given
        val testContent = "Fully Colored Tile"
        val tileTag = "fully_colored_tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                backgroundColor = Color.Blue,
                textColor = Color.White,
                iconColor = Color.Yellow,
                modifier = Modifier.testTag(tileTag)
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(tileTag)
            .assertExists()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    // ==================== Interaction Tests ====================

    @Test
    fun tile_isClickableWhenOnClickProvided() {
        // Given
        var clicked = false
        val testContent = "Clickable Tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .performClick()

        assert(clicked) { "Tile should be clickable when onClick is provided" }
    }

    @Test
    fun tile_isNotClickableWhenDisabled() {
        // Given
        var clicked = false
        val testContent = "Disabled Tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                enabled = false,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .performClick()

        assert(!clicked) { "Tile should not be clickable when disabled" }
    }

    @Test
    fun tile_isClickableWhenEnabled() {
        // Given
        var clicked = false
        val testContent = "Enabled Tile"

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                enabled = true,
                onClick = { clicked = true }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .performClick()

        assert(clicked) { "Tile should be clickable when enabled" }
    }

    // ==================== Complex Scenarios ====================

    @Test
    fun tile_worksWithAllFeaturesEnabled() {
        // Given
        val testContent = "Complete Tile"
        val leadingIconDescription = "Leading"
        val trailingIconDescription = "Trailing"
        val tileTag = "complete_tile"
        var clicked = false

        // When
        composeTestRule.setContent {
            Tile(
                content = testContent,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = leadingIconDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = trailingIconDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                backgroundColor = Color.LightGray,
                textColor = Color.Black,
                iconColor = Color.DarkGray,
                enabled = true,
                onClick = { clicked = true },
                modifier = Modifier.testTag(tileTag)
            )
        }

        // Then - Verificar que todo funciona junto
        composeTestRule
            .onNodeWithTag(tileTag)
            .assertExists()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription(leadingIconDescription)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription(trailingIconDescription)
            .assertIsDisplayed()

        // Verificar interacción
        composeTestRule
            .onNodeWithText(testContent)
            .performClick()

        assert(clicked) { "Complete tile should be clickable" }
    }

    @Test
    fun tile_maintainsContentWithDifferentStates() {
        // Given
        val testContent = "State Tile"

        // When - Disabled state
        composeTestRule.setContent {
            Tile(
                content = testContent,
                enabled = false
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()

        // When - Enabled state
        composeTestRule.setContent {
            Tile(
                content = testContent,
                enabled = true
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_handlesEmptyStringContent() {
        // Given
        val emptyContent = ""

        // When
        composeTestRule.setContent {
            Tile(
                content = emptyContent
            )
        }

        // Then - Debe manejar contenido vacío
        composeTestRule
            .onRoot()
            .assertExists()
    }

    @Test
    fun tile_handlesSpecialCharactersInContent() {
        // Given
        val specialContent = "Tile with special characters: @#$%^&*()"

        // When
        composeTestRule.setContent {
            Tile(
                content = specialContent
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(specialContent)
            .assertIsDisplayed()
    }
}

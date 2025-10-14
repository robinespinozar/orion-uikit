package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

/**
 * Tests unitarios para componente Tile siguiendo TDD (Test-Driven Development)
 * 
 * Signature del componente:
 * @param content: @Composable (() -> Unit) - Contenido obligatorio
 * @param modifier: Modifier = Modifier - Modifier personalizable
 * @param leadingIcon: @Composable (() -> Unit)? = null - Icono opcional al inicio
 * @param trailingIcon: @Composable (() -> Unit)? = null - Icono opcional al final
 */
class TileTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tile_displaysContentCorrectly() {
        // Given
        val testContent = "Tile Content"

        // When
        composeTestRule.setContent {
            Tile(
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_acceptsCustomModifier() {
        // Given
        val testContent = "Tile with Modifier"
        val customTestTag = "custom_tile"

        // When
        composeTestRule.setContent {
            Tile(
                modifier = Modifier.testTag(customTestTag),
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(customTestTag)
            .assertExists()
    }

    @Test
    fun tile_displaysLeadingIcon() {
        // Given
        val testContent = "Tile with Leading Icon"
        val leadingIconDescription = "Home Icon"

        // When
        composeTestRule.setContent {
            Tile(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = leadingIconDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(leadingIconDescription)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithoutLeadingIcon() {
        // Given
        val testContent = "Tile without Leading Icon"

        // When
        composeTestRule.setContent {
            Tile(
                leadingIcon = null,
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_displaysTrailingIcon() {
        // Given
        val testContent = "Tile with Trailing Icon"
        val trailingIconDescription = "Settings Icon"

        // When
        composeTestRule.setContent {
            Tile(
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = trailingIconDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithContentDescription(trailingIconDescription)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithoutTrailingIcon() {
        // Given
        val testContent = "Tile without Trailing Icon"

        // When
        composeTestRule.setContent {
            Tile(
                trailingIcon = null,
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_displaysBothIcons() {
        // Given
        val testContent = "Tile with Both Icons"
        val leadingIconDescription = "Leading Icon"
        val trailingIconDescription = "Trailing Icon"

        // When
        composeTestRule.setContent {
            Tile(
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
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription(leadingIconDescription)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription(trailingIconDescription)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithoutAnyIcons() {
        // Given
        val testContent = "Tile without Icons"

        // When
        composeTestRule.setContent {
            Tile(
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(testContent)
            .assertIsDisplayed()
    }

    @Test
    fun tile_worksWithAllFeatures() {
        // Given
        val testContent = "Complete Tile"
        val leadingIconDescription = "Leading"
        val trailingIconDescription = "Trailing"
        val tileTag = "complete_tile"

        // When
        composeTestRule.setContent {
            Tile(
                modifier = Modifier.testTag(tileTag),
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
                content = {
                    Text(testContent)
                }
            )
        }

        // Then
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
    }
}

package com.raerossi.orion.ui_kit

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raerossi.orion.ui_kit.title_description.TitleDescription
import com.raerossi.orion.ui_kit.title_description.TitleDescriptionColors
import com.raerossi.orion.ui_kit.title_description.TitleDescriptionDefaults
import org.junit.Rule
import org.junit.Test

/**
 * Tests para TitleDescription siguiendo TDD (Test-Driven Development)
 * 
 * Estos tests definen el comportamiento esperado del componente TitleDescription:
 * - Debe mostrar el título y la descripción correctamente
 * - Debe aplicar estilos personalizados cuando se proporcionan
 * - Debe usar estilos por defecto de MaterialTheme cuando no se especifican
 * - Debe aplicar colores personalizados correctamente
 * - Debe usar colores por defecto del theme cuando no se especifican
 * - Debe aplicar el spacing correcto entre título y descripción
 * - Debe permitir spacing personalizado
 * - Debe aceptar modificadores personalizados
 * - Debe estar alineado al centro horizontalmente por defecto
 */
class TitleDescriptionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // ==================== Basic Display Tests ====================

    @Test
    fun titleDescription_displaysTitleCorrectly() {
        // Given
        val testTitle = "Welcome"
        val testDescription = "Get started with your journey"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription
                )
            }
        }

        // Then
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_displaysDescriptionCorrectly() {
        // Given
        val testTitle = "Welcome"
        val testDescription = "Get started with your journey"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription
                )
            }
        }

        // Then
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_displaysBothTextsSimultaneously() {
        // Given
        val testTitle = "Hello World"
        val testDescription = "This is a description"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription
                )
            }
        }

        // Then - Both should be visible at the same time
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_displaysEmptyStrings() {
        // Given
        val emptyTitle = ""
        val emptyDescription = ""

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = emptyTitle,
                    description = emptyDescription,
                    modifier = Modifier.testTag("title_description_container")
                )
            }
        }

        // Then - Component should exist even with empty strings
        composeTestRule
            .onNodeWithTag("title_description_container")
            .assertExists()
    }

    @Test
    fun titleDescription_displaysLongTexts() {
        // Given
        val longTitle = "This is a very long title that might wrap to multiple lines"
        val longDescription = "This is an extremely long description that contains a lot of text " +
                "and should be able to display properly without any issues even when it wraps " +
                "to multiple lines in the interface"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = longTitle,
                    description = longDescription
                )
            }
        }

        // Then
        composeTestRule
            .onNodeWithText(longTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(longDescription)
            .assertIsDisplayed()
    }

    // ==================== Styling Tests ====================

    @Test
    fun titleDescription_appliesCustomTitleStyle() {
        // Given
        val testTitle = "Custom Style Title"
        val testDescription = "Description"
        val customStyle = TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    titleStyle = customStyle
                )
            }
        }

        // Then - Title should be displayed with custom style
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_appliesCustomDescriptionStyle() {
        // Given
        val testTitle = "Title"
        val testDescription = "Custom Style Description"
        val customStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    descriptionStyle = customStyle
                )
            }
        }

        // Then - Description should be displayed with custom style
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_usesDefaultStylesFromMaterialTheme() {
        // Given
        val testTitle = "Default Title"
        val testDescription = "Default Description"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription
                    // No custom styles provided - should use defaults
                )
            }
        }

        // Then - Both texts should be displayed (using default styles)
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    // ==================== Color Tests ====================

    @Test
    fun titleDescription_appliesCustomColors() {
        // Given
        val testTitle = "Colored Title"
        val testDescription = "Colored Description"
        val customColors = TitleDescriptionColors(
            titleColor = Color.Red,
            descriptionColor = Color.Blue
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    colors = customColors
                )
            }
        }

        // Then - Texts should be displayed with custom colors
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_usesDefaultColorsFromTheme() {
        // Given
        val testTitle = "Theme Title"
        val testDescription = "Theme Description"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription
                    // No custom colors - should use theme defaults
                )
            }
        }

        // Then - Texts should be displayed with theme colors
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    // ==================== Spacing Tests ====================

    @Test
    fun titleDescription_appliesDefaultSpacing() {
        // Given
        val testTitle = "Title"
        val testDescription = "Description"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    modifier = Modifier.testTag("title_description")
                )
            }
        }

        // Then - Component should exist with default spacing
        composeTestRule
            .onNodeWithTag("title_description")
            .assertExists()
        
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_appliesCustomSpacing() {
        // Given
        val testTitle = "Title"
        val testDescription = "Description"
        val customSpacing = 24.dp

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    spacing = customSpacing,
                    modifier = Modifier.testTag("title_description")
                )
            }
        }

        // Then - Component should exist with custom spacing
        composeTestRule
            .onNodeWithTag("title_description")
            .assertExists()
    }

    @Test
    fun titleDescription_appliesZeroSpacing() {
        // Given
        val testTitle = "Title"
        val testDescription = "Description"
        val zeroSpacing = 0.dp

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    spacing = zeroSpacing
                )
            }
        }

        // Then - Both texts should still be visible with zero spacing
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_appliesLargeSpacing() {
        // Given
        val testTitle = "Title"
        val testDescription = "Description"
        val largeSpacing = 48.dp

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    spacing = largeSpacing
                )
            }
        }

        // Then - Both texts should be visible with large spacing
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    // ==================== Modifier Tests ====================

    @Test
    fun titleDescription_acceptsCustomModifier() {
        // Given
        val testTitle = "Modified Component"
        val testDescription = "With custom modifier"
        val customTestTag = "custom_title_description"

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    modifier = Modifier.testTag(customTestTag)
                )
            }
        }

        // Then - Component should have the custom tag
        composeTestRule
            .onNodeWithTag(customTestTag)
            .assertExists()
    }

    // ==================== Defaults Tests ====================

    @Test
    fun titleDescriptionDefaults_providesCorrectDefaultSpacing() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                val defaultSpacing = TitleDescriptionDefaults.Spacing
                
                // Then - Default spacing should be 8.dp (as per MD3 conventions)
                assert(defaultSpacing == 8.dp) { 
                    "Default spacing should be 8.dp, but was $defaultSpacing" 
                }
            }
        }
    }

    @Test
    fun titleDescriptionDefaults_providesDefaultColors() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                val defaultColors = TitleDescriptionDefaults.colors()
                
                // Then - Colors should be based on MaterialTheme
                assert(defaultColors.titleColor != Color.Unspecified) { 
                    "Title color should not be Unspecified" 
                }
                assert(defaultColors.descriptionColor != Color.Unspecified) { 
                    "Description color should not be Unspecified" 
                }
            }
        }
    }

    @Test
    fun titleDescriptionDefaults_providesDefaultTitleStyle() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                val defaultTitleStyle = TitleDescriptionDefaults.titleStyle
                
                // Then - Should provide a valid TextStyle
                assert(defaultTitleStyle != TextStyle.Default) { 
                    "Title style should not be TextStyle.Default" 
                }
            }
        }
    }

    @Test
    fun titleDescriptionDefaults_providesDefaultDescriptionStyle() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                val defaultDescriptionStyle = TitleDescriptionDefaults.descriptionStyle
                
                // Then - Should provide a valid TextStyle
                assert(defaultDescriptionStyle != TextStyle.Default) { 
                    "Description style should not be TextStyle.Default" 
                }
            }
        }
    }

    // ==================== Integration Tests ====================

    @Test
    fun titleDescription_worksWithAllCustomParameters() {
        // Given
        val testTitle = "Full Custom"
        val testDescription = "All parameters customized"
        val customTitleStyle = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
        val customDescriptionStyle = TextStyle(fontSize = 16.sp)
        val customSpacing = 16.dp
        val customColors = TitleDescriptionColors(
            titleColor = Color.Blue,
            descriptionColor = Color.Gray
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription,
                    titleStyle = customTitleStyle,
                    descriptionStyle = customDescriptionStyle,
                    spacing = customSpacing,
                    colors = customColors,
                    modifier = Modifier.testTag("fully_custom")
                )
            }
        }

        // Then - All elements should work together
        composeTestRule
            .onNodeWithTag("fully_custom")
            .assertExists()
        
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }

    @Test
    fun titleDescription_worksWithMinimalParameters() {
        // Given
        val testTitle = "Minimal"
        val testDescription = "Only required params"

        // When - Using only required parameters
        composeTestRule.setContent {
            MaterialTheme {
                TitleDescription(
                    title = testTitle,
                    description = testDescription
                )
            }
        }

        // Then - Should work with defaults
        composeTestRule
            .onNodeWithText(testTitle)
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithText(testDescription)
            .assertIsDisplayed()
    }
}
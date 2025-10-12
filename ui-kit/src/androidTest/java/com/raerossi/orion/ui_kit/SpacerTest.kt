package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

/**
 * Tests unitarios CORREGIDOS para componentes Spacer
 * 
 * Estos tests ahora SÍ verifican el comportamiento real:
 * - VerticalSpacer: Verifica que aplica la altura correcta usando assertHeightIsEqualTo
 * - HorizontalSpacer: Verifica que aplica el ancho correcto usando assertWidthIsEqualTo
 * - Tests de integración: Verifican que separan componentes correctamente
 */
class SpacerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // ==================== VerticalSpacer Tests ====================

    @Test
    fun verticalSpacer_appliesCorrectHeight_8dp() {
        // Given
        val expectedHeight = 8

        // When
        composeTestRule.setContent {
            VerticalSpacer(height = expectedHeight)
        }

        // Then - Verificar que tiene la altura correcta
        composeTestRule
            .onNodeWithTag("vertical_spacer_$expectedHeight")
            .assertExists()
            .assertHeightIsEqualTo(expectedHeight.dp)
    }

    @Test
    fun verticalSpacer_appliesCorrectHeight_16dp() {
        // Given
        val expectedHeight = 16

        // When
        composeTestRule.setContent {
            VerticalSpacer(height = expectedHeight)
        }

        // Then - Verificar que tiene la altura correcta
        composeTestRule
            .onNodeWithTag("vertical_spacer_$expectedHeight")
            .assertExists()
            .assertHeightIsEqualTo(expectedHeight.dp)
    }

    @Test
    fun verticalSpacer_appliesCorrectHeight_24dp() {
        // Given
        val expectedHeight = 24

        // When
        composeTestRule.setContent {
            VerticalSpacer(height = expectedHeight)
        }

        // Then - Verificar que tiene la altura correcta
        composeTestRule
            .onNodeWithTag("vertical_spacer_$expectedHeight")
            .assertExists()
            .assertHeightIsEqualTo(expectedHeight.dp)
    }

    @Test
    fun verticalSpacer_appliesCorrectHeight_32dp() {
        // Given
        val expectedHeight = 32

        // When
        composeTestRule.setContent {
            VerticalSpacer(height = expectedHeight)
        }

        // Then - Verificar que tiene la altura correcta
        composeTestRule
            .onNodeWithTag("vertical_spacer_$expectedHeight")
            .assertExists()
            .assertHeightIsEqualTo(expectedHeight.dp)
    }

    @Test
    fun verticalSpacer_appliesZeroHeight() {
        // Given
        val expectedHeight = 0

        // When
        composeTestRule.setContent {
            VerticalSpacer(height = expectedHeight)
        }

        // Then - Verificar que tiene altura 0
        composeTestRule
            .onNodeWithTag("vertical_spacer_$expectedHeight")
            .assertExists()
            .assertHeightIsEqualTo(expectedHeight.dp)
    }

    @Test
    fun verticalSpacer_appliesLargeHeight() {
        // Given
        val expectedHeight = 100

        // When
        composeTestRule.setContent {
            VerticalSpacer(height = expectedHeight)
        }

        // Then - Verificar que tiene la altura correcta
        composeTestRule
            .onNodeWithTag("vertical_spacer_$expectedHeight")
            .assertExists()
            .assertHeightIsEqualTo(expectedHeight.dp)
    }

    // ==================== HorizontalSpacer Tests ====================

    @Test
    fun horizontalSpacer_appliesCorrectWidth_8dp() {
        // Given
        val expectedWidth = 8

        // When
        composeTestRule.setContent {
            HorizontalSpacer(width = expectedWidth)
        }

        // Then - Verificar que tiene el ancho correcto
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$expectedWidth")
            .assertExists()
            .assertWidthIsEqualTo(expectedWidth.dp)
    }

    @Test
    fun horizontalSpacer_appliesCorrectWidth_16dp() {
        // Given
        val expectedWidth = 16

        // When
        composeTestRule.setContent {
            HorizontalSpacer(width = expectedWidth)
        }

        // Then - Verificar que tiene el ancho correcto
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$expectedWidth")
            .assertExists()
            .assertWidthIsEqualTo(expectedWidth.dp)
    }

    @Test
    fun horizontalSpacer_appliesCorrectWidth_24dp() {
        // Given
        val expectedWidth = 24

        // When
        composeTestRule.setContent {
            HorizontalSpacer(width = expectedWidth)
        }

        // Then - Verificar que tiene el ancho correcto
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$expectedWidth")
            .assertExists()
            .assertWidthIsEqualTo(expectedWidth.dp)
    }

    @Test
    fun horizontalSpacer_appliesCorrectWidth_32dp() {
        // Given
        val expectedWidth = 32

        // When
        composeTestRule.setContent {
            HorizontalSpacer(width = expectedWidth)
        }

        // Then - Verificar que tiene el ancho correcto
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$expectedWidth")
            .assertExists()
            .assertWidthIsEqualTo(expectedWidth.dp)
    }

    @Test
    fun horizontalSpacer_appliesZeroWidth() {
        // Given
        val expectedWidth = 0

        // When
        composeTestRule.setContent {
            HorizontalSpacer(width = expectedWidth)
        }

        // Then - Verificar que tiene ancho 0
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$expectedWidth")
            .assertExists()
            .assertWidthIsEqualTo(expectedWidth.dp)
    }

    @Test
    fun horizontalSpacer_appliesLargeWidth() {
        // Given
        val expectedWidth = 100

        // When
        composeTestRule.setContent {
            HorizontalSpacer(width = expectedWidth)
        }

        // Then - Verificar que tiene el ancho correcto
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$expectedWidth")
            .assertExists()
            .assertWidthIsEqualTo(expectedWidth.dp)
    }

    // ==================== Integration Tests ====================

    @Test
    fun verticalSpacer_separatesComponentsInColumn() {
        // Given
        val spacerHeight = 16

        // When
        composeTestRule.setContent {
            Column {
                Text("Top", modifier = Modifier.testTag("top_text"))
                VerticalSpacer(height = spacerHeight)
                Text("Bottom", modifier = Modifier.testTag("bottom_text"))
            }
        }

        // Then - El spacer debe existir y tener la altura correcta
        composeTestRule
            .onNodeWithTag("vertical_spacer_$spacerHeight")
            .assertExists()
            .assertHeightIsEqualTo(spacerHeight.dp)

        // Los textos deben existir
        composeTestRule.onNodeWithTag("top_text").assertExists()
        composeTestRule.onNodeWithTag("bottom_text").assertExists()
    }

    @Test
    fun horizontalSpacer_separatesComponentsInRow() {
        // Given
        val spacerWidth = 16

        // When
        composeTestRule.setContent {
            Row {
                Text("Left", modifier = Modifier.testTag("left_text"))
                HorizontalSpacer(width = spacerWidth)
                Text("Right", modifier = Modifier.testTag("right_text"))
            }
        }

        // Then - El spacer debe existir y tener el ancho correcto
        composeTestRule
            .onNodeWithTag("horizontal_spacer_$spacerWidth")
            .assertExists()
            .assertWidthIsEqualTo(spacerWidth.dp)

        // Los textos deben existir
        composeTestRule.onNodeWithTag("left_text").assertExists()
        composeTestRule.onNodeWithTag("right_text").assertExists()
    }

    @Test
    fun multipleSpacers_workInSameLayout() {
        // Given
        val verticalHeight = 8
        val horizontalWidth = 16

        // When
        composeTestRule.setContent {
            Column {
                VerticalSpacer(height = verticalHeight)
                Row {
                    HorizontalSpacer(width = horizontalWidth)
                    Text("Content")
                }
            }
        }

        // Then - Ambos spacers deben existir con sus dimensiones correctas
        composeTestRule
            .onNodeWithTag("vertical_spacer_$verticalHeight")
            .assertExists()
            .assertHeightIsEqualTo(verticalHeight.dp)

        composeTestRule
            .onNodeWithTag("horizontal_spacer_$horizontalWidth")
            .assertExists()
            .assertWidthIsEqualTo(horizontalWidth.dp)
    }

    @Test
    fun spacer_acceptsCustomModifier() {
        // Given
        val height = 16
        val customTestTag = "custom_spacer"

        // When
        composeTestRule.setContent {
            VerticalSpacer(
                height = height,
                modifier = Modifier.testTag(customTestTag)
            )
        }

        // Then - Debe tener el tag personalizado y la altura correcta
        composeTestRule
            .onNodeWithTag(customTestTag)
            .assertExists()
            .assertHeightIsEqualTo(height.dp)
    }
}
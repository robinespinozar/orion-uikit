package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

/**
 * VerticalSpacer - Crea un espacio vertical de altura específica
 *
 * @param height Altura del spacer en dp
 * @param modifier Modificador opcional para personalización y testing
 */
@Composable
fun VerticalSpacer(
    height: Int,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .height(height.dp)
            .testTag("vertical_spacer_$height")
    )
}

/**
 * HorizontalSpacer - Crea un espacio horizontal de ancho específico
 *
 * @param width Ancho del spacer en dp
 * @param modifier Modificador opcional para personalización y testing
 */
@Composable
fun HorizontalSpacer(
    width: Int,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .width(width.dp)
            .testTag("horizontal_spacer_$width")
    )
}
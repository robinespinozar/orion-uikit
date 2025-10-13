package com.raerossi.orion.ui_kit.buttons.gradient_button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton

object GradientButtonDefaults {

    private val ButtonLeadingSpace = 24.dp
    private val ButtonTrailingSpace = 24.dp
    private val ButtonWithIconStartPadding = 16.dp
    private val ButtonWithIconEndPadding = 16.dp
    private val ButtonVerticalPadding = 8.dp

    @Composable
    fun colors(
        brushContainerColor: Brush = Brush.verticalGradient(
            listOf(Color(0xFF4285F4), Color(0xFF1967D2))
        ),
        contentColor: Color = ButtonDefaults.buttonColors().copy().contentColor,
        disabledContainerColor: Color = ButtonDefaults.buttonColors().copy().disabledContainerColor,
        disabledContentColor: Color = ButtonDefaults.buttonColors().copy().disabledContentColor
    ): GradientButtonColors = GradientButtonColors(
        brushContainerColor = brushContainerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    val shape: Shape
        @Composable get() = ButtonDefaults.shape

    val elevation: ButtonElevation?
        @Composable get() = ButtonDefaults.buttonElevation()

    val iconSpacing: Dp
        @Composable get() = ButtonDefaults.IconSpacing

    /** The default content padding used by [BaseButton] that no contains an [androidx.compose.material3.Icon]. */
    val ContentPadding = PaddingValues(
        start = ButtonLeadingSpace,
        top = ButtonVerticalPadding,
        end = ButtonTrailingSpace,
        bottom = ButtonVerticalPadding,
    )

    /** The default content padding used by [BaseButton] that contains an Start/Lead [androidx.compose.material3.Icon]. */
    val StartIconContentPadding = PaddingValues(
        start = ButtonWithIconStartPadding,
        top = ButtonVerticalPadding,
        end = ButtonTrailingSpace,
        bottom = ButtonVerticalPadding,
    )

    /** The default content padding used by [BaseButton] that contains an End/Trail [androidx.compose.material3.Icon]. */
    val EndIconContentPadding = PaddingValues(
        start = ButtonLeadingSpace,
        top = ButtonVerticalPadding,
        end = ButtonWithIconEndPadding,
        bottom = ButtonVerticalPadding,
    )
}
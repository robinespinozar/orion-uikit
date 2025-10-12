package com.raerossi.orion.ui_kit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object BaseButtonDefaults {

    private val ButtonLeadingSpace = 24.dp
    private val ButtonTrailingSpace = 24.dp
    private val ButtonWithIconStartPadding = 16.dp
    private val ButtonWithIconEndPadding = 16.dp
    private val ButtonVerticalPadding = 8.dp

    val shape: Shape
        @Composable get() = ButtonDefaults.shape

    val colors: ButtonColors
        @Composable get() = ButtonDefaults.buttonColors()

    val elevation: ButtonElevation?
        @Composable get() = ButtonDefaults.buttonElevation()

    val iconSpacing: Dp
        @Composable get() = ButtonDefaults.IconSpacing

    /** The default content padding used by [BaseButton] that no contains an [Icon]. */
    val ContentPadding = PaddingValues(
        start = ButtonLeadingSpace,
        top = ButtonVerticalPadding,
        end = ButtonTrailingSpace,
        bottom = ButtonVerticalPadding,
    )

    /** The default content padding used by [BaseButton] that contains an Start/Lead [Icon]. */
    val StartIconContentPadding = PaddingValues(
        start = ButtonWithIconStartPadding,
        top = ButtonVerticalPadding,
        end = ButtonTrailingSpace,
        bottom = ButtonVerticalPadding,
    )

    /** The default content padding used by [BaseButton] that contains an End/Trail [Icon]. */
    val EndIconContentPadding = PaddingValues(
        start = ButtonLeadingSpace,
        top = ButtonVerticalPadding,
        end = ButtonWithIconEndPadding,
        bottom = ButtonVerticalPadding,
    )
}
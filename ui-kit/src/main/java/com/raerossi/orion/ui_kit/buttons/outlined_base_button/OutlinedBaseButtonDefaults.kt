package com.raerossi.orion.ui_kit.buttons.outlined_base_button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton

object OutlinedBaseButtonDefaults {

    private val ButtonLeadingSpace = 24.dp
    private val ButtonTrailingSpace = 24.dp
    private val ButtonWithIconStartPadding = 16.dp
    private val ButtonWithIconEndPadding = 16.dp
    private val ButtonVerticalPadding = 8.dp

    val shape: Shape
        @Composable get() = ButtonDefaults.outlinedShape

    val colors: ButtonColors
        @Composable get() = ButtonDefaults.outlinedButtonColors()

    val iconSpacing: Dp
        @Composable get() = ButtonDefaults.IconSpacing

    @Composable
    fun border(enabled: Boolean): BorderStroke? = ButtonDefaults.outlinedButtonBorder(enabled)

    /** The default content padding used by [OutlinedBaseButton] that no contains an [androidx.compose.material3.Icon]. */
    val ContentPadding = PaddingValues(
        start = ButtonLeadingSpace,
        top = ButtonVerticalPadding,
        end = ButtonTrailingSpace,
        bottom = ButtonVerticalPadding,
    )

    /** The default content padding used by [OutlinedBaseButton] that contains an Start/Lead [androidx.compose.material3.Icon]. */
    val StartIconContentPadding = PaddingValues(
        start = ButtonWithIconStartPadding,
        top = ButtonVerticalPadding,
        end = ButtonTrailingSpace,
        bottom = ButtonVerticalPadding,
    )

    /** The default content padding used by [OutlinedBaseButton] that contains an End/Trail [androidx.compose.material3.Icon]. */
    val EndIconContentPadding = PaddingValues(
        start = ButtonLeadingSpace,
        top = ButtonVerticalPadding,
        end = ButtonWithIconEndPadding,
        bottom = ButtonVerticalPadding,
    )
}
package com.raerossi.orion.ui_kit.buttons.text_base_button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton

object TextBaseButtonDefaults {

    private val HorizontalPadding = 12.dp
    private val WithIconHorizontalEndPadding = 16.dp

    val shape: Shape
        @Composable get() = ButtonDefaults.textShape

    val colors: ButtonColors
        @Composable get() = ButtonDefaults.textButtonColors()

    val iconSpacing: Dp
        @Composable get() = ButtonDefaults.IconSpacing

    /** The default content padding used by [TextBaseButton] that no contains an [androidx.compose.material3.Icon]. */
    val ContentPadding = PaddingValues(
        start = HorizontalPadding,
        top = ButtonDefaults.ContentPadding.calculateTopPadding(),
        end = HorizontalPadding,
        bottom = ButtonDefaults.ContentPadding.calculateBottomPadding(),
    )

    /** The default content padding used by [TextBaseButton] that contains an Start/Lead [androidx.compose.material3.Icon]. */
    val StartIconContentPadding = PaddingValues(
        start = HorizontalPadding,
        top = ButtonDefaults.ContentPadding.calculateTopPadding(),
        end = WithIconHorizontalEndPadding,
        bottom = ButtonDefaults.ContentPadding.calculateBottomPadding(),
    )

    /** The default content padding used by [TextBaseButton] that contains an End/Trail [androidx.compose.material3.Icon]. */
    val EndIconContentPadding = PaddingValues(
        start = WithIconHorizontalEndPadding,
        top = ButtonDefaults.ContentPadding.calculateTopPadding(),
        end = HorizontalPadding,
        bottom = ButtonDefaults.ContentPadding.calculateBottomPadding(),
    )
}
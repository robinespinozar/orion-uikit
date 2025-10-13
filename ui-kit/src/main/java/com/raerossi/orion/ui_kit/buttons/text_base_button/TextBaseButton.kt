package com.raerossi.orion.ui_kit.buttons.text_base_button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton
import com.raerossi.orion.ui_kit.buttons.outlined_base_button.OutlinedBaseButtonDefaults

@Composable
fun TextBaseButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: TextStyle = LocalTextStyle.current,
    shape: Shape = TextBaseButtonDefaults.shape,
    colors: ButtonColors = TextBaseButtonDefaults.colors,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = TextBaseButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    leadIconSpacing: Dp = TextBaseButtonDefaults.iconSpacing,
    trailingIcon: @Composable (() -> Unit)? = null,
    trailIconSpacing: Dp = TextBaseButtonDefaults.iconSpacing,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = modifier,
        label = label,
        enabled = enabled,
        isLoading = isLoading,
        style = style,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        leadingIcon = leadingIcon,
        leadIconSpacing = leadIconSpacing,
        trailingIcon = trailingIcon,
        trailIconSpacing = trailIconSpacing,
        onClick = onClick
    )
}

@Preview
@Composable
private fun TextBaseButtonPreview() {
    TextBaseButton(
        label = "Text Button",
        onClick = {}
    )
}
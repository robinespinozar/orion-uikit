package com.raerossi.orion.ui_kit.buttons.outlined_base_button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton

@Composable
fun OutlinedBaseButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: TextStyle = LocalTextStyle.current,
    shape: Shape = OutlinedBaseButtonDefaults.shape,
    colors: ButtonColors = OutlinedBaseButtonDefaults.colors,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = OutlinedBaseButtonDefaults.border(enabled && !isLoading),
    contentPadding: PaddingValues = OutlinedBaseButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    leadIconSpacing: Dp = OutlinedBaseButtonDefaults.iconSpacing,
    trailingIcon: @Composable (() -> Unit)? = null,
    trailIconSpacing: Dp = OutlinedBaseButtonDefaults.iconSpacing,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = modifier,
        label = label,
        enabled = enabled && !isLoading,
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
private fun OutlinedBaseButtonPreview() { //@nnieves15
    OutlinedBaseButton(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp),
        label = "Outlined Button",
        onClick = {}
    )
}
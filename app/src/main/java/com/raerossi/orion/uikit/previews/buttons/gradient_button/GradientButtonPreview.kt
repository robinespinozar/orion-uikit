package com.raerossi.orion.uikit.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.spacers.HorizontalSpacer
import com.raerossi.orion.ui_kit.spacers.VerticalSpacer
import com.raerossi.orion.ui_kit.buttons.gradient_button.GradientButton
import com.raerossi.orion.ui_kit.buttons.gradient_button.GradientButtonDefaults
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@PreviewLightDark
@Composable
private fun GradientButtonPreview() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            GradientButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                colors = GradientButtonDefaults.colors().copy(
                    brushContainerColor = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
                            MaterialTheme.colorScheme.inversePrimary
                        )
                    )
                ),
                style = MaterialTheme.typography.labelLarge,
                label = "Enabled Gradient Button",
                onClick = {}
            )
            VerticalSpacer(16)
            GradientButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                enabled = false,
                colors = GradientButtonDefaults.colors().copy(
                    brushContainerColor = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.inversePrimary
                        )
                    )
                ),
                style = MaterialTheme.typography.labelLarge,
                label = "Disabled Gradient Button",
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun GradientButtonPreview2() {
    OrionUiKitTheme {
        Row(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
            GradientButton(
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f),
                colors = GradientButtonDefaults.colors().copy(
                    brushContainerColor = Brush.verticalGradient(
                        colors = listOf(Color(0xFF6915B3), Color(0xFFA814E7))
                    )
                ),
                style = MaterialTheme.typography.labelLarge,
                label = "Vertical Gradient",
                onClick = {}
            )
            HorizontalSpacer(16)
            GradientButton(
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f),
                colors = GradientButtonDefaults.colors().copy(
                    brushContainerColor = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF2FD59B), Color(0xFF048E7D))
                    )
                ),
                style = MaterialTheme.typography.labelLarge,
                label = "Horizontal Gradient",
                onClick = {}
            )
        }
    }
}

@Preview(widthDp = 400)
@Composable
private fun GradientButtonPreview3() {
    OrionUiKitTheme {
        Row(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
            GradientButton(
                modifier = Modifier
                    .height(40.dp),
                style = MaterialTheme.typography.labelLarge,
                label = "Button",
                contentPadding = GradientButtonDefaults.ContentPadding,
                onClick = {}
            )
            HorizontalSpacer(16)
            GradientButton(
                modifier = Modifier
                    .height(40.dp),
                style = MaterialTheme.typography.labelLarge,
                label = "Button",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null
                    )
                },
                contentPadding = GradientButtonDefaults.StartIconContentPadding,
                onClick = {}
            )
            HorizontalSpacer(16)
            GradientButton(
                modifier = Modifier
                    .height(40.dp),
                style = MaterialTheme.typography.labelLarge,
                label = "Button",
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null
                    )
                },
                contentPadding = GradientButtonDefaults.EndIconContentPadding,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun GradientButtonPreview4() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            GradientButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                isLoading = true,
                colors = GradientButtonDefaults.colors().copy(
                    brushContainerColor = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
                            MaterialTheme.colorScheme.inversePrimary
                        )
                    )
                ),
                style = MaterialTheme.typography.labelLarge,
                label = "Loading Gradient Button",
                onClick = {}
            )
        }
    }
}
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.HorizontalSpacer
import com.raerossi.orion.ui_kit.VerticalSpacer
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButtonDefaults
import com.raerossi.orion.ui_kit.buttons.outlined_base_button.OutlinedBaseButton
import com.raerossi.orion.ui_kit.buttons.outlined_base_button.OutlinedBaseButtonDefaults
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@PreviewLightDark
@Composable
private fun OutlinedBaseButtonPreview() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            OutlinedBaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Enabled Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                onClick = { /*TODO*/ }
            )
            VerticalSpacer(16)
            OutlinedBaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Disabled Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = false,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview
@Composable
private fun OutlinedBaseButtonPreview2() {
    OrionUiKitTheme {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            OutlinedBaseButton(
                modifier = Modifier
                    .height(40.dp),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = OutlinedBaseButtonDefaults.ContentPadding,
                onClick = { /*TODO*/ }
            )
            HorizontalSpacer(16)
            OutlinedBaseButton(
                modifier = Modifier
                    .height(40.dp),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = OutlinedBaseButtonDefaults.StartIconContentPadding,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null
                    )
                },
                onClick = { /*TODO*/ }
            )
            HorizontalSpacer(16)
            OutlinedBaseButton(
                modifier = Modifier
                    .height(40.dp),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = OutlinedBaseButtonDefaults.EndIconContentPadding,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null
                    )
                },
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview
@Composable
private fun OutlinedBaseButtonPreview3() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            OutlinedBaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Label",
                isLoading = true,
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = OutlinedBaseButtonDefaults.ContentPadding,
                onClick = { /*TODO*/ }
            )
        }
    }
}
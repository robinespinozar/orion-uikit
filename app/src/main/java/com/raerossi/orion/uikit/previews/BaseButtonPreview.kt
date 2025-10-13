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
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButtonDefaults
import com.raerossi.orion.ui_kit.HorizontalSpacer
import com.raerossi.orion.ui_kit.VerticalSpacer
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@PreviewLightDark
@Composable
private fun BaseButtonPreview() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                onClick = { /*TODO*/ }
            )
            VerticalSpacer(16)
            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Label disabled",
                style = MaterialTheme.typography.labelLarge,
                enabled = false,
                onClick = { /*TODO*/ }
            )
            VerticalSpacer(16)
            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Label with lead icon",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.LocationOn,
                        contentDescription = null
                    )
                },
                onClick = { /*TODO*/ }
            )
            VerticalSpacer(16)
            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Label with trail icon",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
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
private fun BaseButtonPreview2() {
    OrionUiKitTheme {
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            BaseButton(
                modifier = Modifier
                    .height(40.dp),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = BaseButtonDefaults.ContentPadding,
                onClick = { /*TODO*/ }
            )
            HorizontalSpacer(16)
            BaseButton(
                modifier = Modifier
                    .height(40.dp),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = BaseButtonDefaults.StartIconContentPadding,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null
                    )
                },
                onClick = { /*TODO*/ }
            )
            HorizontalSpacer(16)
            BaseButton(
                modifier = Modifier
                    .height(40.dp),
                label = "Label",
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = BaseButtonDefaults.EndIconContentPadding,
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
private fun BaseButtonPreview3() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                label = "Label",
                isLoading = true,
                style = MaterialTheme.typography.labelLarge,
                enabled = true,
                contentPadding = BaseButtonDefaults.ContentPadding,
                onClick = { /*TODO*/ }
            )
        }
    }
}
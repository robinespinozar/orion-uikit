package com.raerossi.orion.uikit.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.VerticalSpacer
import com.raerossi.orion.ui_kit.title_description.TitleDescription
import com.raerossi.orion.ui_kit.title_description.TitleDescriptionDefaults
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@PreviewLightDark
@Composable
private fun TitleDescriptionPreview() {
    OrionUiKitTheme {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            TitleDescription(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = "Emphasized Title",
                description = "Description with emphasized, this is a longer description to test the layout and see how it wraps",
                titleStyle = TitleDescriptionDefaults.emphasizedTitleStyle,
                descriptionStyle = TitleDescriptionDefaults.emphasizedDescriptionStyle,
                align = Alignment.CenterHorizontally,
                descriptionAlign = TextAlign.Center
            )
            VerticalSpacer(32)
            TitleDescription(
                modifier = Modifier.fillMaxWidth(),
                title = "Balanced Title",
                description = "Description with balanced style, this is a longer description to test the layout",
                titleStyle = TitleDescriptionDefaults.balancedTitleStyle,
                descriptionStyle = TitleDescriptionDefaults.balancedDescriptionStyle,
                align = Alignment.Start,
                descriptionAlign = TextAlign.Justify
            )
            VerticalSpacer(32)
            TitleDescription(
                modifier = Modifier, // without fillMaxWidth, you can put other component to the right
                title = "Compact Title",
                description = "Description with compact",
                titleStyle = TitleDescriptionDefaults.balancedTitleStyle,
                descriptionStyle = TitleDescriptionDefaults.balancedDescriptionStyle,
                align = Alignment.Start,
                descriptionAlign = TextAlign.Start
            )
        }
    }
}
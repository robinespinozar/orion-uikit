package com.raerossi.orion.ui_kit.title_description

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.VerticalSpacer

/**
 * TitleDescription component - A Material Design 3 aligned component that displays a title and description.

 * @param title The main title text to display
 * @param description The description text to display below the title
 * @param modifier The modifier to be applied to the component
 * @param titleStyle The text style for the title. Defaults to MaterialTheme.typography.headlineSmall
 * @param descriptionStyle The text style for the description. Defaults to MaterialTheme.typography.bodyMedium
 * @param spacing The spacing between title and description. Defaults to 8.dp
 * @param colors The colors for title and description text. Uses theme colors by default
 */
@Composable
fun TitleDescription(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = TitleDescriptionDefaults.balancedTitleStyle,
    descriptionStyle: TextStyle = TitleDescriptionDefaults.balancedDescriptionStyle,
    spacing: Dp = TitleDescriptionDefaults.spacing,
    align: Alignment.Horizontal = Alignment.CenterHorizontally,
    titleAlign: TextAlign? = null,
    descriptionAlign: TextAlign = TextAlign.Center,
    colors: TitleDescriptionColors = TitleDescriptionDefaults.colors()
) {
    Column(
        modifier = modifier,
        horizontalAlignment = align
    ) {
        Text(
            text = title,
            textAlign = titleAlign,
            color = colors.titleColor,
            style = titleStyle
        )
        Spacer(Modifier.height(spacing))
        Text(
            text = description,
            textAlign = descriptionAlign,
            color = colors.descriptionColor,
            style = descriptionStyle
        )
    }
}

@Preview
@Composable
private fun TitleDescriptionPreview() {
    Column(
        Modifier
            .padding(16.dp)
            .background(Color.White)
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
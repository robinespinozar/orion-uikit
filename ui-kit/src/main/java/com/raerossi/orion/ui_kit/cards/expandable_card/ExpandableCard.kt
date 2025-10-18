package com.raerossi.orion.ui_kit.cards.expandable_card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.spacers.VerticalSpacer

/**
 * Material Design 3 Expandable Card component.
 *
 * An ExpandableCard displays a header with title, optional subtitle/description, icons, badge,
 * and action buttons. The content area can be expanded or collapsed by clicking the header.
 *
 * Example usage:
 * ```
 * ExpandableCard(
 *     title = "FAQ Question",
 *     description = "Click to see the answer",
 *     expanded = isExpanded,
 *     onExpandChange = { isExpanded = it },
 *     content = {
 *         Text("This is the answer to the question...")
 *     }
 * )
 * ```
 *
 * @param title The main title text displayed in the header
 * @param modifier Modifier to be applied to the card
 * @param expanded Whether the content is currently expanded
 * @param onExpandChange Callback invoked when the user toggles the expanded state
 * @param enabled Whether the card can be expanded/collapsed
 * @param description Optional description text displayed below the title
 * @param subtitle Optional subtitle text displayed below the title
 * @param leadingIcon Optional icon displayed at the start of the header
 * @param leadingIconDescription Content description for the leading icon (required if leadingIcon is provided)
 * @param badge Optional badge text (e.g., "New", "3") displayed in the header
 * @param actions Optional list of action buttons displayed in the header
 * @param shape The shape of the card
 * @param colors The colors to use for the card
 * @param headerPadding The padding applied to the header content
 * @param contentPadding The padding applied to the expandable content
 * @param content The expandable content to display when expanded
 */
@Composable
fun ExpandableCard(
    title: String,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onExpandChange: ((Boolean) -> Unit)? = null,
    enabled: Boolean = true,
    description: String? = null,
    subtitle: String? = null,
    leadingIcon: ImageVector? = null,
    leadingIconDescription: String? = null,
    badge: String? = null,
    actions: List<ExpandableCardAction>? = null,
    shape: Shape = ExpandableCardDefaults.shape,
    colors: ExpandableCardColors = ExpandableCardDefaults.colors(),
    elevation: CardElevation = ExpandableCardDefaults.elevation,
    headerPadding: PaddingValues = ExpandableCardDefaults.headerPadding,
    contentPadding: PaddingValues = ExpandableCardDefaults.contentPadding,
    content: @Composable ColumnScope.() -> Unit
) {
    val containerColor by colors.containerColor(enabled)
    val contentColor by colors.contentColor(enabled)
    val iconColor by colors.iconColor(enabled)

    Card(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            CardHeader(
                title = title,
                subtitle = subtitle,
                description = description,
                leadingIcon = leadingIcon,
                leadingIconDescription = leadingIconDescription,
                badge = badge,
                actions = actions,
                expanded = expanded,
                enabled = enabled,
                iconColor = iconColor,
                contentColor = contentColor,
                padding = headerPadding,
                onExpandChange = onExpandChange
            )
            CardDetail(
                expanded = expanded,
                contentColor = contentColor,
                contentPadding = contentPadding,
                content = content
            )
        }
    }
}

@Composable
private fun CardHeader(
    title: String,
    subtitle: String?,
    description: String?,
    leadingIcon: ImageVector?,
    leadingIconDescription: String?,
    badge: String?,
    actions: List<ExpandableCardAction>?,
    expanded: Boolean,
    enabled: Boolean,
    iconColor: Color,
    contentColor: Color,
    padding: PaddingValues,
    onExpandChange: ((Boolean) -> Unit)?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (enabled && onExpandChange != null) {
                    Modifier.semantics {
                        role = Role.Button
                        contentDescription = if (expanded) "Collapse $title" else "Expand $title"
                    }
                } else Modifier
            )
            .testTag("expandable_card_header")
            .padding(padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Contenido principal (icono + texto)
        CardHeaderContent(
            modifier = Modifier.weight(1f),
            leadingIcon = leadingIcon,
            leadingIconDescription = leadingIconDescription,
            title = title,
            subtitle = subtitle,
            description = description,
            iconColor = iconColor,
            contentColor = contentColor
        )

        // Acciones y controles (badge + botones + chevron)
        CardHeaderActions(
            badge = badge,
            actions = actions,
            expanded = expanded,
            enabled = enabled,
            iconColor = iconColor,
            onExpandChange = onExpandChange
        )
    }
}

@Composable
private fun CardHeaderContent(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector?,
    leadingIconDescription: String?,
    title: String,
    subtitle: String?,
    description: String?,
    iconColor: Color,
    contentColor: Color
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingIcon?.let {
            Icon(
                imageVector = leadingIcon,
                contentDescription = leadingIconDescription,
                tint = iconColor
            )
            Spacer(modifier = Modifier.width(ExpandableCardDefaults.iconSpacing))
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = contentColor
            )
            subtitle?.let {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = contentColor.copy(alpha = 0.7f)
                )
            }
            VerticalSpacer(4)
            description?.let {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor.copy(alpha = 0.85f)
                )
            }
        }
    }
}

@Composable
private fun CardHeaderActions(
    badge: String?,
    actions: List<ExpandableCardAction>?,
    expanded: Boolean,
    enabled: Boolean,
    iconColor: Color,
    onExpandChange: ((Boolean) -> Unit)?
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        badge?.let {
            Text(
                text = badge,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        actions?.forEach { action ->
            IconButton(
                onClick = action.onClick,
                enabled = action.enabled && enabled
            ) {
                Icon(
                    imageVector = action.icon,
                    contentDescription = action.contentDescription,
                    tint = if (action.enabled && enabled) iconColor else iconColor.copy(alpha = 0.38f)
                )
            }
        }

        Chevron(
            expanded = expanded,
            enabled = enabled,
            iconColor = iconColor,
            onExpandChange = onExpandChange
        )
    }
}

@Composable
private fun Chevron(
    expanded: Boolean,
    enabled: Boolean,
    iconColor: Color,
    onExpandChange: ((Boolean) -> Unit)?
) {
    val chevronRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = "chevron_rotation"
    )

    IconButton(
        onClick = {
            if (enabled && onExpandChange != null) {
                onExpandChange(!expanded)
            }
        },
        enabled = enabled
    ) {
        Icon(
            modifier = Modifier
                .rotate(chevronRotation)
                .testTag("expandable_card_chevron"),
            imageVector = Icons.Rounded.ExpandMore,
            contentDescription = null,
            tint = iconColor
        )
    }
}

@Composable
private fun CardDetail(
    expanded: Boolean,
    contentColor: Color,
    contentPadding: PaddingValues,
    content: @Composable ColumnScope.() -> Unit
) {
    AnimatedVisibility(
        visible = expanded,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically()
    ) {
        Column {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = contentColor.copy(alpha = 0.12f)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(contentPadding)
            ) {
                content()
            }
        }
    }
}

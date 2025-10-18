package com.raerossi.orion.ui_kit.cards.stat_card.stat_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingFlat
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingFlat
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.spacers.HorizontalSpacer

/**
 * A Material Design 3 card component that displays a statistical metric with optional trend indicator.
 *
 * StatCard is ideal for dashboards and analytics screens, displaying key metrics in a
 * visually prominent way. It supports:
 * - Large, prominent value display
 * - Descriptive label
 * - Optional decorative icon
 * - Optional trend indicator with direction (up/down/neutral) and semantic colors
 * - Click interaction
 *
 * @param value The main metric value to display (e.g., "1,234", "$45.2K", "92%").
 * Format this string as desired before passing it.
 * @param label The description or label for the metric (e.g., "Total Sales", "Active Users")
 * @param modifier The [Modifier] to be applied to the card
 * @param icon Optional composable icon displayed at the top of the card, centered
 * @param trendValue Optional trend change value (e.g., "+12.5%", "-3.2%").
 * Must be provided along with [trendDirection] to display the trend section.
 * @param trendDirection Optional direction of the trend ([TrendDirection.UP], [TrendDirection.DOWN], [TrendDirection.NEUTRAL]).
 * Must be provided along with [trendValue] to display the trend section.
 * @param trendLabel Optional contextual label for the trend (e.g., "vs last month", "from yesterday")
 * @param onClick Optional click callback. When provided, the card becomes clickable with ripple effect
 * @param colors The colors to use for the card. See [StatCardDefaults.colors]
 * @param contentPadding The padding to apply inside the card. Defaults to 16.dp on all sides
 * @param shape The shape of the card. Defaults to [MaterialTheme.shapes.medium]
 * @param elevation The elevation of the card. Defaults to 2.dp
 *
 * Example usage:
 * ```
 * // Full featured with trend
 * StatCard(
 *     value = "1,234",
 *     label = "Total Sales",
 *     icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
 *     trendValue = "+12.5%",
 *     trendDirection = TrendDirection.UP,
 *     trendLabel = "vs last month",
 *     onClick = { /* Handle click */ }
 * )
 *
 * // Minimal
 * StatCard(
 *     value = "842",
 *     label = "Active Users"
 * )
 * ```
 */
@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    icon: (@Composable () -> Unit)? = null,
    trendValue: String? = null,
    trendDirection: TrendDirection? = null,
    trendLabel: String? = null,
    onClick: (() -> Unit)? = null,
    colors: StatCardColors = StatCardDefaults.colors(),
    contentPadding: PaddingValues = StatCardDefaults.contentPadding(),
    shape: Shape = StatCardDefaults.shape,
    elevation: CardElevation = StatCardDefaults.elevation()
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = colors.containerColor),
        elevation = elevation,
        onClick = onClick ?: {}
    ) {
        CardContent(
            value = value,
            label = label,
            icon = icon,
            trendValue = trendValue,
            trendDirection = trendDirection,
            trendLabel = trendLabel,
            colors = colors,
            contentPadding = contentPadding
        )
    }
}

@Composable
private fun CardContent(
    value: String,
    label: String,
    icon: (@Composable () -> Unit)? = null,
    trendValue: String? = null,
    trendDirection: TrendDirection? = null,
    trendLabel: String? = null,
    colors: StatCardColors,
    contentPadding: PaddingValues
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(contentPadding.calculateTopPadding()))

        icon?.let {
            CompositionLocalProvider(LocalContentColor provides colors.iconTint) {
                icon()
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
        Text(
            text = value,
            style = MaterialTheme.typography.displaySmall,
            color = colors.valueColor
        )
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = colors.labelColor
        )
        TrendSection(
            trendValue = trendValue,
            trendDirection = trendDirection,
            trendLabel = trendLabel,
            colors = colors
        )

        Spacer(modifier = Modifier.height(contentPadding.calculateBottomPadding()))
    }
}

@Composable
private fun TrendSection(
    trendValue: String?,
    trendDirection: TrendDirection?,
    trendLabel: String?,
    colors: StatCardColors
) {
    if (trendValue != null && trendDirection != null) {
        Spacer(modifier = Modifier.height(4.dp))
        val trendColor = StatCardDefaults.getTrendColor(trendDirection, colors)
        val trendIcon = StatCardDefaults.getTrendIcon(trendDirection)

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = trendIcon,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = trendColor
            )
            HorizontalSpacer(4)
            Text(
                text = if (trendLabel != null) "$trendValue $trendLabel" else trendValue,
                style = MaterialTheme.typography.bodySmall,
                color = trendColor
            )
        }
    }
}

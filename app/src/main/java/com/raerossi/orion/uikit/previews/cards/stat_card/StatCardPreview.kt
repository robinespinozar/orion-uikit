package com.raerossi.orion.uikit.previews.cards.stat_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.StatCard
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.StatCardColors
import com.raerossi.orion.ui_kit.cards.stat_card.stat_card.TrendDirection
import com.raerossi.orion.ui_kit.spacers.VerticalSpacer
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

/**
 * Preview composable for [StatCard] component.
 *
 * Displays various configurations and use cases of the StatCard component.
 */
@Preview(
    heightDp = 1500,
    showBackground = true
)
@Composable
private fun StatCardPreview() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "StatCard Examples",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            VerticalSpacer(8)

            // Full featured with positive trend
            Text(
                text = "Full featured - Positive trend",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            StatCard(
                value = "1,234",
                label = "Total Sales",
                icon = {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Shopping cart",
                        modifier = Modifier.padding(8.dp)
                    )
                },
                trendValue = "+12.5%",
                trendDirection = TrendDirection.UP,
                trendLabel = "vs last month"
            )

            VerticalSpacer(8)

            // With negative trend
            Text(
                text = "With negative trend",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            StatCard(
                value = "$45.2K",
                label = "Revenue",
                icon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = "Money",
                        modifier = Modifier.padding(8.dp)
                    )
                },
                trendValue = "-3.2%",
                trendDirection = TrendDirection.DOWN,
                trendLabel = "vs last week"
            )

            VerticalSpacer(8)

            // With neutral trend
            Text(
                text = "With neutral trend",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            StatCard(
                value = "842",
                label = "Active Users",
                icon = {
                    Icon(
                        imageVector = Icons.Default.People,
                        contentDescription = "People",
                        modifier = Modifier.padding(8.dp)
                    )
                },
                trendValue = "0.0%",
                trendDirection = TrendDirection.NEUTRAL,
                trendLabel = "no change"
            )

            VerticalSpacer(8)

            // Without trend, with icon
            Text(
                text = "Without trend",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            StatCard(
                value = "99.8%",
                label = "Uptime",
                icon = {
                    Icon(
                        imageVector = Icons.Default.TrendingUp,
                        contentDescription = "Trending up",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )

            VerticalSpacer(8)

            // Minimal (no icon, no trend)
            Text(
                text = "Minimal",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            StatCard(
                value = "23",
                label = "Pending Tasks"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StatCardPreview2() {
    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // With custom colors
            Text(
                text = "Custom colors",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            StatCard(
                value = "3.5M",
                label = "Total Views",
                icon = {
                    Icon(
                        imageVector = Icons.Default.TrendingUp,
                        contentDescription = "Views",
                        modifier = Modifier.padding(8.dp)
                    )
                },
                trendValue = "+25.8%",
                trendDirection = TrendDirection.UP,
                trendLabel = "this month",
                colors = StatCardColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                    valueColor = MaterialTheme.colorScheme.onTertiary,
                    labelColor = MaterialTheme.colorScheme.onTertiary,
                    iconTint = MaterialTheme.colorScheme.primary,
                    trendUpColor = Color(0xFF4DE256),
                    trendDownColor = Color(0xFFC62828),
                    trendNeutralColor = Color(0xFF757575)
                )
            )

            VerticalSpacer(8)

            // Grid layout example (2 columns)
            Text(
                text = "Dashboard grid layout",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    value = "156",
                    label = "Orders",
                    trendValue = "+8%",
                    trendDirection = TrendDirection.UP,
                    modifier = Modifier.weight(1f)
                )

                StatCard(
                    value = "92%",
                    label = "Satisfaction",
                    trendValue = "+2%",
                    trendDirection = TrendDirection.UP,
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    value = "$12.4K",
                    label = "Avg. Order",
                    trendValue = "-1.5%",
                    trendDirection = TrendDirection.DOWN,
                    modifier = Modifier.weight(1f)
                )

                StatCard(
                    value = "4.2",
                    label = "Rating",
                    trendValue = "0.0",
                    trendDirection = TrendDirection.NEUTRAL,
                    modifier = Modifier.weight(1f)
                )
            }

            VerticalSpacer(16)
        }
    }
}
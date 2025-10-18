package com.raerossi.orion.uikit.previews.cards.expandable_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.cards.expandable_card.ExpandableCard
import com.raerossi.orion.ui_kit.cards.expandable_card.ExpandableCardAction
import com.raerossi.orion.ui_kit.cards.expandable_card.ExpandableCardDefaults
import com.raerossi.orion.ui_kit.spacers.VerticalSpacer
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

/**
 * Preview composables for [ExpandableCard] component.
 *
 * Demonstrates various configurations and use cases:
 * - Basic expandable card
 * - Card with description
 * - Card with leading icon
 * - Card with badge
 * - Card with actions
 * - Card with all features
 * - FAQ example
 * - Settings example
 * - Notification example
 * - Disabled state
 */

@Preview(
    name = "Basics Examples",
    heightDp = 950,
    showBackground = true
)
@Composable
private fun BasicExpandableCardPreview() {
    var expanded by remember { mutableStateOf(true) }

    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Basic ExpandableCard",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Basic Expandable Card",
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Text("This is the expandable content. Click the header to toggle visibility.")
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Card with Description",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Card with Description",
                description = "This description is always visible, even when collapsed",
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Text("Additional details appear here when expanded.")
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Card with Subtitle",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Article Title",
                subtitle = "Published 2 days ago",
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Text("This is the full article content that appears when you expand the card...")
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Card with Leading Icon",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Security Settings",
                leadingIcon = Icons.Default.Lock,
                leadingIconDescription = "Security",
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Text("Your security settings and privacy options can be configured here.")
                }
            )
        }
    }
}

@Preview(
    name = "Actions Examples",
    heightDp = 950,
    showBackground = true
)
@Composable
private fun BasicExpandableCardPreview2() {
    var expanded by remember { mutableStateOf(true) }

    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Card with Badge",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Notifications",
                leadingIcon = Icons.Default.Notifications,
                leadingIconDescription = "Notifications",
                badge = "3",
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Column {
                        Text("• New message from John - 5 min ago")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("• App update available - 1 hour ago")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("• Reminder: Meeting at 3 PM - 2 hours ago")
                    }
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Card with Actions",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Article: Jetpack Compose Guide",
                subtitle = "By Jane Doe",
                actions = listOf(
                    ExpandableCardAction(
                        icon = Icons.Default.Share,
                        contentDescription = "Share",
                        onClick = { /* Share action */ }
                    ),
                    ExpandableCardAction(
                        icon = Icons.Default.Bookmark,
                        contentDescription = "Bookmark",
                        onClick = { /* Bookmark action */ }
                    )
                ),
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Text("Jetpack Compose is a modern toolkit for building native Android UI. It simplifies and accelerates UI development on Android...")
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Card with All Features",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Premium Feature",
                subtitle = "New",
                description = "Unlock advanced capabilities",
                leadingIcon = Icons.Default.Info,
                leadingIconDescription = "Information",
                badge = "Pro",
                actions = listOf(
                    ExpandableCardAction(
                        icon = Icons.Default.Edit,
                        contentDescription = "Edit",
                        onClick = { /* Edit action */ }
                    )
                ),
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Column {
                        Text("This premium feature includes:")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("• Advanced analytics")
                        Text("• Priority support")
                        Text("• Custom branding")
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { /* Upgrade action */ }) {
                            Text("Upgrade Now")
                        }
                    }
                }
            )
        }
    }
}

@Preview(
    name = "Others Examples",
    heightDp = 950,
    showBackground = true
)
@Composable
private fun BasicExpandableCardPreview3() {
    var expanded by remember { mutableStateOf(true) }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var emailEnabled by remember { mutableStateOf(false) }
    var pushEnabled by remember { mutableStateOf(true) }

    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Settings Example",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Notification Settings",
                leadingIcon = Icons.Default.Notifications,
                leadingIconDescription = "Notifications",
                subtitle = if (notificationsEnabled) "Enabled" else "Disabled",
                expanded = expanded,
                onExpandChange = { expanded = it },
                content = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Enable Notifications")
                            Switch(
                                checked = notificationsEnabled,
                                onCheckedChange = { notificationsEnabled = it }
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Email Notifications")
                            Checkbox(
                                checked = emailEnabled,
                                onCheckedChange = { emailEnabled = it }
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Push Notifications")
                            Checkbox(
                                checked = pushEnabled,
                                onCheckedChange = { pushEnabled = it }
                            )
                        }
                    }
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Disabled Card",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Disabled Card",
                description = "This card cannot be expanded",
                enabled = false,
                content = {
                    Text("This content will not be accessible because the card is disabled.")
                }
            )
            VerticalSpacer(24)
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Custom Colors",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ExpandableCard(
                title = "Custom Styled Card",
                description = "This card uses custom colors",
                expanded = expanded,
                onExpandChange = { expanded = it },
                colors = ExpandableCardDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    iconColor = Color.White
                ),
                content = {
                    Text("The content area also inherits the custom color scheme.")
                }
            )
        }
    }
}

@Preview(name = "Multiple Cards Showcase", showBackground = true)
@Composable
private fun MultipleExpandableCardsPreview() {
    var expanded1 by remember { mutableStateOf(true) }
    var expanded2 by remember { mutableStateOf(true) }
    var expanded3 by remember { mutableStateOf(true) }

    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "ExpandableCard Showcase",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            ExpandableCard(
                title = "Introduction",
                leadingIcon = Icons.Default.Info,
                leadingIconDescription = "Info",
                expanded = expanded1,
                onExpandChange = { expanded1 = it },
                content = {
                    Text("Welcome to the ExpandableCard component. This card demonstrates how content can be shown or hidden with a smooth animation.")
                }
            )

            ExpandableCard(
                title = "Features",
                badge = "New",
                expanded = expanded2,
                onExpandChange = { expanded2 = it },
                content = {
                    Column {
                        Text("Key features include:")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("✓ Smooth expand/collapse animation")
                        Text("✓ Customizable colors and shapes")
                        Text("✓ Support for icons and badges")
                        Text("✓ Action buttons")
                        Text("✓ Accessibility support")
                    }
                }
            )

            ExpandableCard(
                title = "Documentation",
                subtitle = "Learn more",
                actions = listOf(
                    ExpandableCardAction(
                        icon = Icons.Default.Share,
                        contentDescription = "Share",
                        onClick = { /* Share docs */ }
                    )
                ),
                expanded = expanded3,
                onExpandChange = { expanded3 = it },
                content = {
                    Text("For more information, check out the component documentation and examples in the library.")
                }
            )
        }
    }
}

@Preview(name = "FAQs Showcase", showBackground = true)
@Composable
private fun BasicExpandableCardPreview4() {
    var expanded1 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var expanded3 by remember { mutableStateOf(false) }
    var expanded4 by remember { mutableStateOf(false) }
    var expanded5 by remember { mutableStateOf(true) }

    OrionUiKitTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "FAQ Example",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ExpandableCard(
                title = "What is Jetpack Compose?",
                expanded = expanded1,
                onExpandChange = { expanded1 = it },
                content = {
                    Text("Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.")
                }
            )
            ExpandableCard(
                title = "How does ExpandableCard work?",
                expanded = expanded2,
                onExpandChange = { expanded2 = it },
                content = {
                    Text("The ExpandableCard component allows you to show and hide content within a card layout. Users can tap the card header to expand or collapse the content area.")
                }
            )
            ExpandableCard(
                title = "Is ExpandableCard customizable?",
                expanded = expanded3,
                onExpandChange = { expanded3 = it },
                content = {
                    Text("Yes, the ExpandableCard component offers various customization options including colors, shapes, icons, badges, and action buttons to fit your app's design needs.")
                }
            )
            ExpandableCard(
                title = "Can I use ExpandableCard for settings?",
                expanded = expanded4,
                onExpandChange = { expanded4 = it },
                content = {
                    Text("Absolutely! ExpandableCard is great for organizing settings and preferences, allowing users to expand sections to view and modify options.")
                }
            )
            ExpandableCard(
                title = "Where can I find more examples?",
                expanded = expanded5,
                onExpandChange = { expanded5 = it },
                content = {
                    Text("You can find more examples and documentation in the official Orion UI Kit repository and website.")
                }
            )
        }
    }
}
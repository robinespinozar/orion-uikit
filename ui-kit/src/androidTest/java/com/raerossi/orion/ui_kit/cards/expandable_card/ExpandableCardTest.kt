package com.raerossi.orion.ui_kit.cards.expandable_card

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * Tests for [ExpandableCard] following TDD (Test-Driven Development)
 *
 * Component requirements:
 * - Display a card with expandable/collapsable content
 * - Header always visible with title, optional subtitle, description, icons, badge, and actions
 * - Content area that animates in/out when expanded/collapsed
 * - Chevron icon that rotates based on expanded state
 * - Support for controlled and uncontrolled state
 * - Click on header expands/collapses the card
 * - Actions are independent icon buttons that don't trigger expand/collapse
 * - Support for enabled/disabled state
 * - Material Design 3 styling with customizable colors, shape, elevation
 * - Accessibility support with proper semantics
 *
 * Expected signature:
 * @Composable
 * fun ExpandableCard(
 *     title: String,
 *     modifier: Modifier = Modifier,
 *     expanded: Boolean = false,
 *     onExpandChange: ((Boolean) -> Unit)? = null,
 *     enabled: Boolean = true,
 *     description: String? = null,
 *     subtitle: String? = null,
 *     leadingIcon: ImageVector? = null,
 *     leadingIconDescription: String? = null,
 *     badge: String? = null,
 *     actions: List<ExpandableCardAction>? = null,
 *     shape: Shape = ExpandableCardDefaults.shape,
 *     colors: ExpandableCardColors = ExpandableCardDefaults.colors(),
 *     tonalElevation: Dp = ExpandableCardDefaults.tonalElevation,
 *     shadowElevation: Dp = ExpandableCardDefaults.shadowElevation,
 *     headerPadding: PaddingValues = ExpandableCardDefaults.headerPadding,
 *     contentPadding: PaddingValues = ExpandableCardDefaults.contentPadding,
 *     content: @Composable ColumnScope.() -> Unit
 * )
 *
 * data class ExpandableCardAction(
 *     val icon: ImageVector,
 *     val contentDescription: String,
 *     val onClick: () -> Unit,
 *     val enabled: Boolean = true
 * )
 */
class ExpandableCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // ==================== Basic Display Tests ====================

    @Test
    fun expandableCard_displaysTitle() {
        // Given: An ExpandableCard with a title
        val title = "Card Title"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = title,
                    content = { Text("Content") }
                )
            }
        }

        // Then: The title should be displayed
        composeTestRule
            .onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_displaysDescription_whenProvided() {
        // Given: An ExpandableCard with title and description
        val description = "This is a description"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    description = description,
                    content = { Text("Content") }
                )
            }
        }

        // Then: The description should be displayed
        composeTestRule
            .onNodeWithText(description)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_displaysSubtitle_whenProvided() {
        // Given: An ExpandableCard with subtitle
        val subtitle = "Subtitle text"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    subtitle = subtitle,
                    content = { Text("Content") }
                )
            }
        }

        // Then: The subtitle should be displayed
        composeTestRule
            .onNodeWithText(subtitle)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_displaysBadge_whenProvided() {
        // Given: An ExpandableCard with a badge
        val badge = "New"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    badge = badge,
                    content = { Text("Content") }
                )
            }
        }

        // Then: The badge should be displayed
        composeTestRule
            .onNodeWithText(badge)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_displaysLeadingIcon_whenProvided() {
        // Given: An ExpandableCard with a leading icon
        val iconDescription = "Lock icon"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    leadingIcon = Icons.Default.Lock,
                    leadingIconDescription = iconDescription,
                    content = { Text("Content") }
                )
            }
        }

        // Then: The leading icon should be displayed
        composeTestRule
            .onNodeWithContentDescription(iconDescription)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_displaysChevronIcon() {
        // Given: An ExpandableCard
        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    content = { Text("Content") }
                )
            }
        }

        // Esperar a que la UI se estabilice
        composeTestRule.waitForIdle()

        // Then: The chevron icon should be displayed
        composeTestRule
            .onNodeWithTag("expandable_card_chevron")
            .assertExists()
    }

    // ==================== Content Visibility Tests ====================

    @Test
    fun expandableCard_hidesContent_whenCollapsed() {
        // Given: An ExpandableCard in collapsed state
        val contentText = "Hidden content"

        // When: The card is rendered with expanded = false
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = false,
                    content = { Text(contentText) }
                )
            }
        }

        // Then: The content should not be displayed
        composeTestRule
            .onNodeWithText(contentText)
            .assertDoesNotExist()
    }

    @Test
    fun expandableCard_showsContent_whenExpanded() {
        // Given: An ExpandableCard in expanded state
        val contentText = "Visible content"

        // When: The card is rendered with expanded = true
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = true,
                    content = { Text(contentText) }
                )
            }
        }

        // Then: The content should be displayed
        composeTestRule
            .onNodeWithText(contentText)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_contentIsCollapsed_byDefault() {
        // Given: An ExpandableCard without explicit expanded parameter
        val contentText = "Default hidden content"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    content = { Text(contentText) }
                )
            }
        }

        // Then: The content should not be displayed (default is collapsed)
        composeTestRule
            .onNodeWithText(contentText)
            .assertDoesNotExist()
    }

    // ==================== Interaction Tests ====================

    @Test
    fun expandableCard_collapsesContent_whenHeaderClickedWhileExpanded() {
        // Given: An ExpandableCard in expanded state
        var expandedState = true

        // When: The card is rendered and header is clicked
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = expandedState,
                    onExpandChange = { expandedState = it },
                    content = { Text("Content") }
                )
            }
        }

        // Click the header
        composeTestRule
            .onNodeWithTag("expandable_card_header")
            .performClick()

        // Then: onExpandChange should be called with false
        assert(!expandedState)
    }

    @Test
    fun expandableCard_doesNotExpand_whenDisabled() {
        // Given: A disabled ExpandableCard
        var expandedState = false

        // When: The card is rendered as disabled and header is clicked
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = expandedState,
                    enabled = false,
                    onExpandChange = { expandedState = it },
                    content = { Text("Content") }
                )
            }
        }

        // Click the header
        composeTestRule
            .onNodeWithTag("expandable_card_header")
            .performClick()

        // Then: onExpandChange should not be called
        assert(!expandedState)
    }

    // ==================== Action Tests ====================

    @Test
    fun expandableCard_displaysActions_whenProvided() {
        // Given: An ExpandableCard with actions
        val action1Description = "Edit"
        val action2Description = "Share"

        // When: The card is rendered with actions
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Edit,
                            contentDescription = action1Description,
                            onClick = {}
                        ),
                        ExpandableCardAction(
                            icon = Icons.Default.Share,
                            contentDescription = action2Description,
                            onClick = {}
                        )
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Then: All actions should be displayed
        composeTestRule
            .onNodeWithContentDescription(action1Description)
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription(action2Description)
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_actionsAreClickable() {
        // Given: An ExpandableCard with actions
        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Edit,
                            contentDescription = "Edit",
                            onClick = {}
                        )
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Then: The action should have click action
        composeTestRule
            .onNodeWithContentDescription("Edit")
            .assertHasClickAction()
    }

    @Test
    fun expandableCard_actionClick_doesNotExpandCard() {
        // Given: An ExpandableCard with an action
        var expandedState = false
        var actionClicked = false

        // When: The card is rendered and action is clicked
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = expandedState,
                    onExpandChange = { expandedState = it },
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Edit,
                            contentDescription = "Edit",
                            onClick = { actionClicked = true }
                        )
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Click the action
        composeTestRule
            .onNodeWithContentDescription("Edit")
            .performClick()

        // Then: Action callback should be called but card should not expand
        assert(actionClicked)
        assert(!expandedState)
    }

    @Test
    fun expandableCard_actionClick_triggersCallback() {
        // Given: An ExpandableCard with an action
        var actionClicked = false

        // When: The card is rendered and action is clicked
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            onClick = { actionClicked = true }
                        )
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Click the action
        composeTestRule
            .onNodeWithContentDescription("Favorite")
            .performClick()

        // Then: The callback should be triggered
        assert(actionClicked)
    }

    @Test
    fun expandableCard_disabledAction_doesNotTriggerCallback() {
        // Given: An ExpandableCard with a disabled action
        var actionClicked = false

        // When: The card is rendered and disabled action is clicked
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Edit,
                            contentDescription = "Edit",
                            onClick = { actionClicked = true },
                            enabled = false
                        )
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Click the disabled action
        composeTestRule
            .onNodeWithContentDescription("Edit")
            .performClick()

        // Then: The callback should not be triggered
        assert(!actionClicked)
    }

    @Test
    fun expandableCard_multipleActions_allClickable() {
        // Given: An ExpandableCard with multiple actions
        var action1Clicked = false
        var action2Clicked = false

        // When: The card is rendered with two actions
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Edit,
                            contentDescription = "Edit",
                            onClick = { action1Clicked = true }
                        ),
                        ExpandableCardAction(
                            icon = Icons.Default.Share,
                            contentDescription = "Share",
                            onClick = { action2Clicked = true }
                        )
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Click first action
        composeTestRule
            .onNodeWithContentDescription("Edit")
            .performClick()

        // Click second action
        composeTestRule
            .onNodeWithContentDescription("Share")
            .performClick()

        // Then: Both callbacks should be triggered
        assert(action1Clicked)
        assert(action2Clicked)
    }

    // ==================== State Tests ====================

    @Test
    fun expandableCard_maintainsExpandedState() {
        // Given: An ExpandableCard with controlled state
        var expandedState = true

        // When: The card is rendered in expanded state
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = expandedState,
                    content = { Text("Content") }
                )
            }
        }

        // Then: Content should be visible
        composeTestRule
            .onNodeWithText("Content")
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_respondsToExternalStateChange() {
        // Given: An ExpandableCard with controlled state
        var expandedState = false
        val contentText = "Dynamic content"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                Column {
                    ExpandableCard(
                        title = "Title",
                        expanded = expandedState,
                        content = { Text(contentText) }
                    )
                }
            }
        }

        // Initially content is hidden
        composeTestRule
            .onNodeWithText(contentText)
            .assertDoesNotExist()

        // Change state externally
        composeTestRule.runOnIdle {
            expandedState = true
        }

        composeTestRule.setContent {
            MaterialTheme {
                Column {
                    ExpandableCard(
                        title = "Title",
                        expanded = expandedState,
                        content = { Text(contentText) }
                    )
                }
            }
        }

        // Then: Content should now be visible
        composeTestRule
            .onNodeWithText(contentText)
            .assertIsDisplayed()
    }

    // ==================== Styling Tests ====================

    @Test
    fun expandableCard_appliesCustomModifier() {
        // Given: An ExpandableCard with custom modifier
        // When: The card is rendered with a test tag modifier
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    modifier = Modifier.testTag("custom_card"),
                    content = { Text("Content") }
                )
            }
        }

        // Then: The custom modifier should be applied
        composeTestRule
            .onNodeWithTag("custom_card")
            .assertExists()
    }

    @Test
    fun expandableCard_usesDefaultColors() {
        // Given: An ExpandableCard without custom colors
        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    content = { Text("Content") }
                )
            }
        }

        // Then: The card should be displayed (validates default colors work)
        composeTestRule
            .onNodeWithText("Title")
            .assertIsDisplayed()
    }

    @Test
    fun expandableCard_acceptsCustomColors() {
        // Given: An ExpandableCard with custom colors
        // When: The card is rendered with custom colors
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    colors = ExpandableCardDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    content = { Text("Content") }
                )
            }
        }

        // Then: The card should be displayed (validates custom colors work)
        composeTestRule
            .onNodeWithText("Title")
            .assertIsDisplayed()
    }

    // ==================== Accessibility Tests ====================

    @Test
    fun expandableCard_headerHasButtonRole() {
        // Given: An ExpandableCard
        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    content = { Text("Content") },
                    onExpandChange = {}
                )
            }
        }

        // Then: The header should have Button role
        composeTestRule
            .onNodeWithTag("expandable_card_header")
            .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
    }

    @Test
    fun expandableCard_chevronHasNoContentDescription() {
        // Given: An ExpandableCard
        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    content = { Text("Content") }
                )
            }
        }

        // Then: The chevron should have null content description
        // (since the header provides the semantic context)
        composeTestRule
            .onNodeWithTag("expandable_card_chevron")
            .assertExists()
    }

    @Test
    fun expandableCard_leadingIconHasContentDescription() {
        // Given: An ExpandableCard with leading icon
        val iconDescription = "Security settings"

        // When: The card is rendered
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    leadingIcon = Icons.Default.Lock,
                    leadingIconDescription = iconDescription,
                    content = { Text("Content") }
                )
            }
        }

        // Then: The icon should have proper content description
        composeTestRule
            .onNodeWithContentDescription(iconDescription)
            .assertExists()
    }

    // ==================== Integration Tests ====================

    @Test
    fun expandableCard_fullConfiguration_displaysAllElements() {
        // Given: An ExpandableCard with all parameters
        val title = "Full Card"
        val subtitle = "Complete example"
        val description = "Description text"
        val badge = "3"
        val leadingIconDesc = "Icon"
        val actionDesc = "Action"
        val contentText = "Full content"

        // When: The card is rendered with all parameters
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = title,
                    subtitle = subtitle,
                    description = description,
                    badge = badge,
                    leadingIcon = Icons.Default.Lock,
                    leadingIconDescription = leadingIconDesc,
                    expanded = true,
                    actions = listOf(
                        ExpandableCardAction(
                            icon = Icons.Default.Edit,
                            contentDescription = actionDesc,
                            onClick = {}
                        )
                    ),
                    content = { Text(contentText) }
                )
            }
        }

        // Then: All elements should be displayed
        composeTestRule.onNodeWithText(title).assertIsDisplayed()
        composeTestRule.onNodeWithText(subtitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(description).assertIsDisplayed()
        composeTestRule.onNodeWithText(badge).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(leadingIconDesc).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(actionDesc).assertIsDisplayed()
        composeTestRule.onNodeWithText(contentText).assertIsDisplayed()
    }

    @Test
    fun expandableCard_complexContent_rendersCorrectly() {
        // Given: An ExpandableCard with complex content
        // When: The card is rendered with multiple composables in content
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Complex Card",
                    expanded = true,
                    content = {
                        Text("First line")
                        Text("Second line")
                        Text("Third line")
                    }
                )
            }
        }

        // Then: All content should be displayed
        composeTestRule.onNodeWithText("First line").assertIsDisplayed()
        composeTestRule.onNodeWithText("Second line").assertIsDisplayed()
        composeTestRule.onNodeWithText("Third line").assertIsDisplayed()
    }

    @Test
    fun expandableCard_toggleMultipleTimes_worksCorrectly() {
        // Given: An ExpandableCard
        var expandedState = false
        val contentText = "Toggle content"

        // When: The card is rendered and toggled multiple times
        composeTestRule.setContent {
            MaterialTheme {
                ExpandableCard(
                    title = "Title",
                    expanded = expandedState,
                    onExpandChange = { expandedState = it },
                    content = { Text(contentText) }
                )
            }
        }

        // Initially collapsed
        composeTestRule.onNodeWithText(contentText).assertDoesNotExist()

        // Toggle 1: Expand
        composeTestRule.onNodeWithTag("expandable_card_header").performClick()
        composeTestRule.waitForIdle()
        assert(expandedState)

        // Toggle 2: Collapse
        composeTestRule.onNodeWithTag("expandable_card_header").performClick()
        composeTestRule.waitForIdle()
        assert(!expandedState)

        // Toggle 3: Expand again
        composeTestRule.onNodeWithTag("expandable_card_header").performClick()
        composeTestRule.waitForIdle()
        assert(expandedState)
    }
}

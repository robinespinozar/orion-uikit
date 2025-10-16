# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Orion UI Kit is an Android library that provides custom UI components for **Jetpack Compose**. The project is published via **JitPack** and follows a multi-module architecture with separate modules for the demo app and the library itself.

**Important:** This is a library project - changes should be made in the `ui-kit` module, not the `app` module (which serves as a demo/showcase).

## Project Structure

```
orion-uikit/
├── app/              # Demo application showcasing the UI components
└── ui-kit/           # Core library module (THIS IS WHERE YOU MAKE CHANGES)
    └── src/
        ├── main/java/com/raerossi/orion/ui_kit/
        │   ├── buttons/
        │   │   ├── base_button/        # BaseButton with icons, loading states
        │   │   ├── gradient_button/    # Button with gradient backgrounds
        │   │   ├── outlined_base_button/ # Outlined variant
        │   │   └── text_base_button/   # Text-only variant
        │   ├── tile/                   # Clickable Tile component with icons
        │   ├── title_description/      # Title+Description layout component
        │   └── Spacer.kt              # Utility spacer components
        └── androidTest/               # UI tests (Compose testing)
```

## Component Architecture

### Component Pattern
All components follow a consistent pattern:
1. **Main composable** - The public API (e.g., `BaseButton`, `Tile`)
2. **Defaults object** - Contains default values, shapes, colors, paddings (e.g., `BaseButtonDefaults`)
3. **Colors data class** (if applicable) - Encapsulates color configurations
4. **Internal composables** - Private helper composables for content rendering

### Key Design Principles
- **Material Design 3 First**: All components MUST strictly follow Material Design 3 guidelines and patterns to ensure intuitive usage for any developer
- **Icon support**: Most components support `leadingIcon` and `trailingIcon` with configurable spacing
- **Loading states**: Buttons support `isLoading` parameter that shows CircularProgressIndicator
- **Customization**: All visual aspects (colors, shapes, padding, elevation) can be customized via parameters
- **Material 3 Tokens**: Use Material Theme tokens (typography, colors, spacing) as default values
- **Testing**: Each component has UI tests with semantic/testTag selectors

## Build Commands

### Building the Library
```bash
./gradlew :ui-kit:assemble
```

### Running Tests
```bash
# Run all tests in ui-kit module
./gradlew :ui-kit:test

# Run Android instrumentation tests (UI tests)
./gradlew :ui-kit:connectedAndroidTest

# Run specific test class
./gradlew :ui-kit:connectedAndroidTest --tests "com.raerossi.orion.ui_kit.BaseButtonTest"
```

### Running the Demo App
```bash
# Install on connected device/emulator
./gradlew :app:installDebug

# Build APK
./gradlew :app:assembleDebug
```

### Publishing (JitPack)
The library is published via JitPack. After pushing to GitHub:
- JitPack automatically builds releases from git tags
- Consumers add: `implementation("com.github.robinespinozar:orion-uikit:Tag")`

## Development Guidelines

### Test-Driven Development (TDD) Workflow

**CRITICAL**: This project follows **strict TDD methodology**. When the user requests to create a new component, you MUST:

1. **Generate comprehensive TDD tests FIRST** based on the UI component requirements
2. **Create minimal component structure** (empty/stub implementations) to make tests compilable
3. **DO NOT implement the full component** - the user will implement it themselves after reviewing the tests

#### TDD Test Generation Process

When asked to create a component, follow this exact workflow:

**Step 1: Analyze Requirements**
- Extract all functional requirements from the component description
- Identify Material Design 3 patterns that apply
- Determine component signature (parameters, return type)

**Step 2: Generate Comprehensive Tests**

Create a test file in `ui-kit/src/androidTest/java/com/raerossi/orion/ui_kit/` with:

```kotlin
/**
 * Tests for [ComponentName] following TDD (Test-Driven Development)
 *
 * Component requirements:
 * - [List all requirements here]
 *
 * Expected signature:
 * @Composable
 * fun ComponentName(
 *     param1: Type,
 *     param2: Type = default,
 *     ...
 * )
 */
class ComponentNameTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    // Test categories:
    // 1. Basic Display Tests
    // 2. Interaction Tests
    // 3. State Tests
    // 4. Styling Tests
    // 5. Color Tests
    // 6. Modifier Tests
    // 7. Defaults Tests
    // 8. Integration Tests
}
```

**Test Structure Pattern** (see TileTest.kt and TitleDescriptionTest.kt as reference):
- Use Given/When/Then comments for clarity
- Test one behavior per test method
- Use descriptive test names: `componentName_behaviorUnderTest_expectedResult`
- Group tests by category with comment headers
- Test both positive cases and edge cases
- Include integration tests with all parameters combined

**Step 3: Create Minimal Component Structure**

Create files:
1. `ComponentName.kt` - Main composable with TODO comments
2. `ComponentNameDefaults.kt` - Empty defaults object
3. `ComponentNameColors.kt` (if needed) - Empty colors data class

**Step 4: Stop and Let User Implement**
- Present the generated tests to the user
- Provide brief explanation of test coverage
- User will implement the component to pass the tests

### Adding a New Component (Non-TDD Flow)
1. Create component file in appropriate package under `ui-kit/src/main/java/com/raerossi/orion/ui_kit/`
2. Create corresponding `*Defaults` object for default values
3. Add `@Preview` composables for visual validation
4. Create test file in `ui-kit/src/androidTest/java/com/raerossi/orion/ui_kit/`
5. Use `testTag()` modifiers for testable elements
6. Follow existing naming conventions (e.g., `leadingIcon`, `trailingIcon`, `contentPadding`)

### Testing Conventions
- UI tests use **Compose Testing** with `createComposeRule()`
- Use semantic matchers: `onNodeWithText()`, `onNodeWithTag()`, `onNodeWithContentDescription()`
- Test user interactions: clicks, loading states, enabled/disabled states
- Verify rendering: `assertIsDisplayed()`, `assertExists()`, `assertIsEnabled()`
- Wrap composables in `MaterialTheme` when testing to ensure proper theme context

### Material Design 3 Compliance

All components MUST adhere to Material Design 3 guidelines to ensure developer-friendly, intuitive APIs:

**Typography**
- Use MaterialTheme typography scale: `displayLarge`, `headlineLarge`, `titleMedium`, `bodyLarge`, `labelSmall`, etc.
- Never hardcode text sizes - always reference theme typography
- Example: `style = MaterialTheme.typography.titleLarge`

**Color System**
- Use semantic color tokens: `primary`, `onPrimary`, `surface`, `onSurface`, `outline`, etc.
- Support both light and dark themes automatically
- Example: `color = MaterialTheme.colorScheme.onSurface`

**Spacing & Layout**
- Follow 4dp/8dp grid system
- Common spacing values: 4.dp, 8.dp, 12.dp, 16.dp, 24.dp, 32.dp
- Use consistent padding/spacing across similar components

**Shapes**
- Use MaterialTheme shape scale: `extraSmall`, `small`, `medium`, `large`, `extraLarge`
- Apply appropriate shapes for component types (buttons, cards, dialogs)
- Example: `shape = MaterialTheme.shapes.medium`

**States & Interactions**
- Support enabled/disabled states
- Provide proper touch targets (minimum 48.dp)
- Use Material elevation/shadow patterns
- Implement proper ripple effects

**Accessibility**
- Use semantic roles: `Role.Button`, `Role.Checkbox`, etc.
- Provide contentDescription for icons
- Support screen readers with proper semantics
- Ensure sufficient color contrast

### Code Style
- **Namespace**: `com.raerossi.orion.ui_kit`
- **Compose**: Use `@Composable` functions following Compose guidelines
- **Parameters**: Follow order: modifier, required params, optional params with defaults, callbacks (e.g., `onClick`)
- **Documentation**: Use KDoc for public components with `@param` descriptions
- **Spacing utilities**: Use `Spacer(Modifier.width/height())` or custom `VerticalSpacer()`/`HorizontalSpacer()`

### Git Commit Conventions

This project follows **Conventional Commits** specification for all commit messages.

**Format:**
```
<type>(<scope>): <description>

[optional body]

[optional footer(s)]
```

**Types:**
- `feat`: New feature or component
- `fix`: Bug fix
- `test`: Adding or updating tests
- `refactor`: Code change that neither fixes a bug nor adds a feature
- `docs`: Documentation changes
- `style`: Code style changes (formatting, missing semicolons, etc.)
- `perf`: Performance improvements
- `build`: Build system or dependency changes
- `ci`: CI/CD configuration changes
- `chore`: Other changes that don't modify src or test files

**Scopes** (component/module affected):
- `components`: General component changes
- `tile`: Tile component
- `title-description`: TitleDescription component
- `buttons`: Button components (BaseButton, GradientButton, etc.)
- `spacer`: Spacer utilities
- `tests`: Test infrastructure
- `deps`: Dependencies
- others news as needed

**Examples:**
```
feat(tile): Add Tile component with icon support
test(buttons): Add comprehensive tests for BaseButton loading state
fix(tile): Correct ripple effect on disabled state
docs: Update README with new component examples
refactor(buttons): Extract common button logic to shared utility
```

**When creating commits:**
- Use present tense ("Add feature" not "Added feature")
- Use imperative mood ("Move cursor to..." not "Moves cursor to...")
- Keep the first line under 72 characters
- Reference issues/PRs in footer when applicable

## Technical Configuration

- **minSdk**: 24
- **compileSdk**: 36
- **JVM Target**: 17 (Java 17)
- **Kotlin Compose Compiler**: Version 1.5.4
- **Material 3**: Full Material Design 3 support

## Important Files

- `ui-kit/build.gradle.kts` - Library module configuration, publishing setup
- `settings.gradle.kts` - Multi-module project configuration
- `README.md` - User-facing documentation with installation instructions

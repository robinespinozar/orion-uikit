package com.raerossi.orion.uikit.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.raerossi.orion.ui_kit.spacers.VerticalSpacer
import com.raerossi.orion.ui_kit.tiles.Tile
import com.raerossi.orion.ui_kit.tiles.TileMode
import com.raerossi.orion.uikit.ui.theme.OrionUiKitTheme

@PreviewLightDark
@Composable
private fun TilePreview() {
    OrionUiKitTheme {
        Column {
            Text("1. Compact (wrap content)", style = MaterialTheme.typography.bodySmall)
            Tile(
                mode = TileMode.Compact,
                content = {
                    Text(
                        text = "Tile Example",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                containerColor = MaterialTheme.colorScheme.surface,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                },
                onClick = { }
            )
            VerticalSpacer(24)
            Text("2. Compact (fill max width)", style = MaterialTheme.typography.bodySmall)
            Tile(
                modifier = Modifier.fillMaxWidth(),
                mode = TileMode.Compact,
                content = {
                    Text(
                        text = "Tile Example",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                containerColor = MaterialTheme.colorScheme.surface,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                },
                onClick = { }
            )
            VerticalSpacer(24)
            Text(
                "3. Expanded (wrap content - behaves like Compact)",
                style = MaterialTheme.typography.bodySmall
            )
            Tile(
                mode = TileMode.Expanded,
                content = {
                    Text(
                        text = "Tile Example",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                containerColor = MaterialTheme.colorScheme.surface,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                },
                onClick = { }
            )
            VerticalSpacer(24)
            Text("4. Expanded (fill max width)", style = MaterialTheme.typography.bodySmall)
            Tile(
                modifier = Modifier.fillMaxWidth(),
                mode = TileMode.Expanded,
                content = {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Tile Example Tile Example Tile Example Tile Example Tile Example",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                containerColor = MaterialTheme.colorScheme.surface,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    /*Row {
                        Spacer(Modifier.weight(1f))*/
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    //}
                },
                onClick = { }
            )
        }
    }
}
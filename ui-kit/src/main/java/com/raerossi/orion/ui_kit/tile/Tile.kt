package com.raerossi.orion.ui_kit.tile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Componente Tile clickeable con iconos opcionales.
 *
 * @param modifier Modificador del Tile
 * @param content Contenido principal (requerido)
 * @param leadingIcon Icono opcional al inicio
 * @param leadIconSpacing Espaciado del leading icon
 * @param trailingIcon Icono opcional al final
 * @param trailIconSpacing Espaciado del trailing icon
 * @param containerColor Color de fondo del Tile
 * @param onClick Acción al hacer click en el Tile
 */
@Composable
fun Tile(
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit),
    contentPadding: PaddingValues = TileDefaults.ContentPadding,
    mode: TileMode = TileMode.Compact,
    leadingIcon: @Composable (() -> Unit)? = null,
    leadIconSpacing: Dp = TileDefaults.iconSpacing,
    trailingIcon: @Composable (() -> Unit)? = null,
    trailIconSpacing: Dp = TileDefaults.iconSpacing,
    containerColor: Color = Color.Transparent,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(containerColor)
            .clickable(onClick = onClick)
            .padding(contentPadding)
            .semantics { role = Role.Button },
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingIcon?.let {
            it()
            Spacer(modifier = Modifier.width(leadIconSpacing))
        }

        content()

        trailingIcon?.let {
            Spacer(modifier = Modifier.width(trailIconSpacing))
            it()
        }
    }
}

@Preview
@Composable
private fun TilePreview() {
    Tile(
        content = {
            Text(
                text = "Tile Example",
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        containerColor = Color.White,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.Blue.copy(alpha = 0.55f)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Magenta.copy(alpha = 0.35f)
            )
        },
        onClick = { }
    )
}

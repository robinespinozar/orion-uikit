package com.raerossi.orion.ui_kit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * BaseButton - Componente de botón base personalizado
 *
 * @param modifier Modificador para el botón
 * @param label Texto que se muestra en el botón
 * @param enabled Si el botón está habilitado
 * @param isLoading Si el botón está en estado de carga
 * @param style Estilo del texto
 * @param shape Forma del botón
 * @param colors Colores del botón
 * @param elevation Elevación del botón
 * @param border Borde del botón
 * @param contentPadding Padding del contenido
 * @param interactionSource Fuente de interacciones
 * @param leadingIcon Icono al inicio del botón (opcional)
 * @param trailingIcon Icono al final del botón (opcional)
 * @param onClick Callback cuando se hace click
 */
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: TextStyle = LocalTextStyle.current,
    shape: Shape = BaseButtonDefaults.shape,
    colors: ButtonColors = BaseButtonDefaults.colors,
    elevation: ButtonElevation? = BaseButtonDefaults.elevation,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = BaseButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    leadIconSpacing: Dp = BaseButtonDefaults.iconSpacing,
    trailingIcon: @Composable (() -> Unit)? = null,
    trailIconSpacing: Dp = BaseButtonDefaults.iconSpacing,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        enabled = enabled && !isLoading,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource
    ) {
        if (isLoading) {
            LoadingBaseButtonContent()
        } else {
            BaseButtonContent(
                label = label,
                style = style,
                leadIconSpacing = leadIconSpacing,
                trailIconSpacing = trailIconSpacing,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon
            )
        }
    }
}

@Composable
private fun LoadingBaseButtonContent() {
    CircularProgressIndicator(
        modifier = Modifier
            .size(20.dp)
            .testTag("loading_indicator"),
        strokeWidth = 2.dp
    )
}

@Composable
private fun BaseButtonContent(
    label: String,
    style: TextStyle,
    leadIconSpacing: Dp,
    trailIconSpacing: Dp,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    leadingIcon?.let {
        it()
        Spacer(modifier = Modifier.width(leadIconSpacing))
    }
    Text(
        text = label,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = style
    )
    trailingIcon?.let {
        Spacer(modifier = Modifier.width(trailIconSpacing))
        it()
    }
}

@Preview
@Composable
private fun BaseButtonPreview() {
    Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
        BaseButton(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            label = "Label",
            enabled = true,
            onClick = { /*TODO*/ }
        )
    }
}
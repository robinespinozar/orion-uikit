package com.raerossi.orion.ui_kit.buttons.gradient_button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButton
import com.raerossi.orion.ui_kit.buttons.base_button.BaseButtonDefaults

/**
 * GradientButton - Componente de botón con fondo de gradiente (Brush)
 *
 * @param modifier Modificador para el botón. NOTA: Si contiene background, puede interferir con el brush
 * @param label Texto que se muestra en el botón
 * @param brush Gradiente que se aplica al fondo del botón
 * @param enabled Si el botón está habilitado (el brush solo se aplica cuando está habilitado)
 * @param shape Forma del botón (también se aplica al brush)
 * @param colors Colores del botón (heredado de ButtonDefaults)
 * @param contentPadding Padding del contenido
 * @param interactionSource Fuente de interacciones
 * @param leadingIcon Icono al inicio del botón (opcional)
 * @param trailingIcon Icono al final del botón (opcional)
 * @param onClick Callback cuando se hace click
 */
@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: TextStyle = LocalTextStyle.current,
    shape: Shape = GradientButtonDefaults.shape,
    colors: GradientButtonColors = GradientButtonDefaults.colors(),
    elevation: ButtonElevation? = GradientButtonDefaults.elevation,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = GradientButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    leadIconSpacing: Dp = GradientButtonDefaults.iconSpacing,
    trailingIcon: @Composable (() -> Unit)? = null,
    trailIconSpacing: Dp = GradientButtonDefaults.iconSpacing,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = if (enabled && !isLoading) {
            Modifier
                .background(brush = colors.copy().brushContainerColor, shape = shape)
                .then(modifier)
        } else {
            modifier
        },
        label = label,
        enabled = enabled && !isLoading,
        isLoading = isLoading,
        style = style,
        elevation = elevation,
        border = border,
        shape = shape,
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.copy().contentColor,
            disabledContainerColor = colors.copy().disabledContainerColor,
            disabledContentColor = colors.copy().disabledContentColor
        ),
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        leadingIcon = leadingIcon,
        leadIconSpacing = leadIconSpacing,
        trailingIcon = trailingIcon,
        trailIconSpacing = trailIconSpacing,
        onClick = onClick
    )
}

@Preview
@Composable
private fun GradientButtonPreview() {
    Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
        GradientButton(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            colors = GradientButtonDefaults.colors().copy(
                brushContainerColor = Brush.verticalGradient(
                    colors = listOf(Color(0xFF6915B3), Color(0xFFA814E7))
                )
            ),
            label = "Vertical Gradient Button",
            onClick = {}
        )
    }
}
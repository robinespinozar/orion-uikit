package com.raerossi.orion.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape

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
    brush: Brush,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = if (enabled) modifier.background(brush = brush, shape = shape) else modifier,
        label = label,
        enabled = enabled,
        shape = shape,
        colors = colors,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        onClick = onClick
    )
}
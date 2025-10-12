package com.raerossi.orion.ui_kit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle

/**
 * BaseButton - Componente de botón base personalizado
 * 
 * Este es un STUB que debe ser implementado siguiendo TDD.
 * Los tests en BaseButtonTest.kt definen el comportamiento esperado.
 * 
 * Requisitos a implementar:
 * - Mostrar el label
 * - Ser clickeable cuando enabled=true
 * - No ser clickeable cuando enabled=false o isLoading=true
 * - Mostrar iconos leading y trailing cuando se proporcionan
 * - Mostrar CircularProgressIndicator cuando isLoading=true
 * - Ocultar contenido (label e iconos) cuando isLoading=true
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
    style: TextStyle = MaterialTheme.typography.labelLarge,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    // TODO: Implementar el componente siguiendo los tests en BaseButtonTest.kt
    // 
    // Pistas para la implementación:
    // 1. Usar Button de Material3 como base
    // 2. Dentro del Button, usar Row para organizar: leadingIcon, Text(label), trailingIcon
    // 3. Cuando isLoading=true:
    //    - Mostrar CircularProgressIndicator con Modifier.testTag("loading_indicator")
    //    - Ocultar el Row con el contenido
    //    - Deshabilitar el botón (enabled = false)
    // 4. Cuando isLoading=false:
    //    - Mostrar el contenido normal (Row con iconos y label)
    //    - Respetar el valor de enabled
    
    throw NotImplementedError(
        "BaseButton debe ser implementado. Consulta los tests en BaseButtonTest.kt para ver el comportamiento esperado."
    )
}
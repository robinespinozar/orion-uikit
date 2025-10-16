package com.raerossi.orion.ui_kit.tile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object TileDefaults {

    private val TileLeadingSpace = 16.dp
    private val TileTrailingSpace = 16.dp
    private val TileVerticalPadding = 12.dp

    val iconSpacing: Dp = 16.dp

    val ContentPadding: PaddingValues = PaddingValues(
        start = TileLeadingSpace,
        top = TileVerticalPadding,
        end = TileTrailingSpace,
        bottom = TileVerticalPadding
    )
}
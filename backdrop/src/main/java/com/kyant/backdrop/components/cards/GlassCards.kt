package com.kyant.backdrop.components.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.glass.GlassStyle
import com.kyant.backdrop.glass.adaptiveGlass

@Composable
fun GlassCard(
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    style: GlassStyle = GlassStyle.Regular,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .adaptiveGlass(
                backdrop = backdrop,
                shape = RoundedCornerShape(24.dp),
                style = style
            )
            .padding(16.dp),
        content = content
    )
}

@Composable
fun GlassWalletCard(
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .adaptiveGlass(
                backdrop = backdrop,
                shape = RoundedCornerShape(16.dp),
                style = GlassStyle.Thick
            )
            .padding(24.dp),
        content = content
    )
}

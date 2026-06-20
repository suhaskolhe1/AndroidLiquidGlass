package com.kyant.backdrop.components.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.glass.GlassStyle
import com.kyant.backdrop.glass.adaptiveGlass

@Composable
fun GlassButton(
    onClick: () -> Unit,
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    style: GlassStyle = GlassStyle.Light,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .adaptiveGlass(
                backdrop = backdrop,
                shape = RoundedCornerShape(percent = 50),
                style = style
            )
            .clickable(onClick = onClick, role = Role.Button)
            .height(48.dp)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Composable
fun GlassIconButton(
    onClick: () -> Unit,
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    style: GlassStyle = GlassStyle.Light,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .adaptiveGlass(
                backdrop = backdrop,
                shape = CircleShape,
                style = style
            )
            .clickable(onClick = onClick, role = Role.Button),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

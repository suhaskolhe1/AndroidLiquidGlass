package com.kyant.backdrop.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.glass.GlassStyle
import com.kyant.backdrop.glass.adaptiveGlass

@Composable
fun GlassBottomBar(
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    style: GlassStyle = GlassStyle.Regular,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(64.dp)
            .adaptiveGlass(
                backdrop = backdrop,
                shape = RoundedCornerShape(32.dp),
                style = style
            )
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Composable
fun GlassTopBar(
    title: @Composable () -> Unit,
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    style: GlassStyle = GlassStyle.Regular
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .adaptiveGlass(
                backdrop = backdrop,
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                style = style
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (navigationIcon != null) {
            navigationIcon()
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            title()
        }
        actions()
    }
}

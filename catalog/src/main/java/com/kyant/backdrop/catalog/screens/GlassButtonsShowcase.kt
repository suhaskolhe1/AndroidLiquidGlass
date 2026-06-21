package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.buttons.GlassButton
import com.kyant.backdrop.components.buttons.GlassIconButton
import com.kyant.backdrop.glass.GlassStyle

@Composable
fun GlassButtonsShowcase(backdrop: Backdrop) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            BasicText("Glass Buttons Showcase", style = TextStyle(color = Color.White, fontSize = 24.sp))
        }

        item {
             BasicText("Light Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassButton(onClick = {}, backdrop = backdrop, style = GlassStyle.Light, modifier = Modifier.fillMaxWidth()) {
                  BasicText("Action", style = TextStyle(color = Color.White))
             }
        }

        item {
             BasicText("Regular Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassButton(onClick = {}, backdrop = backdrop, style = GlassStyle.Regular, modifier = Modifier.fillMaxWidth()) {
                  BasicText("Action", style = TextStyle(color = Color.White))
             }
        }

        item {
             BasicText("Thick Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassButton(onClick = {}, backdrop = backdrop, style = GlassStyle.Thick, modifier = Modifier.fillMaxWidth()) {
                  BasicText("Action", style = TextStyle(color = Color.White))
             }
        }

        item {
             BasicText("Icon Buttons", style = TextStyle(color = Color.White, fontSize = 16.sp))
             Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                 GlassIconButton(onClick = {}, backdrop = backdrop, style = GlassStyle.Light) {
                      BasicText("A", style = TextStyle(color = Color.White))
                 }
                 GlassIconButton(onClick = {}, backdrop = backdrop, style = GlassStyle.Regular) {
                      BasicText("B", style = TextStyle(color = Color.White))
                 }
                 GlassIconButton(onClick = {}, backdrop = backdrop, style = GlassStyle.Thick) {
                      BasicText("C", style = TextStyle(color = Color.White))
                 }
             }
        }
    }
}

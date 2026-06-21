package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.inputs.GlassTextField
import com.kyant.backdrop.glass.GlassStyle

@Composable
fun GlassInputsShowcase(backdrop: Backdrop) {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            BasicText("Glass Inputs Showcase", style = TextStyle(color = Color.White, fontSize = 24.sp))
        }

        item {
             BasicText("Light Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassTextField(
                 value = text1,
                 onValueChange = { text1 = it },
                 backdrop = backdrop,
                 style = GlassStyle.Light,
                 placeholder = { BasicText("Search...", style = TextStyle(color = Color.White.copy(0.5f))) }
             )
        }

        item {
             BasicText("Regular Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassTextField(
                 value = text2,
                 onValueChange = { text2 = it },
                 backdrop = backdrop,
                 style = GlassStyle.Regular,
                 placeholder = { BasicText("Amount...", style = TextStyle(color = Color.White.copy(0.5f))) }
             )
        }

        item {
             BasicText("Thick Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassTextField(
                 value = text3,
                 onValueChange = { text3 = it },
                 backdrop = backdrop,
                 style = GlassStyle.Thick,
                 placeholder = { BasicText("Password...", style = TextStyle(color = Color.White.copy(0.5f))) }
             )
        }
    }
}

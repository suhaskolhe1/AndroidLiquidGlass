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
import com.kyant.backdrop.components.navigation.GlassBottomBar
import com.kyant.backdrop.components.navigation.GlassTopBar
import com.kyant.backdrop.glass.GlassStyle

@Composable
fun GlassNavigationShowcase(backdrop: Backdrop) {
    LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
             GlassTopBar(
                 title = { BasicText("Glass Navigation Showcase", style = TextStyle(color = Color.White, fontSize = 20.sp)) },
                 backdrop = backdrop,
                 style = GlassStyle.Thick
             )
        }

        item {
             Spacer(Modifier.height(32.dp))
             BasicText("Top Bar Variants", style = TextStyle(color = Color.White, fontSize = 16.sp), modifier = Modifier.padding(16.dp))

             GlassTopBar(
                 title = { BasicText("Light Style", style = TextStyle(color = Color.White)) },
                 backdrop = backdrop,
                 style = GlassStyle.Light
             )
             Spacer(Modifier.height(16.dp))
             GlassTopBar(
                 title = { BasicText("Regular Style", style = TextStyle(color = Color.White)) },
                 backdrop = backdrop,
                 style = GlassStyle.Regular
             )
        }

        item {
             Spacer(Modifier.height(32.dp))
             BasicText("Bottom Bar Variants", style = TextStyle(color = Color.White, fontSize = 16.sp), modifier = Modifier.padding(16.dp))

             GlassBottomBar(backdrop = backdrop, style = GlassStyle.Light) {
                  BasicText("Home", style = TextStyle(color = Color.White))
                  BasicText("Search", style = TextStyle(color = Color.White))
                  BasicText("Profile", style = TextStyle(color = Color.White))
             }
             Spacer(Modifier.height(16.dp))
             GlassBottomBar(backdrop = backdrop, style = GlassStyle.Regular) {
                  BasicText("Home", style = TextStyle(color = Color.White))
                  BasicText("Search", style = TextStyle(color = Color.White))
                  BasicText("Profile", style = TextStyle(color = Color.White))
             }
             Spacer(Modifier.height(16.dp))
             GlassBottomBar(backdrop = backdrop, style = GlassStyle.Thick) {
                  BasicText("Home", style = TextStyle(color = Color.White))
                  BasicText("Search", style = TextStyle(color = Color.White))
                  BasicText("Profile", style = TextStyle(color = Color.White))
             }
             Spacer(Modifier.height(64.dp))
        }
    }
}

package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.cards.GlassCard
import com.kyant.backdrop.components.cards.GlassWalletCard
import com.kyant.backdrop.glass.GlassStyle

@Composable
fun GlassCardsShowcase(backdrop: Backdrop) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            BasicText("Glass Cards Showcase", style = TextStyle(color = Color.White, fontSize = 24.sp))
        }

        item {
             BasicText("Light Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassCard(backdrop = backdrop, style = GlassStyle.Light, modifier = Modifier.fillMaxWidth().height(100.dp)) {}
        }

        item {
             BasicText("Regular Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassCard(backdrop = backdrop, style = GlassStyle.Regular, modifier = Modifier.fillMaxWidth().height(100.dp)) {}
        }

        item {
             BasicText("Thick Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassCard(backdrop = backdrop, style = GlassStyle.Thick, modifier = Modifier.fillMaxWidth().height(100.dp)) {}
        }

        item {
             BasicText("UltraThin Style", style = TextStyle(color = Color.White, fontSize = 16.sp))
             GlassCard(backdrop = backdrop, style = GlassStyle.UltraThin, modifier = Modifier.fillMaxWidth().height(100.dp)) {}
        }

        item {
            BasicText("Glass Wallet Card", style = TextStyle(color = Color.White, fontSize = 16.sp))
            GlassWalletCard(backdrop = backdrop, modifier = Modifier.fillMaxWidth().height(150.dp)) {
                 Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                      BasicText("VISA", style = TextStyle(color = Color.White, fontSize = 24.sp))
                 }
            }
        }
    }
}

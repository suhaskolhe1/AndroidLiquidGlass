package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.cards.GlassCard
import com.kyant.backdrop.components.navigation.GlassTopBar

@Composable
fun FinanceDashboardScreen(backdrop: Backdrop) {
    Column(modifier = Modifier.fillMaxSize()) {
        GlassTopBar(
            title = {
                Box(Modifier.size(150.dp, 24.dp).background(Color.White.copy(alpha=0.5f)))
            },
            backdrop = backdrop
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    GlassCard(backdrop = backdrop, modifier = Modifier.weight(1f).height(120.dp)) {
                         Box(Modifier.size(80.dp, 16.dp).background(Color.White.copy(alpha=0.3f)))
                    }
                    GlassCard(backdrop = backdrop, modifier = Modifier.weight(1f).height(120.dp)) {
                         Box(Modifier.size(80.dp, 16.dp).background(Color.White.copy(alpha=0.3f)))
                    }
                }
            }
            item {
                GlassCard(backdrop = backdrop, modifier = Modifier.fillMaxWidth().height(250.dp)) {
                     Box(Modifier.size(100.dp, 20.dp).background(Color.White.copy(alpha=0.3f)))
                }
            }
            items(5) {
                 GlassCard(backdrop = backdrop, modifier = Modifier.fillMaxWidth().height(80.dp)) {
                     Box(Modifier.size(200.dp, 16.dp).background(Color.White.copy(alpha=0.3f)))
                 }
            }
        }
    }
}

package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.cards.GlassWalletCard
import com.kyant.backdrop.components.navigation.GlassTopBar
import com.kyant.backdrop.performance.TrackGlassPerformance

@Composable
fun WalletScreen(backdrop: Backdrop) {
    TrackGlassPerformance()
    Column(modifier = Modifier.fillMaxSize()) {
        GlassTopBar(
            title = {
                // Simplified Title
                Box(Modifier.size(100.dp, 24.dp).background(Color.White.copy(alpha=0.5f)))
            },
            backdrop = backdrop
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(3) {
                GlassWalletCard(
                    backdrop = backdrop,
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
                         Box(Modifier.size(100.dp, 24.dp).background(Color.White.copy(alpha=0.3f)))
                    }
                }
            }
        }
    }
}

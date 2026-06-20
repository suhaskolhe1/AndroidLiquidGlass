package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.cards.GlassCard
import com.kyant.backdrop.components.navigation.GlassTopBar

@Composable
fun ProfileScreen(backdrop: Backdrop) {
    Column(modifier = Modifier.fillMaxSize()) {
        GlassTopBar(
            title = {
                Box(Modifier.size(80.dp, 24.dp).background(Color.White.copy(alpha=0.5f)))
            },
            backdrop = backdrop
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.5f))
                )
                Spacer(Modifier.height(16.dp))
                Box(Modifier.size(150.dp, 24.dp).background(Color.White.copy(alpha=0.5f)))
                Spacer(Modifier.height(8.dp))
                Box(Modifier.size(200.dp, 16.dp).background(Color.White.copy(alpha=0.3f)))
                Spacer(Modifier.height(32.dp))
            }

            items(4) {
                 GlassCard(backdrop = backdrop, modifier = Modifier.fillMaxWidth().height(80.dp)) {
                     Box(Modifier.size(100.dp, 16.dp).background(Color.White.copy(alpha=0.3f)))
                 }
            }
        }
    }
}

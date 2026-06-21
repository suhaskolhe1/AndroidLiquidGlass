package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.buttons.GlassButton
import com.kyant.backdrop.components.cards.GlassCard
import com.kyant.backdrop.components.inputs.GlassTextField
import com.kyant.backdrop.components.navigation.GlassTopBar

@Composable
fun ExpenseTrackerScreen(backdrop: Backdrop) {
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
                GlassCard(backdrop = backdrop, modifier = Modifier.fillMaxWidth()) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        GlassTextField(
                            value = "",
                            onValueChange = {},
                            backdrop = backdrop,
                            placeholder = { Box(Modifier.size(100.dp, 16.dp).background(Color.White.copy(alpha=0.2f))) }
                        )
                        GlassTextField(
                            value = "",
                            onValueChange = {},
                            backdrop = backdrop,
                            placeholder = { Box(Modifier.size(100.dp, 16.dp).background(Color.White.copy(alpha=0.2f))) }
                        )
                        GlassButton(
                            onClick = {},
                            backdrop = backdrop,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(Modifier.size(60.dp, 16.dp).background(Color.White.copy(alpha=0.5f)))
                        }
                    }
                }
            }
        }
    }
}

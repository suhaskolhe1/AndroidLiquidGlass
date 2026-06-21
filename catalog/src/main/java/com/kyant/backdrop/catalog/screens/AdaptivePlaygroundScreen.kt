package com.kyant.backdrop.catalog.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicText
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.components.cards.GlassCard
import com.kyant.backdrop.glass.GlassStyle
import com.kyant.backdrop.performance.DeviceCapability
import com.kyant.backdrop.performance.GlassPerformanceLevel

@Composable
fun AdaptivePlaygroundScreen(backdrop: Backdrop) {
    var performanceLevel by remember { mutableStateOf(DeviceCapability.manualOverride ?: GlassPerformanceLevel.High) }

    // Tweakable style parameters
    var blurRadius by remember { mutableFloatStateOf(24f) }
    var transparency by remember { mutableFloatStateOf(0.6f) }
    var borderAlpha by remember { mutableFloatStateOf(0.3f) }

    val currentStyle = GlassStyle(
        blurRadius = blurRadius.dp,
        transparency = transparency,
        saturation = 1.2f,
        borderAlpha = borderAlpha,
        noiseAlpha = 0f,
        shadowDepth = 8.dp,
        fallbackColor = Color.White.copy(alpha = 0.8f)
    )

    // Ensure we trigger a recomposition dynamically
    val backdropState = remember(performanceLevel) { Any() }

    // Override the capability in the whole tree safely
    DisposableEffect(performanceLevel) {
        DeviceCapability.manualOverride = performanceLevel
        onDispose {
            DeviceCapability.manualOverride = null
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        BasicText(
            "Adaptive Playground",
            style = TextStyle(color = Color.White, fontSize = 24.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LevelButton(
                level = GlassPerformanceLevel.Low,
                currentLevel = performanceLevel,
                onClick = { performanceLevel = GlassPerformanceLevel.Low }
            )
            LevelButton(
                level = GlassPerformanceLevel.Medium,
                currentLevel = performanceLevel,
                onClick = { performanceLevel = GlassPerformanceLevel.Medium }
            )
            LevelButton(
                level = GlassPerformanceLevel.High,
                currentLevel = performanceLevel,
                onClick = { performanceLevel = GlassPerformanceLevel.High }
            )
        }

        Spacer(Modifier.height(16.dp))

        // Big Preview Card
        GlassCard(
            backdrop = backdrop,
            style = currentStyle,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        ) {
             Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                  BasicText("Preview Card", style = TextStyle(color = Color.White, fontSize = 18.sp))
             }
        }

        Spacer(Modifier.height(32.dp))

        // Settings Mock
        BasicText(
            "Modify Properties (High Level Only)",
            style = TextStyle(color = Color.White, fontSize = 16.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
             BasicText("Blur: ${blurRadius.toInt()}dp", style = TextStyle(color = Color.White), modifier = Modifier.weight(1f))
             BasicText("+", Modifier.clickable { blurRadius += 4f }.padding(8.dp).background(Color.White.copy(0.2f)), style = TextStyle(color = Color.White))
             Spacer(Modifier.width(8.dp))
             BasicText("-", Modifier.clickable { blurRadius = (blurRadius - 4f).coerceAtLeast(0f) }.padding(8.dp).background(Color.White.copy(0.2f)), style = TextStyle(color = Color.White))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
             BasicText("Transparency: ${(transparency*100).toInt()}%", style = TextStyle(color = Color.White), modifier = Modifier.weight(1f))
             BasicText("+", Modifier.clickable { transparency = (transparency + 0.1f).coerceAtMost(1f) }.padding(8.dp).background(Color.White.copy(0.2f)), style = TextStyle(color = Color.White))
             Spacer(Modifier.width(8.dp))
             BasicText("-", Modifier.clickable { transparency = (transparency - 0.1f).coerceAtLeast(0f) }.padding(8.dp).background(Color.White.copy(0.2f)), style = TextStyle(color = Color.White))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
             BasicText("Border Alpha: ${(borderAlpha*100).toInt()}%", style = TextStyle(color = Color.White), modifier = Modifier.weight(1f))
             BasicText("+", Modifier.clickable { borderAlpha = (borderAlpha + 0.1f).coerceAtMost(1f) }.padding(8.dp).background(Color.White.copy(0.2f)), style = TextStyle(color = Color.White))
             Spacer(Modifier.width(8.dp))
             BasicText("-", Modifier.clickable { borderAlpha = (borderAlpha - 0.1f).coerceAtLeast(0f) }.padding(8.dp).background(Color.White.copy(0.2f)), style = TextStyle(color = Color.White))
        }
    }
}

@Composable
private fun LevelButton(level: GlassPerformanceLevel, currentLevel: GlassPerformanceLevel, onClick: () -> Unit) {
    val isSelected = level == currentLevel
    val color = if (isSelected) Color(0xFF0088FF) else Color.White.copy(alpha = 0.2f)
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        BasicText(level.name, style = TextStyle(color = Color.White))
    }
}

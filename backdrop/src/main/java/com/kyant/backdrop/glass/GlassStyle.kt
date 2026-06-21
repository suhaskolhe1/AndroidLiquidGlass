package com.kyant.backdrop.glass

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class GlassStyle(
    val blurRadius: Dp,
    val transparency: Float,
    val saturation: Float,
    val borderAlpha: Float,
    val noiseAlpha: Float,
    val shadowDepth: Dp,
    val fallbackColor: Color
) {
    companion object {
        val Light = GlassStyle(
            blurRadius = 16.dp,
            transparency = 0.8f,
            saturation = 1.2f,
            borderAlpha = 0.2f,
            noiseAlpha = 0.05f,
            shadowDepth = 4.dp,
            fallbackColor = Color(0xFFFFFFFF).copy(alpha = 0.9f)
        )

        val Regular = GlassStyle(
            blurRadius = 24.dp,
            transparency = 0.6f,
            saturation = 1.3f,
            borderAlpha = 0.3f,
            noiseAlpha = 0.08f,
            shadowDepth = 8.dp,
            fallbackColor = Color(0xFFE0E0E0).copy(alpha = 0.85f)
        )

        val Thick = GlassStyle(
            blurRadius = 40.dp,
            transparency = 0.4f,
            saturation = 1.5f,
            borderAlpha = 0.4f,
            noiseAlpha = 0.1f,
            shadowDepth = 16.dp,
            fallbackColor = Color(0xFFBDBDBD).copy(alpha = 0.8f)
        )

        val UltraThin = GlassStyle(
            blurRadius = 8.dp,
            transparency = 0.9f,
            saturation = 1.1f,
            borderAlpha = 0.1f,
            noiseAlpha = 0.02f,
            shadowDepth = 2.dp,
            fallbackColor = Color(0xFFFFFFFF).copy(alpha = 0.95f)
        )
    }
}

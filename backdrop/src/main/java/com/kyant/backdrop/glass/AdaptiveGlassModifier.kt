package com.kyant.backdrop.glass

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.colorControls
import com.kyant.backdrop.performance.DeviceCapability
import com.kyant.backdrop.performance.GlassPerformanceLevel

@Composable
fun Modifier.adaptiveGlass(
    backdrop: Backdrop,
    shape: Shape,
    style: GlassStyle = GlassStyle.Regular,
    color: Color = Color.Unspecified
): Modifier = composed {
    val context = LocalContext.current
    val performanceLevel = DeviceCapability.getPerformanceLevel(context)

    when (performanceLevel) {
        GlassPerformanceLevel.High -> {
            this.drawBackdrop(
                backdrop = backdrop,
                shape = { shape },
                effects = {
                    colorControls(saturation = style.saturation)
                    blur(style.blurRadius.toPx())
                },
                onDrawSurface = {
                    if (color != Color.Unspecified) {
                        drawRect(color, blendMode = BlendMode.SrcOver)
                    }
                    drawRect(Color.White.copy(alpha = 1f - style.transparency), blendMode = BlendMode.SrcOver)
                    // Highlight/Border

                    val outline = shape.createOutline(size, layoutDirection, this)
                    drawOutline(
                        outline = outline,
                        color = Color.White.copy(alpha = style.borderAlpha),
                        style = Stroke(width = 1.dp.toPx())
                    )
                }
            )
        }
        GlassPerformanceLevel.Medium -> {
             this.drawBackdrop(
                backdrop = backdrop,
                shape = { shape },
                effects = {
                    blur(style.blurRadius.toPx() / 2f) // Reduced blur
                },
                onDrawSurface = {
                    if (color != Color.Unspecified) {
                         drawRect(color, blendMode = BlendMode.SrcOver)
                    }
                    drawRect(Color.White.copy(alpha = 1f - style.transparency), blendMode = BlendMode.SrcOver)

                    val outline = shape.createOutline(size, layoutDirection, this)
                    drawOutline(
                        outline = outline,
                        color = Color.White.copy(alpha = style.borderAlpha),
                        style = Stroke(width = 1.dp.toPx())
                    )
                }
            )
        }
        GlassPerformanceLevel.Low -> {
            // Simulated glass using gradients and cache
            this.drawWithCache {
                val gradientBrush = Brush.linearGradient(
                    colors = listOf(
                        style.fallbackColor.copy(alpha = (style.fallbackColor.alpha * 1.2f).coerceAtMost(1f)),
                        style.fallbackColor
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, size.height)
                )

                val outline = shape.createOutline(size, layoutDirection, this)

                onDrawWithContent {
                    drawOutline(
                        outline = outline,
                        brush = gradientBrush
                    )

                    drawContent()

                    drawOutline(
                        outline = outline,
                        color = Color.White.copy(alpha = style.borderAlpha),
                        style = Stroke(width = 1.dp.toPx())
                    )
                }
            }
        }
    }
}

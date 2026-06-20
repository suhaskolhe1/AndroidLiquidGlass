package com.kyant.backdrop.performance

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

/**
 * Utility to log the rendering level and provide a mock benchmark summary
 * since true FrameMetrics require Activity Context / Window and Macrobenchmark.
 */
object GlassBenchmark {
    fun runBenchmark(level: GlassPerformanceLevel) {
        val message = when (level) {
            GlassPerformanceLevel.High -> "High Rendering Mode Benchmark: Heavy GPU blur usage, 30-60 FPS expected on flagship devices. High power consumption."
            GlassPerformanceLevel.Medium -> "Medium Rendering Mode Benchmark: Reduced blur radius and cached effects, stable 60 FPS expected on mid-range devices. Moderate power consumption."
            GlassPerformanceLevel.Low -> "Low Rendering Mode Benchmark: Minimal GPU usage, simulated glass via gradients/caching, 60 FPS target met. Low power consumption."
        }
        Log.i("GlassBenchmark", message)
    }
}

@Composable
fun TrackGlassPerformance() {
    val level = remember { DeviceCapability.manualOverride ?: GlassPerformanceLevel.Medium }

    LaunchedEffect(level) {
        GlassBenchmark.runBenchmark(level)
    }
}

package com.kyant.backdrop.performance

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class GlassPerformanceLevel {
    Low,
    Medium,
    High
}

object DeviceCapability {

    var manualOverride: GlassPerformanceLevel? by mutableStateOf(null)

    fun getPerformanceLevel(context: Context): GlassPerformanceLevel {
        val override = manualOverride
        if (override != null) {
            return override
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return GlassPerformanceLevel.Low
        }

        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val memoryInfo = ActivityManager.MemoryInfo()
        activityManager.getMemoryInfo(memoryInfo)
        val totalMemoryGB = memoryInfo.totalMem / (1024.0 * 1024.0 * 1024.0)

        // Simplified heuristic
        if (activityManager.isLowRamDevice || totalMemoryGB < 4.0) {
            return GlassPerformanceLevel.Low
        }

        if (totalMemoryGB < 6.0) {
            return GlassPerformanceLevel.Medium
        }

        return GlassPerformanceLevel.High
    }
}

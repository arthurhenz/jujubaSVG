package com.gabrielbmoro.sampleapp.scenarios

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.gabrielbmoro.jujubasvg.core.JujubaSVG
import com.gabrielbmoro.jujubasvg.core.commander.Command
import com.gabrielbmoro.jujubasvg.core.rememberJujubaCommander
import com.gabrielbmoro.sample.R
import kotlinx.coroutines.launch
import kotlin.random.Random

internal class ChangeColor {
    @Preview(group = "Change Color", name = "Change Element Color")
    @Composable
    internal fun ChangeElementBackgroundColor() {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            val jujubaCommander = rememberJujubaCommander()
            val coroutineScope = rememberCoroutineScope()

            JujubaSVG(
                svgRawRes = R.raw.shapes,
                onElementClick = { nodeInfo ->
                    println("NodeInfo $nodeInfo")
                    coroutineScope.launch {
                        jujubaCommander.execute(
                            Command.UpdateBackgroundColor(nodeInfo.id, getRandomColor())
                        )
                    }
                },
                commander = jujubaCommander,
                backgroundColor = Color(0xffffb700),
            )
        }
    }

    @Preview(group = "Change Color", name = "Change Root Background Color")
    @Composable
    internal fun ChangeRootBackgroundColor() {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            val jujubaCommander = rememberJujubaCommander()
            val coroutineScope = rememberCoroutineScope()

            JujubaSVG(
                svgRawRes = R.raw.shapes,
                onElementClick = { nodeInfo ->
                    println("NodeInfo $nodeInfo")
                    coroutineScope.launch {
                        jujubaCommander.execute(
                            Command.UpdateRootBackgroundColor(getRandomColor())
                        )
                    }
                },
                commander = jujubaCommander,
                backgroundColor = Color(0xffffb700),
            )
        }
    }

    private fun getRandomColor(): Color {
        val colors = listOf(
            Color(0xFFFF0000), // Red
            Color(0xFFFF7F00), // Orange
            Color(0xFFFFFF00), // Yellow
            Color(0xFF00FF00), // Green
            Color(0xFF0000FF), // Blue
            Color(0xFF4B0082), // Indigo
            Color(0xFF8B00FF)  // Violet
        )
        val randomIndex = Random.nextInt(0, 6)
        return colors[randomIndex % colors.size]
    }
}
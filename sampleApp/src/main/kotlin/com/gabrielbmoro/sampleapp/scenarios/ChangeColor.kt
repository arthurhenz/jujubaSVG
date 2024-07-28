package com.gabrielbmoro.sampleapp.scenarios

import androidx.compose.foundation.layout.fillMaxSize
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
    internal fun RemoveElement() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val jujubaCommander = rememberJujubaCommander()

            val coroutineScope = rememberCoroutineScope()

            JujubaSVG(
                svgRawRes = R.raw.brazil,
                onElementClick = { nodeInfo ->
                    println("NodeInfo $nodeInfo")
                    coroutineScope.launch {
                        jujubaCommander.execute(
                            Command.RemoveNode(nodeInfo.id)
                        )
                    }
                },
                commander = jujubaCommander,
                backgroundColorInHex = "#ffb700",
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    fun Color.getRainbowColor(): Color {
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
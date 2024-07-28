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

internal class ChangeWidth {
    @Preview(group = "Change Width", name = "Change Element Width")
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
                            Command.UpdateStrokeWidth(nodeInfo.id, 50)
                        )
                    }
                },
                commander = jujubaCommander,
                backgroundColor = Color(0xffffb700),
            )
        }
    }
}
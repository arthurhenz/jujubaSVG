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

internal class RemoveElement {
    @Preview(group = "Remove Element", name = "Remove Element")
    @Composable
    internal fun ChangeRootBackgroundColor() {
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
                backgroundColor = Color(0xffffb700),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
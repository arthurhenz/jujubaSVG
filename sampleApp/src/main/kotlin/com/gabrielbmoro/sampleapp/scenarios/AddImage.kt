package com.gabrielbmoro.sampleapp.scenarios

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import com.gabrielbmoro.jujubasvg.core.JujubaSVG
import com.gabrielbmoro.jujubasvg.core.commander.Command
import com.gabrielbmoro.jujubasvg.core.rememberJujubaCommander
import com.gabrielbmoro.sample.R
import kotlinx.coroutines.launch
@Preview(group = "Add Element", name = "Add Rounded Image")
@Composable
internal fun AddImage() {
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
                        Command.AddRoundedImage(
                            elementId = nodeInfo.id,
                            imageId = "nasa",
                            imageUrl = "https://i.imgur.com/LQIsf.jpeg",
                            widthInPx = 100,
                            heightInPx = 100,
                            coordinate = nodeInfo.coordinate,
                        ),
                    )
                }
            },
            commander = jujubaCommander,
            backgroundColor = Color(0xffffb700),
            modifier = Modifier.fillMaxSize()
        )
    }
}
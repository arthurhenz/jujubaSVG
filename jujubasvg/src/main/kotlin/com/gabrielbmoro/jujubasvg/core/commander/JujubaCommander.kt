package com.gabrielbmoro.jujubasvg.core.commander

import android.util.Log
import com.gabrielbmoro.jujubasvg.core.Const.TAG
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

public class JujubaCommander {

    private val _command = MutableSharedFlow<String>()
    public val command: SharedFlow<String> = _command.asSharedFlow()

    public suspend fun execute(vararg command: Command) {
        val commandJS = command.map {
            convertToJSCode(it)
        }.reduce { acc, s -> acc.plus("\n").plus(s) }

        Log.d(TAG, "execute: $commandJS")
        _command.emit(commandJS)
    }

    private fun convertToJSCode(command: Command): String {
        return when (command) {
            is Command.UpdateBackgroundColor -> {
                "updateBackgroundColor(\'${command.id}\',\'${command.hexColor}\');"
            }

            is Command.UpdateStrokeColor -> {
                "updateStrokeColor(\'${command.id}\',\'${command.hexColor}\');"
            }

            is Command.UpdateStrokeWidth -> {
                "updateStrokeWidth(\'${command.id}\',${command.width});"
            }

            is Command.RemoveNode -> {
                "removeNode(\'${command.id}\');"
            }

            is Command.UpdateRootBackgroundColor -> {
                "updateRootBackgroundColor(\'${command.hexColor}\');"
            }

            is Command.AddRoundedImage -> {
                "addRoundedImage(" +
                        "\'${command.elementId}\'," +
                        "\'${command.imageId}\'," +
                        "\'${command.imageUrl}\'," +
                        "\'${command.width}\'," +
                        "\'${command.height}\'," +
                        "\'${command.coordinate.x}\'," +
                        "\'${command.coordinate.y}\'" +
                        ");"
            }
        }
    }
}

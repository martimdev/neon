package org.neon.api.config

import javafx.scene.input.KeyCodeCombination
import java.io.File

data class ConfigData(
        val isConsoleEnabled: Boolean?,
        val explorerWidth: Double?,
        val styleFileName: String?,
        val projectDirectory: File?,
        val keyMap: Map<String, KeyCodeCombination>?
)
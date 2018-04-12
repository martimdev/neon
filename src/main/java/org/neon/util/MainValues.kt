package org.neon.util

import javafx.geometry.Rectangle2D
import javafx.scene.layout.AnchorPane
import javafx.stage.Screen
import javafx.stage.Stage
import org.neon.api.config.ConfigData
import java.io.File

val neonDirectory = File(".neon")
val configDirectory = File("$neonDirectory/config")

val defaultConfig = loadDefaultConfig()
val userConfig: ConfigData? = loadUserConfig()
val config = mergeConfigs()

val screen: Rectangle2D = Screen.getPrimary().visualBounds
lateinit var stage: Stage
val root = AnchorPane()

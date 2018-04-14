package org.neon.util

import javafx.geometry.Rectangle2D
import javafx.scene.layout.AnchorPane
import javafx.stage.Screen
import javafx.stage.Stage
import org.neon.api.config.ConfigData
import org.neon.util.files.NeonFile
import java.io.File

val neonDirectory = File(".neon")
val configDirectory = File("$neonDirectory/config")
val pluginsDirectory = File("$neonDirectory/plugins")

val defaultConfig = loadDefaultConfig()
val userConfig: ConfigData? = loadUserConfig()
val config = mergeConfigs()

val projectDirectory = NeonFile(config.projectDirectory!!.path)

val screen: Rectangle2D = Screen.getPrimary().visualBounds
lateinit var stage: Stage
val root = AnchorPane()

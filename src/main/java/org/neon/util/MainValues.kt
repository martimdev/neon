package org.neon.util

import javafx.geometry.Rectangle2D
import javafx.scene.layout.AnchorPane
import javafx.stage.Screen
import javafx.stage.Stage
import java.io.File

val neonFolder = File(".neon")
val config = loadDefaultConfig()

val screen: Rectangle2D = Screen.getPrimary().visualBounds
lateinit var stage: Stage
val root = AnchorPane()

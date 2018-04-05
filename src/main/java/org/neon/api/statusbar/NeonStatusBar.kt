package org.neon.api.statusbar

import javafx.scene.control.ToolBar
import org.neon.Main
import org.neon.api.console.NeonConsole
import org.neon.api.explorer.NeonExplorer

object NeonStatusBar : ToolBar() {

    init {
        this.prefWidthProperty().bind(Main.scene.widthProperty())
        this.prefHeight = 17.0
        this.layoutY = Main.screen.height - this.prefHeight
        Main.stage.maximizedProperty().addListener({ _, _, _ ->
            println("saiudsadiuasuid")
            if (Main.stage.isMaximized) {
                this.layoutY -= this.height
                NeonExplorer.prefHeight -= this.height
                NeonConsole.ConsoleArea.layoutY -= this.height
            } else {
                this.layoutY += this.height
                NeonExplorer.prefHeight += this.height
                NeonConsole.ConsoleArea.layoutY += this.height
            }
        })
    }

}
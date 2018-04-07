package org.neon.api.controls.statusbar

import javafx.scene.control.ToolBar
import org.neon.api.controls.console.NeonConsole
import org.neon.api.controls.editor.NeonEditor
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.util.screen
import org.neon.util.stage

object NeonStatusBar : ToolBar() {

    init {
        this.prefWidthProperty().bind(stage.scene.widthProperty())
        this.prefHeight = 17.0
        this.layoutY = screen.height - this.prefHeight
        stage.maximizedProperty().addListener({ _, _, _ ->
            if (stage.isMaximized) {
                this.layoutY -= this.height
                NeonExplorer.prefHeight -= this.height
                NeonEditor.prefHeight -= this.height
                NeonConsole.ConsoleArea.layoutY -= this.height
            } else {
                this.layoutY += this.height
                NeonExplorer.prefHeight += this.height
                NeonEditor.prefHeight += this.height
                NeonConsole.ConsoleArea.layoutY += this.height
            }
        })
    }

}
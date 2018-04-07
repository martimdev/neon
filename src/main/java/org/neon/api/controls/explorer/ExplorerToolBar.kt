package org.neon.api.controls.explorer

import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import org.neon.util.Icons

object ExplorerToolBar : ToolBar() {

    object ExplorerSettingsButton : Button(null, Icons.Gear(15.0, 15.0)) {
        init {
            this.prefWidth = 15.0
            this.prefHeight = 15.0
            this.style += "-fx-background-color: transparent;"
            this.style += "-fx-border-width: 0;"
        }
    }

    init {
        this.prefWidthProperty().bind(NeonExplorer.widthProperty())
        this.items.addAll(ExplorerSettingsButton)
        this.prefHeight = 25.0
        this.layoutY += 24
    }

}
package org.neon.api.explorer

import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import org.neon.util.Icons

object ExplorerToolBar : ToolBar() {

    object SettingsExplorerButton : Button(null, Icons.Gear(15.0, 15.0)) {

        init {
            this.prefWidth = 15.0
            this.prefHeight = 15.0
        }

    }

    init {
        this.prefWidthProperty().bind(NeonExplorer.widthProperty())
        this.items.addAll(SettingsExplorerButton)
        this.prefHeight = 25.0
        this.layoutY += 24
    }

}
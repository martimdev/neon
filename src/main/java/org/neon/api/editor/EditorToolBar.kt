package org.neon.api.editor

import javafx.scene.control.ToolBar
import org.neon.Main
import org.neon.api.explorer.NeonExplorer

object EditorToolBar : ToolBar() {

    init {
        this.prefWidth = Main.screen.width - NeonExplorer.prefWidth
        this.layoutX += NeonExplorer.prefWidth + 1
        this.prefHeight = 25.0
        this.layoutY += 24
    }

}
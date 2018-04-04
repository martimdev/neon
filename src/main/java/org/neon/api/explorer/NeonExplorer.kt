package org.neon.api.explorer

import javafx.scene.control.TreeView
import org.neon.Main
import org.neon.util.files.NeonFile

object NeonExplorer : TreeView<NeonFile>() {

    init {
        this.prefHeight = Main.screen.height - 23.5
        this.layoutY += 23.5
    }

}
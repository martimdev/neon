package org.neon.api.contexts

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.control.TextInputDialog
import org.neon.api.controls.explorer.NeonExplorer

object FolderContextMenu : ContextMenu() {

    var menuItemNew = MenuItem("New")

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemNew,
                SeparatorMenuItem()
        )

        menuItemNew.setOnAction {
            val dialog = TextInputDialog()
            dialog.title = "File Name Input"
            dialog.contentText = "Name:"
            val result = dialog.showAndWait()
            result.ifPresent { fileName -> if (fileName != "") NeonExplorer.createNewFile(fileName) }
        }
    }

}
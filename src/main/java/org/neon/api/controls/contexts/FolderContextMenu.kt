package org.neon.api.controls.contexts

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.control.TextInputDialog
import org.neon.api.controls.explorer.NeonExplorer
import java.awt.Desktop
import java.io.File

object FolderContextMenu : ContextMenu() {

    var menuItemNew = MenuItem("New")
    var menuItemShowInExplorer = MenuItem("Show in Explorer")

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemNew,
                SeparatorMenuItem(),
                menuItemShowInExplorer,
                SeparatorMenuItem()
        )

        menuItemNew.setOnAction {
            val dialog = TextInputDialog()
            dialog.title = "File Name Input"
            dialog.contentText = "Name:"
            val result = dialog.showAndWait()
            result.ifPresent { fileName -> if (fileName != String()) NeonExplorer.createNewFile(fileName) }
        }

        menuItemShowInExplorer.setOnAction {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(File(NeonExplorer.selectionModel.selectedItem.value.parent))
            }
        }

    }

}
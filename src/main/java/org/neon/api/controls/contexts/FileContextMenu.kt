package org.neon.api.controls.contexts

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import org.neon.api.controls.explorer.NeonExplorer
import java.awt.Desktop
import java.io.File

object FileContextMenu : ContextMenu() {

    var menuItemDelete = MenuItem("Delete")
    var menuItemShowInExplorer = MenuItem("Show in Explorer")

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemDelete,
                SeparatorMenuItem(),
                menuItemShowInExplorer,
                SeparatorMenuItem()
        )

        menuItemDelete.setOnAction {
            NeonExplorer.deleteFile(NeonExplorer.selectionModel.selectedItem.value)
        }

        menuItemShowInExplorer.setOnAction {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(File(NeonExplorer.selectionModel.selectedItem.value.parent))
            }
        }

    }

}
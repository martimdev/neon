package org.neon.api.contexts

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import org.neon.api.controls.explorer.NeonExplorer

object FileContextMenu : ContextMenu() {

    var menuItemDelete = MenuItem("Delete")

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemDelete,
                SeparatorMenuItem()
        )

        menuItemDelete.setOnAction {
            NeonExplorer.deleteFile(NeonExplorer.selectionModel.selectedItem.value)
        }
    }

}
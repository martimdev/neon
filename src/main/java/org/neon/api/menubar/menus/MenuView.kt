package org.neon.api.menubar.menus

import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import org.neon.api.explorer.ExplorerToolBar
import org.neon.api.explorer.NeonExplorer
import org.neon.util.Icons

object MenuView : Menu("View") {

    var menuItemExplorer = MenuItem("Explorer", Icons.CheckMark(12.0, 12.0))

    init {

        this.items.addAll(
                SeparatorMenuItem(),
                menuItemExplorer,
                SeparatorMenuItem()
        )

        menuItemExplorer.setOnAction {
            if (NeonExplorer.isVisible) {
                menuItemExplorer.graphic = null
            } else {
                menuItemExplorer.graphic = Icons.CheckMark(12.0, 12.0)
            }
            NeonExplorer.isVisible = !NeonExplorer.isVisible
            ExplorerToolBar.isVisible = NeonExplorer.isVisible
        }

    }

}
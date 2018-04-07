package org.neon.api.controls.menubar.menus

import javafx.application.Platform
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

object MenuFile : Menu("File") {

    private val menuItemExit = MenuItem("Exit")

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemExit,
                SeparatorMenuItem()
        )

        menuItemExit.setOnAction {
            System.exit(0)
            Platform.exit()
        }
    }

}
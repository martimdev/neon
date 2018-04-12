package org.neon.api.controls.menubar.menus

import javafx.application.Platform
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import org.neon.util.actions.saveAllFiles
import org.neon.util.actions.saveCurrentFile
import org.neon.util.config

object MenuFile : Menu("File") {

    private val menuItemSave = MenuItem("Save")
    private val menuItemSaveAll = MenuItem("Save All")
    private val menuItemExit = MenuItem("Exit")

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemSave,
                menuItemSaveAll,
                SeparatorMenuItem(),
                menuItemExit,
                SeparatorMenuItem()
        )

        menuItemSave.accelerator = config.keyMap["saveCurrentFile"]
        menuItemSave.setOnAction {
            saveCurrentFile()
        }

        menuItemSaveAll.accelerator = config.keyMap["saveAllFiles"]
        menuItemSaveAll.setOnAction {
            saveAllFiles()
        }

        menuItemExit.setOnAction {
            System.exit(0)
            Platform.exit()
        }
    }

}
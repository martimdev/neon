package org.neon.api.controls.menubar.menus

import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import org.neon.api.controls.console.NeonConsole
import org.neon.api.controls.editor.NeonEditor
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.util.Icons
import org.neon.util.actions.hideExplorer
import org.neon.util.actions.showExplorer

object MenuView : Menu("View") {

    private val menuItemExplorer = MenuItem("Explorer", Icons.CheckMark(12.0, 12.0))
    private val menuItemConsole = MenuItem("Console")
    private val menuItemEditor = MenuItem("Editor", Icons.CheckMark(12.0, 12.0))

    init {
        this.items.addAll(
                SeparatorMenuItem(),
                menuItemExplorer,
                menuItemConsole,
                menuItemEditor,
                SeparatorMenuItem()
        )

        menuItemExplorer.setOnAction {
            if (NeonExplorer.isVisible) {
                menuItemExplorer.graphic = null
                hideExplorer()
            } else {
                menuItemExplorer.graphic = Icons.CheckMark(12.0, 12.0)
                showExplorer()
            }
        }

        menuItemConsole.setOnAction {
            if (NeonConsole.ConsoleArea.isVisible) {
                menuItemConsole.graphic = null
            } else {
                menuItemConsole.graphic = Icons.CheckMark(12.0, 12.0)
            }
            NeonConsole.ConsoleArea.isVisible = !NeonConsole.ConsoleArea.isVisible
        }

        menuItemEditor.setOnAction {
            if (NeonEditor.isVisible) {
                menuItemEditor.graphic = null
            } else {
                menuItemEditor.graphic = Icons.CheckMark(12.0, 12.0)
            }
            NeonEditor.isVisible = !NeonEditor.isVisible
        }
    }

}
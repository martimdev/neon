package org.neon.api.controls.menubar

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import org.neon.api.controls.menubar.menus.MenuFile
import org.neon.api.controls.menubar.menus.MenuView
import org.neon.util.stage

object NeonMenuBar : MenuBar() {

    object MenuEdit : Menu("Edit")
    object MenuRefactor : Menu("Refactor")
    object MenuRun : Menu("Run")
    object MenuTools : Menu("Tools")
    object MenuGit : Menu("Git")
    object MenuPlugins : Menu("Plugins")
    object MenuWindow : Menu("Window")
    object MenuHelp : Menu("Help")

    init {
        this.prefWidthProperty().bind(stage.widthProperty())
        this.menus.addAll(
                MenuFile,
                MenuEdit,
                MenuView,
                MenuRefactor,
                MenuRun,
                MenuTools,
                MenuGit,
                MenuPlugins,
                MenuWindow,
                MenuHelp
        )

    }

}
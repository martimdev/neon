package org.neon.api.menubar

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import org.neon.Main

object NeonMenuBar : MenuBar() {

    object MenuFile : Menu("File")
    object MenuEdit : Menu("Edit")
    object MenuView : Menu("View")
    object MenuRefactor : Menu("Refactor")
    object MenuRun : Menu("Run")
    object MenuTools : Menu("Tools")
    object MenuGit : Menu("Git")
    object MenuPlugins : Menu("Plugins")
    object MenuWindow : Menu("Window")
    object MenuHelp : Menu("Help")

    init {
        this.prefWidthProperty().bind(Main.stage.widthProperty())
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
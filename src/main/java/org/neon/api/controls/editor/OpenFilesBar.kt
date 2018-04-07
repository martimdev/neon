package org.neon.api.controls.editor

import javafx.scene.control.ToolBar
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.util.Icons
import org.neon.util.screen
import java.io.File

object OpenFilesBar : ToolBar() {

    var openFiles: List<String> = listOf()
    var activeFileButton: FileButton? = null

    init {
        this.prefWidth = screen.width - NeonExplorer.prefWidth
        this.layoutX += NeonExplorer.prefWidth + 1
        this.prefHeight = 25.0
        this.layoutY += 24
    }

    fun addOpenFile(file: File) {
        val fileButton = FileButton(file)
        fileButton.text = file.name
        fileButton.prefHeight = 0.0
        if (file.absolutePath !in openFiles) {
            if (NeonExplorer.icons[file.extension] == null) {
                fileButton.graphic = Icons.Undefined(14.0, 14.0)
            } else {
                fileButton.graphic = Icons.copy(NeonExplorer.icons[file.extension])
            }
            fileButton.setOnMouseClicked {
                this.activeFileButton?.deselect()
                this.activeFileButton = fileButton
                this.activeFileButton?.select()
                NeonEditor.replaceText(file.readText())
            }
            this.activeFileButton?.deselect()
            this.activeFileButton = fileButton
            this.activeFileButton?.select()
            this.openFiles += file.absolutePath
            this.items.add(fileButton)
        }
    }

}
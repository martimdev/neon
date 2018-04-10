package org.neon.api.controls.editor

import javafx.scene.control.ToolBar
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.util.screen
import java.io.File

object OpenFilesBar : ToolBar() {

    var activeFileBox: NeonFileBox? = null
    var openFiles: List<File> = listOf()

    init {
        this.prefWidth = screen.width - NeonExplorer.prefWidth
        this.layoutX += NeonExplorer.prefWidth + 1
        this.prefHeight = 25.0
        this.layoutY += 24
    }

    fun openFile(file: File) {
        val fileBox = NeonFileBox(file)
        fileBox.prefHeight = 0.0
        if (file !in openFiles) {
            fileBox.fileIcon.onMouseClicked = fileBox.onMouseClicked
            this.activeFileBox?.isSelected = false
            this.activeFileBox = fileBox
            this.activeFileBox?.isSelected = true
            NeonEditor.replaceText(fileBox.fileRuntimeText)
            this.openFiles += file
            this.items.add(fileBox)
        }
    }

    fun closeFile(fileBox: NeonFileBox) {
        this.items.remove(fileBox)
        this.openFiles -= fileBox.file
        if (fileBox.isSelected) {
            NeonEditor.clear()
        }
    }

}
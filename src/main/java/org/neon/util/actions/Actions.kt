package org.neon.util.actions

import org.neon.api.controls.editor.NeonEditor
import org.neon.api.controls.editor.NeonFileBox
import org.neon.api.controls.editor.OpenFilesBar
import org.neon.api.controls.explorer.ExplorerBar
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.util.Icons
import org.neon.util.screen

fun hideExplorer() {
    NeonExplorer.isVisible = false
    ExplorerBar.isVisible = false
    NeonEditor.prefWidth = screen.width
    NeonEditor.layoutX = 0.0
    OpenFilesBar.prefWidth = screen.width
    OpenFilesBar.layoutX = 0.0
}

fun showExplorer() {
    NeonExplorer.isVisible = true
    ExplorerBar.isVisible = true
    NeonEditor.prefWidth = screen.width + 1 - NeonExplorer.prefWidth
    NeonEditor.layoutX = NeonExplorer.prefWidth + 1
    OpenFilesBar.prefWidth = screen.width + 1 - NeonExplorer.prefWidth
    OpenFilesBar.layoutX = NeonExplorer.prefWidth + 1
}

fun saveCurrentFile() {
    OpenFilesBar.activeFileBox?.save()
    OpenFilesBar.activeFileBox?.closeButton?.graphic = Icons.Close(8.0, 8.0)
    OpenFilesBar.activeFileBox?.isSaved = true
}

fun saveAllFiles() {
    for (fileBox in OpenFilesBar.items) {
        val castFileBox = fileBox as NeonFileBox
        castFileBox.closeButton.graphic = Icons.Close(8.0, 8.0)
        castFileBox.save()
        castFileBox.isSaved = true
    }
}
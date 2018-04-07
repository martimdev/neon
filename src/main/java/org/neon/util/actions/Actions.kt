package org.neon.util.actions

import org.neon.api.editor.FileButton
import org.neon.api.editor.NeonEditor
import org.neon.api.editor.OpenFilesBar
import org.neon.api.explorer.ExplorerToolBar
import org.neon.api.explorer.NeonExplorer
import org.neon.util.screen
import java.io.File

fun hideExplorer() {
    NeonExplorer.isVisible = false
    ExplorerToolBar.isVisible = false
    NeonEditor.prefWidth = screen.width
    NeonEditor.layoutX = 0.0
    OpenFilesBar.prefWidth = screen.width
    OpenFilesBar.layoutX = 0.0
}

fun showExplorer() {
    NeonExplorer.isVisible = true
    ExplorerToolBar.isVisible = true
    NeonEditor.prefWidth = screen.width + 1 - NeonExplorer.prefWidth
    NeonEditor.layoutX = NeonExplorer.prefWidth + 1
    OpenFilesBar.prefWidth = screen.width + 1 - NeonExplorer.prefWidth
    OpenFilesBar.layoutX = NeonExplorer.prefWidth + 1
}

fun openFile(file: File) {
    OpenFilesBar.addOpenFile(file)
    NeonEditor.replaceText(file.readText())
}

fun closeFile(fileButton: FileButton) {
    OpenFilesBar.items.remove(fileButton)
    OpenFilesBar.openFiles -= fileButton.file.absolutePath
    if (OpenFilesBar.activeFileButton == fileButton) {
        NeonEditor.replaceText(String())
    }
}

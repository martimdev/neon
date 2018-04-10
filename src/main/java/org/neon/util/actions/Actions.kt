package org.neon.util.actions

import org.neon.api.controls.editor.NeonEditor
import org.neon.api.controls.editor.OpenFilesBar
import org.neon.api.controls.explorer.ExplorerBar
import org.neon.api.controls.explorer.NeonExplorer
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

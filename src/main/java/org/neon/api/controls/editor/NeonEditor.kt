package org.neon.api.controls.editor

import org.fxmisc.richtext.InlineCssTextArea
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.api.controls.statusbar.NeonStatusBar
import org.neon.util.Icons
import org.neon.util.screen

object NeonEditor : InlineCssTextArea() {

    init {
        this.prefHeight = screen.height - (51 + NeonStatusBar.prefHeight)
        this.layoutY += 50
        this.prefWidth = screen.width - NeonExplorer.prefWidth
        this.layoutX += NeonExplorer.prefWidth + 1

        this.setOnKeyTyped {
            if (OpenFilesBar.activeFileBox?.fileRuntimeText != NeonEditor.text) {
                OpenFilesBar.activeFileBox?.fileRuntimeText = this.text
                OpenFilesBar.activeFileBox?.closeButton?.graphic = Icons.NotClose(8.0, 8.0)
                OpenFilesBar.activeFileBox?.isSaved = false
            }
        }
    }

}
package org.neon.api.editor

import org.fxmisc.richtext.InlineCssTextArea
import org.neon.api.explorer.NeonExplorer
import org.neon.api.statusbar.NeonStatusBar
import org.neon.util.screen

object NeonEditor : InlineCssTextArea() {

    init {
        this.prefHeight = screen.height - (51 + NeonStatusBar.prefHeight)
        this.layoutY += 50
        this.prefWidth = screen.width - NeonExplorer.prefWidth
        this.layoutX += NeonExplorer.prefWidth + 1
    }

}
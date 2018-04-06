package org.neon.api.editor

import org.fxmisc.richtext.InlineCssTextArea
import org.neon.Main
import org.neon.api.explorer.NeonExplorer
import org.neon.api.statusbar.NeonStatusBar

object NeonEditor : InlineCssTextArea() {

    init {
        this.prefHeight = Main.screen.height - (51 + NeonStatusBar.prefHeight)
        this.layoutY += 50
        this.prefWidth = Main.screen.width - NeonExplorer.prefWidth
        this.layoutX += NeonExplorer.prefWidth + 1
    }

}
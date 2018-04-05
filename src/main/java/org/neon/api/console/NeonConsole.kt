package org.neon.api.console

import javafx.scene.control.TextArea
import org.neon.Main
import org.neon.api.statusbar.NeonStatusBar
import java.io.OutputStream

object NeonConsole : OutputStream() {

    object ConsoleArea : TextArea() {
        init {
            this.prefHeight = 200.0
            this.layoutY = Main.screen.height - (this.prefHeight + NeonStatusBar.prefHeight + 1)
            this.prefWidthProperty().bind(Main.scene.widthProperty())
            this.isEditable = false
            this.isVisible = false
        }
    }

    override fun write(b: Int) {
        ConsoleArea.appendText((b.toChar().toString()))
    }

}
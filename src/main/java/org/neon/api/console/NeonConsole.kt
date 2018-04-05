package org.neon.api.console

import javafx.scene.control.TextArea
import org.neon.Main
import java.io.OutputStream

object NeonConsole : OutputStream() {

    object ConsoleArea : TextArea() {
        init {
            this.prefHeight = 200.0
            this.layoutY = Main.screen.height - this.prefHeight
            this.prefWidthProperty().bind(Main.scene.widthProperty())
            this.isEditable = false
            this.isVisible = false
        }
    }

    override fun write(b: Int) {
        ConsoleArea.appendText((b.toChar().toString()))
    }

}
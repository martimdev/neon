package org.neon.api.controls.console

import javafx.scene.Cursor
import javafx.scene.control.TextArea
import org.neon.api.controls.statusbar.NeonStatusBar
import org.neon.util.screen
import org.neon.util.stage
import java.io.OutputStream

object NeonConsole : OutputStream() {

    object ConsoleArea : TextArea() {
        init {
            this.prefHeight = 200.0
            this.layoutY = screen.height - (this.prefHeight + NeonStatusBar.prefHeight + 1)
            this.prefWidthProperty().bind(stage.scene.widthProperty())
            this.isEditable = false
            this.isVisible = false

            this.setOnMouseMoved {
                this.cursor = Cursor.S_RESIZE
            }

            this.setOnMouseDragged { event ->
                if (this.cursor == Cursor.S_RESIZE) {
                    this.prefHeight -= event.y
                    this.layoutY += event.y
                }
            }
        }
    }

    override fun write(b: Int) {
        ConsoleArea.appendText((b.toChar().toString()))
    }

}
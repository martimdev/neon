package org.neon.api.controls.editor

import javafx.scene.control.Button
import org.neon.util.actions.closeFile
import java.io.File

class FileButton(val file: File) : Button() {
    init {
        this.setOnMousePressed { event ->
            if (event.isMiddleButtonDown) {
                closeFile(event.source as FileButton)
            }
        }
    }

    fun select() {
        this.styleClass.add("active-file-button")
    }

    fun deselect() {
        this.styleClass.remove("active-file-button")
    }
}
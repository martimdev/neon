package org.neon.api.controls.editor

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ToolBar
import javafx.scene.input.MouseButton
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.util.Icons
import java.io.File

class NeonFileBox(val file: File) : ToolBar() {

    private val fileNameLabel = Label(file.name)
    private val closeButton = Button(null, Icons.Close(8.0, 8.0))
    var fileRuntimeText = file.readText()
    var fileIcon =
            if (NeonExplorer.icons[file.extension] == null)
                Button(null, Icons.Undefined(16.0, 16.0))
            else {
                Button(null, Icons.copy(NeonExplorer.icons[file.extension]))
            }
    var isSelected = false
        set(value) {
            field = value
            if (value) {
                this.style += "-fx-background-color: #515658;"
            } else {
                this.style += "-fx-background-color: #3C3F41;"
            }
        }

    init {
        this.closeButton.prefHeight = 25.0
        this.styleClass.add("file-box")
        this.items.addAll(
                this.fileIcon,
                this.fileNameLabel,
                this.closeButton
        )

        this.setOnMouseClicked { event ->
            if (event.button == MouseButton.PRIMARY) {
                OpenFilesBar.activeFileBox?.isSelected = false
                OpenFilesBar.activeFileBox = this
                OpenFilesBar.activeFileBox?.isSelected = true
                NeonEditor.replaceText(this.fileRuntimeText)
            } else if (event.button == MouseButton.MIDDLE) {
                OpenFilesBar.closeFile(this)
            }
        }

        this.closeButton.setOnMouseClicked {
            OpenFilesBar.closeFile(this)
        }

        this.closeButton.setOnMouseEntered {
            this.closeButton.graphic = Icons.CloseLight(8.0, 8.0)
        }

        this.setOnMouseExited {
            this.closeButton.graphic = Icons.Close(8.0, 8.0)
        }
    }

}
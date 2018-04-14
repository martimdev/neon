package org.neon.api.controls.explorer

import javafx.scene.Cursor
import javafx.scene.control.*
import javafx.scene.image.ImageView
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.text.Text
import org.neon.api.controls.contexts.FileContextMenu
import org.neon.api.controls.contexts.FolderContextMenu
import org.neon.api.controls.editor.NeonEditor
import org.neon.api.controls.editor.OpenFilesBar
import org.neon.api.controls.statusbar.NeonStatusBar
import org.neon.util.*
import org.neon.util.files.NeonFile
import java.io.File

object NeonExplorer : TreeView<NeonFile>() {

    private val mouseEventHandle = { event: MouseEvent ->
        val node = event.pickResult.intersectedNode
        if (node is Text || node is TreeCell<*> && node.text != null) {
            val file = this.selectionModel.selectedItem.value
            if (event.clickCount == 2 && event.button == MouseButton.PRIMARY) {
                if (file.isFile) {
                    OpenFilesBar.openFile(file)
                }
            } else if (event.button == MouseButton.SECONDARY) {
                if (file.isDirectory) {
                    FolderContextMenu.show(stage, event.screenX, event.screenY)
                } else {
                    FileContextMenu.show(stage, event.screenX, event.screenY)
                }
            }
        }
    }

    val icons: HashMap<String, ImageView> = hashMapOf(
            "py" to Icons.Python(14.0, 14.0),
            "js" to Icons.JavaScript(14.0, 14.0)
    )

    private fun listFiles(root: TreeItem<NeonFile>, folder: File) {
        for (file in folder.listFiles()) {
            val item: TreeItem<NeonFile>? = TreeItem(NeonFile(file.path))
            if (file.isDirectory) {
                item?.graphic = Icons.Folder(14.0, 14.0)
                listFiles(item!!, NeonFile(file.path))
            } else {
                if (icons[file.extension] == null)
                    item?.graphic = Icons.Undefined(14.0, 14.0)
                else
                    item?.graphic = Icons.copy(icons[file.extension])

            }
            root.children.add(item)
        }
    }

    init {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle)
        this.prefHeight = screen.height - (51 + NeonStatusBar.prefHeight)
        this.layoutY += 50
        this.prefWidth = config.explorerWidth!!
        this.root = TreeItem(projectDirectory, Icons.Folder(14.0, 14.0))
        this.listFiles(this.root, projectDirectory)
        this.root.isExpanded = true

        this.setOnMouseMoved { event ->
            if (event.x > this.width - 5)
                this.cursor = Cursor.E_RESIZE
            else
                this.cursor = Cursor.DEFAULT
        }

        this.setOnMouseDragged { event ->
            if (event.x > this.width - 10)
                this.cursor = Cursor.E_RESIZE
            else
                this.cursor = Cursor.DEFAULT
            when {
                event.x > this.prefWidth || event.x - 5 < this.prefWidth && event.x + 15 > this.prefWidth -> {
                    this.prefWidth = event.x
                    NeonEditor.prefWidth = screen.width + 1 - event.x
                    NeonEditor.layoutX = event.x + 1
                    OpenFilesBar.prefWidth = screen.width + 1 - event.x
                    OpenFilesBar.layoutX = event.x + 1
                }
                else -> this.cursor = Cursor.DEFAULT
            }
        }
    }

    fun createNewFile(fileName: String) {
        val selectedItem = this.selectionModel.selectedItem
        val file = File(selectedItem.value.absolutePath + "/" + fileName)
        if (!file.exists()) {
            val item: TreeItem<NeonFile>? = TreeItem(NeonFile(file.path))
            file.createNewFile()
            if (icons[file.extension] == null)
                item?.graphic = Icons.Undefined(14.0, 14.0)
            else
                item?.graphic = Icons.copy(icons[file.extension])
            selectedItem.children.add(item)
        } else {
            Alert(Alert.AlertType.ERROR, "File already exists").showAndWait()
        }
    }

    fun deleteFile(file: File) {
        val alert = Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to move this file to trash?")
        val trashFolder = File(neonDirectory.absolutePath + "/trash")
        if (!trashFolder.exists()) {
            trashFolder.mkdirs()
        }
        if (alert.showAndWait().get() == ButtonType.OK) {
            file.renameTo(File("$neonDirectory/trash/$file"))
            this.selectionModel.selectedItem.parent.children.remove(this.selectionModel.selectedItem)
        }
    }

}

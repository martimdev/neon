package org.neon.api.explorer

import javafx.scene.Cursor
import javafx.scene.control.TreeCell
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.image.ImageView
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.text.Text
import org.neon.api.editor.NeonEditor
import org.neon.api.editor.OpenFilesBar
import org.neon.api.statusbar.NeonStatusBar
import org.neon.util.Icons
import org.neon.util.actions.openFile
import org.neon.util.config
import org.neon.util.files.NeonFile
import org.neon.util.screen
import java.io.File

object NeonExplorer : TreeView<NeonFile>() {

    private val mouseEventHandle = { event: MouseEvent ->
        val node = event.pickResult.intersectedNode
        if (node is Text || node is TreeCell<*> && node.text != null) {
            val file = this.selectionModel.selectedItem.value
            if (event.clickCount == 2 && event.button == MouseButton.PRIMARY) {
                if (file.isFile) {
                    openFile(file)
                    NeonEditor.replaceText(file.readText())
                }
            }
        }
    }

    private var rootFolder = NeonFile("C:\\Users\\Vitor Marques\\dev\\JavaScript\\flappy-bird")
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
                if (icons[file.extension] == null) {
                    item?.graphic = Icons.Undefined(14.0, 14.0)
                } else {
                    item?.graphic = Icons.copy(icons[file.extension])
                }
            }
            root.children.add(item)
        }
    }

    init {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle)
        this.prefHeight = screen.height - (51 + NeonStatusBar.prefHeight)
        this.layoutY += 50
        this.prefWidth = config.explorerWidth
        this.root = TreeItem(rootFolder, Icons.Folder(14.0, 14.0))
        this.listFiles(this.root, this.rootFolder)
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
}

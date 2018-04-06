package org.neon.api.explorer

import javafx.scene.Cursor
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.image.ImageView
import org.neon.Main
import org.neon.api.editor.EditorToolBar
import org.neon.api.editor.NeonEditor
import org.neon.api.statusbar.NeonStatusBar
import org.neon.util.Icons
import org.neon.util.files.NeonFile
import java.io.File

object NeonExplorer : TreeView<NeonFile>() {

    private var rootFolder = NeonFile("C:\\Users\\Vitor Marques\\dev\\JavaScript\\flappy-bird")
    private val icons: HashMap<String, ImageView> = hashMapOf(
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
        this.prefHeight = Main.screen.height - (51 + NeonStatusBar.prefHeight)
        this.layoutY += 50
        this.prefWidth = 250.0
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
            if (event.x > this.width - 5)
                this.cursor = Cursor.E_RESIZE
            else
                this.cursor = Cursor.DEFAULT
            when {
                event.x > this.prefWidth -> {
                    this.prefWidth = event.x
                    NeonEditor.prefWidth = Main.screen.width + 1 - event.x
                    NeonEditor.layoutX = event.x + 1
                    EditorToolBar.prefWidth = Main.screen.width + 1 - event.x
                    EditorToolBar.layoutX = event.x + 1
                }
                event.x - 5 < this.prefWidth && event.x + 15 > this.prefWidth -> {
                    this.prefWidth = event.x
                    NeonEditor.prefWidth = Main.screen.width + 1 - event.x
                    NeonEditor.layoutX = event.x + 1
                    EditorToolBar.prefWidth = Main.screen.width + 1 - event.x
                    EditorToolBar.layoutX = event.x + 1
                }
                else -> this.cursor = Cursor.DEFAULT
            }
        }
    }
}

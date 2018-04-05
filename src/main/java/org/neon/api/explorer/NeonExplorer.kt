package org.neon.api.explorer

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.image.ImageView
import org.neon.Main
import org.neon.util.Icons
import org.neon.api.controls.rezisables.Resizable
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
        this.prefHeight = Main.screen.height - 50
        this.layoutY += 50
        Resizable(this).makeRegionResizable()
        this.root = TreeItem(rootFolder, Icons.Folder(14.0, 14.0))
        this.listFiles(this.root, this.rootFolder)
        this.root.isExpanded = true
    }

}
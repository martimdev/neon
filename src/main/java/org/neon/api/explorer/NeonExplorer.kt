package org.neon.api.explorer

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import org.neon.Main
import org.neon.util.controls.Resizable
import org.neon.util.files.NeonFile
import java.io.File

object NeonExplorer : TreeView<NeonFile>() {

    private var rootFolder = NeonFile("C:\\Users\\Vitor Marques\\dev\\JavaScript\\flappy-bird")
    private val folderIcon = Image("icons/folder-icon.png")
    private val undefinedIcon = Image("icons/undefined-icon.png")
    private val icons: HashMap<String, Image> = hashMapOf(
            "py" to Image("icons/python-icon.png"),
            "js" to Image("icons/javascript-icon.png")
    )

    private fun listFiles(root: TreeItem<NeonFile>, folder: File) {
        for (f in folder.listFiles()) {
            val item: TreeItem<NeonFile>? = TreeItem(NeonFile(f.path))
            if (f.isFile) {
                if (icons[f.extension] == null) {
                    val icon = ImageView(this.undefinedIcon)
                    icon.fitHeight = 12.0
                    icon.fitWidth = 12.0
                    item?.graphic = icon
                } else {
                    val icon = ImageView(icons[f.extension])
                    icon.fitHeight = 12.0
                    icon.fitWidth = 12.0
                    item?.graphic = icon
                }
            } else if (f.isDirectory) {
                val icon = ImageView(folderIcon)
                icon.fitHeight = 12.0
                icon.fitWidth = 12.0
                item?.graphic = icon
                listFiles(item!!, NeonFile(f.path))
            }
            root.children.add(item)
        }
    }

    init {
        this.prefHeight = Main.screen.height - 25
        this.layoutY += 25
        Resizable(this).makeRegionResizable()
        val icon = ImageView(folderIcon)
        icon.fitHeight = 12.0
        icon.fitWidth = 12.0
        this.root = TreeItem(rootFolder, icon)
        this.listFiles(this.root, this.rootFolder)
        this.root.isExpanded = true
    }

}
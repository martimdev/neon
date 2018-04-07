package org.neon.util

import com.google.gson.Gson
import org.neon.Launcher
import org.neon.api.config.ConfigData
import org.neon.api.console.NeonConsole
import org.neon.api.editor.NeonEditor
import org.neon.api.editor.OpenFilesBar
import org.neon.api.explorer.ExplorerToolBar
import org.neon.api.explorer.NeonExplorer
import org.neon.api.menubar.NeonMenuBar
import org.neon.api.statusbar.NeonStatusBar
import java.io.File
import java.io.InputStreamReader
import java.io.PrintStream

fun loadDeafultComponents() {
    root.children.add(NeonMenuBar)
    root.children.add(NeonExplorer)
    root.children.add(ExplorerToolBar)
    root.children.add(NeonEditor)
    root.children.add(OpenFilesBar)
    root.children.add(NeonConsole.ConsoleArea)
    root.children.add(NeonStatusBar)
}

fun loadStyles() {
    root.stylesheets.add("styles/default.css")
    root.stylesheets.add("styles/" + config.styleFileName)
}

fun createNeonFolder() {
    if (!neonFolder.exists()) {
        neonFolder.mkdir()
    }
}

fun createUserConfig(config: ConfigData) {
    val file = File(neonFolder.absolutePath + "/config/user_config.json")
    file.createNewFile()
    file.writeText(Gson().toJson(config))
}

fun loadDefaultConfig(): ConfigData {
    val reader = InputStreamReader(Launcher::class.java.classLoader.getResourceAsStream("config/default_config.json"), "UTF-8")
    return Gson().fromJson(reader, ConfigData::class.java)
}

fun enableConfigs() {
    if (config.isConsoleEnabled) {
        System.setOut(PrintStream(NeonConsole))
    }
}
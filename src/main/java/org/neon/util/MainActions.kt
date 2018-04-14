package org.neon.util

import com.google.gson.Gson
import org.neon.Launcher
import org.neon.api.config.ConfigData
import org.neon.api.controls.console.NeonConsole
import org.neon.api.controls.editor.NeonEditor
import org.neon.api.controls.editor.OpenFilesBar
import org.neon.api.controls.explorer.ExplorerBar
import org.neon.api.controls.explorer.NeonExplorer
import org.neon.api.controls.menubar.NeonMenuBar
import org.neon.api.controls.statusbar.NeonStatusBar
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.PrintStream

fun loadDeafultComponents() {
    root.children.add(NeonMenuBar)
    root.children.add(NeonExplorer)
    root.children.add(ExplorerBar)
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
    if (!neonDirectory.exists()) {
        neonDirectory.mkdir()
    }
}

fun createUserConfig() {
    val configDirectory = File(neonDirectory.absolutePath + "/config")
    if (!configDirectory.exists()) {
        configDirectory.mkdir()
    }
    val file = File(neonDirectory.absolutePath + "/config/user_config.json")
    file.createNewFile()
    if (file.readText() == String()) {
        file.writeText("{}")
    }
}

fun createPluginsDirectory() {
    if (!pluginsDirectory.exists()) {
        pluginsDirectory.mkdir()
    }
}

fun loadUserConfig(): ConfigData {
    val reader = InputStreamReader(FileInputStream(File("$configDirectory/user_config.json")), "UTF-8")
    return Gson().fromJson(reader, ConfigData::class.java)
}

fun loadDefaultConfig(): ConfigData {
    createNeonFolder()
    createUserConfig()
    createPluginsDirectory()
    val reader = InputStreamReader(Launcher::class.java.classLoader.getResourceAsStream("config/default_config.json"), "UTF-8")
    return Gson().fromJson(reader, ConfigData::class.java)
}

fun mergeConfigs(): ConfigData {
    val defaultConfigJson = Gson().toJsonTree(defaultConfig).asJsonObject
    val userConfigJson = Gson().toJsonTree(userConfig).asJsonObject
    for ((key, value) in userConfigJson.entrySet()) {
        if (value != null) {
            defaultConfigJson.add(key, value)
        }
    }
    return Gson().fromJson(defaultConfigJson, ConfigData::class.java)
}

fun enableConfigs() {
    if (config.isConsoleEnabled!!) {
        System.setOut(PrintStream(NeonConsole))
    }
}
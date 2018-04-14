package org.neon.api.plugins

import com.google.gson.Gson
import org.neon.util.pluginsDirectory
import java.net.URL
import java.net.URLClassLoader

object PluginLoader {

    private var pluginsUrls: ArrayList<URL> = ArrayList()
    private var plugins: ArrayList<DeafultPlugin> = ArrayList()
    private var loader: URLClassLoader

    init {
        pluginsDirectory.listFiles().forEach { file ->
            pluginsUrls.add(file.toURI().toURL())
        }
        loader = URLClassLoader(pluginsUrls.toTypedArray(), ClassLoader.getSystemClassLoader())
        pluginsUrls.forEach { url ->
            val jsonLoader = URLClassLoader(arrayOf(url), ClassLoader.getSystemClassLoader())
            val main = Gson().fromJson(
                    jsonLoader.getResourceAsStream("plugin.json").reader(),
                    PluginData::class.java
            ).main
            plugins.add(loader.loadClass(main).newInstance() as DeafultPlugin)
        }
    }

    fun loadPlugins() {
        plugins.forEach { plugin ->
            plugin.onLoad()
        }
    }

    fun enablePlugins() {
        plugins.forEach { plugin ->
            plugin.onEnable()
        }
    }

    fun disablePlugins() {
        plugins.forEach { plugin ->
            plugin.onDisable()
        }
    }

}
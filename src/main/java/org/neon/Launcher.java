package org.neon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.neon.api.plugins.PluginLoader;

import static org.neon.util.MainActionsKt.*;
import static org.neon.util.MainValuesKt.*;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Neon");
        stage.setScene(new Scene(getRoot(), getScreen().getWidth(), getScreen().getHeight()));
        loadDeafultComponents();
        PluginLoader.INSTANCE.loadPlugins();
        enableConfigs();
        PluginLoader.INSTANCE.enablePlugins();
        loadStyles();
        stage.setOnCloseRequest(event -> PluginLoader.INSTANCE.disablePlugins());
        stage.show();
    }

}

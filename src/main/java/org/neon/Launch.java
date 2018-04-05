package org.neon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.neon.Main.*;

public class Launch extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Neon");
        scene = new Scene(root, screen.getWidth(), screen.getHeight());
        loadConfigs();
        loadDeafultComponents();
        loadDefaultStyles();
        stage.setScene(scene);
        stage.show();
    }

}

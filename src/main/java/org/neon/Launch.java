package org.neon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.neon.Main.*;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Neon");
        loadDeafultComponents();
        loadDefaultStyles();
        scene = new Scene(root, screen.getWidth(), screen.getHeight());
        stage.setScene(scene);
        stage.show();
    }

}

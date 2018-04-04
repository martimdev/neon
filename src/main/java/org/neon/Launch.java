package org.neon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static org.neon.Main.*;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Neon");
        root = new AnchorPane();
        loadDeafultComponents();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

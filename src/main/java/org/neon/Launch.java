package org.neon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Launch extends Application {

    public static Stage stage;
    public static AnchorPane root;
    public static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Neon");
        root = new AnchorPane();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

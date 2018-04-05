package org.neon.api.controls.dialogs;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.neon.Main;

public class NeonDialog {

    private Stage stage = new Stage();
    private Pane pane = new Pane();
    private Scene scene;

    public NeonDialog(double width, double height) {
        scene = new Scene(pane, width, height);
        stage.initOwner(Main.stage);
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}

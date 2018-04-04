package org.neon;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.neon.api.menubar.NeonMenuBar;

public class Main {

    public static Stage stage;
    public static AnchorPane root;
    public static Scene scene;

    public static void loadDeafultComponents() {
        root.getChildren().add(NeonMenuBar.INSTANCE);
    }

}

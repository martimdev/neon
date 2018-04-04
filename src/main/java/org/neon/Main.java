package org.neon;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.neon.api.explorer.NeonExplorer;
import org.neon.api.menubar.NeonMenuBar;

public class Main {

    public static Stage stage;
    public static AnchorPane root = new AnchorPane();
    public static Rectangle2D screen = Screen.getPrimary().getVisualBounds();
    public static Scene scene;

    static void loadDeafultComponents() {
        root.getChildren().add(NeonMenuBar.INSTANCE);
        root.getChildren().add(NeonExplorer.INSTANCE);
    }

    static void loadDefaultStyles() {
        root.getStylesheets().add("styles/default.css");
        root.getStylesheets().add("styles/dark.css");
    }

}

package org.neon;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.neon.api.console.NeonConsole;
import org.neon.api.editor.EditorToolBar;
import org.neon.api.editor.NeonEditor;
import org.neon.api.explorer.ExplorerToolBar;
import org.neon.api.explorer.NeonExplorer;
import org.neon.api.menubar.NeonMenuBar;
import org.neon.api.statusbar.NeonStatusBar;

import java.io.PrintStream;

public class Main {

    public static Stage stage;
    public static Rectangle2D screen = Screen.getPrimary().getVisualBounds();
    public static Scene scene;
    static AnchorPane root = new AnchorPane();

    static void loadDeafultComponents() {
        root.getChildren().add(NeonMenuBar.INSTANCE);
        root.getChildren().add(NeonExplorer.INSTANCE);
        root.getChildren().add(ExplorerToolBar.INSTANCE);
        root.getChildren().add(NeonEditor.INSTANCE);
        root.getChildren().add(EditorToolBar.INSTANCE);
        root.getChildren().add(NeonConsole.ConsoleArea.INSTANCE);
        root.getChildren().add(NeonStatusBar.INSTANCE);
    }

    static void loadDefaultStyles() {
        root.getStylesheets().add("styles/default.css");
        root.getStylesheets().add("styles/dark.css");
    }

    static void loadConfigs() {
        System.setOut(new PrintStream(NeonConsole.INSTANCE));
    }

}

package org.neon.api.controls.rezisables;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

public class Resizable {

    private final Region region;
    private int resizeMargin = 5;
    private double x;
    private boolean dragging;

    public Resizable(Region region) {
        this.region = region;
    }

    public void makeRegionResizable() {

        region.setOnMousePressed(event -> {
            if (!isInDraggableZone(event)) {
                return;
            }
            dragging = true;
            region.setMinWidth(region.getWidth());
            x = event.getX();
        });

        region.setOnMouseDragged(event -> {
            if (dragging) {
                if (region.getWidth() < 5) {
                    resizeMargin = 1;
                } else {
                    resizeMargin = 5;
                }
                double mouseX = event.getX();
                double newHeight = region.getMinWidth() + (mouseX - x);
                region.setMinWidth(newHeight);
                x = mouseX;
            }
        });

        region.setOnMouseMoved(event -> {
            if (isInDraggableZone(event) || dragging) {
                region.setCursor(Cursor.E_RESIZE);
            } else {
                region.setCursor(Cursor.DEFAULT);
            }
        });

        region.setOnMouseReleased(event -> {
            dragging = false;
            region.setCursor(Cursor.DEFAULT);
        });

    }

    private boolean isInDraggableZone(MouseEvent event) {
        return event.getX() > (region.getWidth() - resizeMargin);
    }

}
package org.neon.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icons {

    public static ImageView copy(ImageView imageView) {
        ImageView newImageView = new ImageView(imageView.getImage());
        newImageView.setFitHeight(imageView.getFitHeight());
        newImageView.setFitWidth(imageView.getFitWidth());
        return newImageView;
    }

    public static class Undefined extends ImageView {
        public Undefined(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/undefined-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class Folder extends ImageView {
        public Folder(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/folder-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class CheckMark extends ImageView {
        public CheckMark(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/check-mark-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class Gear extends ImageView {
        public Gear(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/gear-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class Close extends ImageView {
        public Close(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/close-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class CloseLight extends ImageView {
        public CloseLight(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/close-light-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class NotClose extends ImageView {
        public NotClose(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/not-save-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class Python extends ImageView {
        public Python(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/python-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

    public static class JavaScript extends ImageView {
        public JavaScript(double fitHeight, double fitWidth) {
            this.setImage(new Image("icons/javascript-icon.png"));
            this.setFitHeight(fitHeight);
            this.setFitWidth(fitWidth);
        }
    }

}

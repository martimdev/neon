package org.neon.util.files;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class NeonFile extends File {

    private String text;

    public NeonFile(@NotNull String pathname) {
        super(pathname);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

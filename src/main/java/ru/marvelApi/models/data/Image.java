package ru.marvelApi.models.data;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class Image {
    private String path;
    private String extension;

    public Image(@JsonField(name = "path")String path, @JsonField(name = "extension")String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}

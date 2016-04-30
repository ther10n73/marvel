package ru.marvelApi.models.comics;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class TextObject {
    private String type;
    private String language;
    private String text;

    public TextObject(@JsonField(name = "type")String type, @JsonField(name = "language")String language, @JsonField(name = "text")String text) {
        this.type = type;
        this.language = language;
        this.text = text;
    }

    @Override
    public String toString() {
        return "<br>Type: " + type + "</br>" +
                "<br>Language: " + language + "</br>" +
                "<br>Text: " + text + "</br>";
    }
}

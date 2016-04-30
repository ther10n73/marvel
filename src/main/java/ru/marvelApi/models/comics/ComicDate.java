package ru.marvelApi.models.comics;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class ComicDate {
    private String type;
    private String date;

    public ComicDate(@JsonField(name = "type")String type, @JsonField(name = "date")String date) {
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString(){
        return "<br>Type: " + type + "</br>" +
                "<br>Date: " + date + "</br>";
    }
}

package ru.marvelApi.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khartonov Oleg on 24.04.2016.
 */
public enum MarvelTypes {
    CHARACTERS("characters"),
    CREATORS("creators"),
    EVENTS("events"),
    COMICS("comics"),
    SERIES("series"),
    STORIES("stories");

    private String name;

    MarvelTypes(String name) {
        this.name = name;
    }

    private final static  List<MarvelTypes> types = new ArrayList<>();

    static {
       for (MarvelTypes mp : MarvelTypes.values()){
            types.add(mp);
        }
    }

    public static List<MarvelTypes> getListTypes() {
        return types;
    }

    public static MarvelTypes getType (Integer key) {
        return types.get(key);
    }

    public String toString(){
        return this.name;
    }
}

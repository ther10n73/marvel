package ru.marvelApi.models.data.summary;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class StorySummary extends Summary{
    private String type;

    public StorySummary(@JsonField(name = "resourceURI")String resourceURI, @JsonField(name = "name")String name, @JsonField(name = "type") String type) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
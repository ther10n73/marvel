package ru.marvelApi.models.data.summary;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class SeriesSummary extends Summary {
    public SeriesSummary(@JsonField(name = "resourceURI")String resourceURI, @JsonField(name = "name")String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }
}

package ru.marvelApi.models.data.summary;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public interface Summary {
    String getResourceURI();

    String getName();

    void setResourceURI(String resourceURI);

    void setName(String name);
}

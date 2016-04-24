package ru.marvelApi.models.data.summary;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public abstract class Summary {
    protected String resourceURI;
    protected String name;

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setName(String name) {
        this.name = name;
    }
}

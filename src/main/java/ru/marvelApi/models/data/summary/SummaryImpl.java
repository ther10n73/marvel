package ru.marvelApi.models.data.summary;

/**
 * Created by Khartonov Oleg on 02.05.2016.
 */
public class SummaryImpl implements Summary {
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

    @Override
    public String toString() {
        return  "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'';
    }
}

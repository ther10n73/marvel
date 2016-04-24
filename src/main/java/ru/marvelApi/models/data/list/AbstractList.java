package ru.marvelApi.models.data.list;

import ru.marvelApi.ReflectionApp;
import ru.marvelApi.models.data.summary.Summary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public abstract class AbstractList {
    protected int available;
    protected int returned;
    protected String collectionURI;
    protected List<Summary> items = new ArrayList<>();
    public ReflectionApp reflectionApp = new ReflectionApp();

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<Summary> getItems() {
        return items;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public void setItems(List<Summary> items) {
        this.items = items;
    }
}

package ru.marvelApi.models.data.list;

import com.google.gson.JsonElement;
import ru.marvelApi.models.data.summary.Summary;

import java.util.List;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public interface DataList {

    int getAvailable();

    int getReturned();

    String getCollectionURI();

    List<Summary> getItems();

    void setAvailable(int available);

    void setReturned(int returned);

    void setCollectionURI(String collectionURI);

    void setItems(JsonElement items);
}

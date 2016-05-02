package ru.marvelApi.models.data.list;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.summary.StorySummary;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class StoryList extends DataList {
    public StoryList(@JsonField(name = "available")String available, @JsonField(name = "returned")String returned,@JsonField(name = "collectionURI") String collectionURI, @JsonField(name = "items")JsonElement items) {
        this.available = Integer.parseInt(available);
        this.returned = Integer.parseInt(returned);
        this.collectionURI = collectionURI;
        this.setItems(items);
    }

    @Override
    public void setItems(JsonElement items){
        items.getAsJsonArray()
                .forEach(je ->{
                    try {
                        this.items.add(reflectionApp.createObject(je.getAsJsonObject(), StorySummary.class));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }
}

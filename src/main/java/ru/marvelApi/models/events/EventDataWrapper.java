package ru.marvelApi.models.events;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataWrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 17.04.2016.
 */
public class EventDataWrapper extends DataWrapper {
    public EventDataWrapper(@JsonField(name = "code") String code, @JsonField(name = "status") String status, @JsonField(name = "copyright") String copyright, @JsonField(name = "attributionText") String attributionText, @JsonField(name = "attributionHTML") String attributionHTML, @JsonField(name = "data") JsonElement data, @JsonField(name = "etag") String etag) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(code, status, copyright, attributionText, attributionHTML, data, etag);
    }

    @Override
    public void setData(JsonElement data) throws NoSuchMethodException {
        try{
            this.data = reflectionApp.createObject(data, EventDataContainer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

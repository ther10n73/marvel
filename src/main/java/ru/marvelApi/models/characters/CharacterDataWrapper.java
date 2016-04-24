package ru.marvelApi.models.characters;

import com.google.gson.JsonElement;
import ru.marvelApi.models.data.DataWrapper;
import ru.marvelApi.annotation.JsonField;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class CharacterDataWrapper extends DataWrapper {

    public CharacterDataWrapper(@JsonField(name = "code") String code, @JsonField(name = "status") String status, @JsonField(name = "copyright") String copyright, @JsonField(name = "attributionText") String attributionText, @JsonField(name = "attributionHTML") String attributionHTML, @JsonField(name = "data") JsonElement data, @JsonField(name = "etag") String etag) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(code, status, copyright, attributionText, attributionHTML, data, etag);
    }

    @Override
    public void setData(JsonElement data) {
        try {
            this.data = reflectionApp.createObject(data, CharacterDataContainer.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

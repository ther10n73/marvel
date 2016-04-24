package ru.marvelApi;

import com.google.gson.JsonElement;
import ru.marvelApi.models.characters.CharacterDataWrapper;
import ru.marvelApi.models.comics.ComicsDataWrapper;
import ru.marvelApi.connection.HttpConnection;
import ru.marvelApi.models.creators.CreatorsDataWrapper;
import ru.marvelApi.models.data.DataWrapper;
import ru.marvelApi.models.events.EventDataWrapper;
import ru.marvelApi.models.series.SeriesDataWrapper;
import ru.marvelApi.models.stoies.StoriesDataWrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 23.04.2016.
 */
public class MarvelFactory {
    private final ReflectionApp reflection = new ReflectionApp();
    private final HttpConnection conn = new HttpConnection();

    public DataWrapper createDataWrapper(String type) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        JsonElement jsonResponse = conn.createParamRequests(HttpConnection.GET_INFO + type);
        if (type.equals("events")){
            return reflection.createObject(jsonResponse, EventDataWrapper.class);
        } else if (type.equals("comics")) {
            return reflection.createObject(jsonResponse, ComicsDataWrapper.class);
        } else if (type.equals("characters")) {
            return reflection.createObject(jsonResponse, CharacterDataWrapper.class);
        } else if (type.equals("series")) {
            return reflection.createObject(jsonResponse, SeriesDataWrapper.class);
        } else if (type.equals("stories")) {
            return reflection.createObject(jsonResponse, StoriesDataWrapper.class);
        } else if (type.equals("creators")) {
            return reflection.createObject(jsonResponse, CreatorsDataWrapper.class);
        } else {
            throw new IllegalStateException("Unknown type requests: " + type);
        }
    }
}
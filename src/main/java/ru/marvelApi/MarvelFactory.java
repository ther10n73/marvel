package ru.marvelApi;

import com.google.gson.JsonElement;
import ru.marvelApi.models.data.DataWrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 23.04.2016.
 */
public interface MarvelFactory {

    DataWrapper createDataWrapper(String type) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    DataWrapper createDataWrapper(String type, int id, String typeSummary) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    DataWrapper getTypeForDataWrapper(JsonElement jsonResponse, String type) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}

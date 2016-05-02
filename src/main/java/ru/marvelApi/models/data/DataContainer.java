package ru.marvelApi.models.data;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * Created by Khartonov Oleg on 02.05.2016.
 */
public interface DataContainer {
    int getOffset();

    int getLimit();

    int getTotal();

    int getCount();

    List<DataImpl> getResults();

    void setOffset(int offset);

    void setLimit(int limit);

    void setTotal(int total);

    void setCount(int count);

    void setResults(JsonElement results);
}

package ru.marvelApi.models.data;

import com.google.gson.JsonElement;
import ru.marvelApi.ReflectionApp;
import ru.marvelApi.annotation.JsonField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public abstract class DataContainer<T> {
    private int offset;
    private int limit;
    private int total;
    private int count;
    protected List<T> results = new ArrayList<>();
    public ReflectionApp reflection = new ReflectionApp();

    public DataContainer(@JsonField(name = "offset") String offset, @JsonField(name = "limit") String limit, @JsonField(name = "total") String total, @JsonField(name = "count") String count, @JsonField(name = "results") JsonElement results) {
        this.offset = Integer.parseInt(offset);
        this.limit = Integer.parseInt(limit);
        this.total = Integer.parseInt(total);
        this.count = Integer.parseInt(count);
        this.setResults(results);
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public abstract void setResults(JsonElement results);

    public String toString() {
        return "<br>Container: </br>" +
                    "<br>offset: " + offset + "</br>" +
                    "<br>limit: " + limit + "</br>" +
                    "<br>total: " + total + "</br>" +
                    "<br>count: " + count + "</br>" +
                    "<br>" + getResults().toString() + "</br>";
    }
}
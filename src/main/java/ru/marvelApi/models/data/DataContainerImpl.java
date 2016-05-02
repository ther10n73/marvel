package ru.marvelApi.models.data;

import com.google.gson.JsonElement;
import ru.marvelApi.ReflectionApp;
import ru.marvelApi.annotation.JsonField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public abstract class DataContainerImpl implements DataContainer {
    private int offset;
    private int limit;
    private int total;
    private int count;
    protected List<DataImpl> results = new ArrayList<>();
    public ReflectionApp reflection = new ReflectionApp();

    public DataContainerImpl(@JsonField(name = "offset") String offset, @JsonField(name = "limit") String limit, @JsonField(name = "total") String total, @JsonField(name = "count") String count, @JsonField(name = "results") JsonElement results) {
        this.offset = Integer.parseInt(offset);
        this.limit = Integer.parseInt(limit);
        this.total = Integer.parseInt(total);
        this.count = Integer.parseInt(count);
        this.setResults(results);
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public List<DataImpl> getResults() {
        return results;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public abstract void setResults(JsonElement results);

    @Override
    public String toString() {
        return "DataContainerImpl{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", total=" + total +
                ", count=" + count +
                ", results=" + results +
                ", reflection=" + reflection +
                '}';
    }
}

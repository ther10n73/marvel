package ru.marvelApi.models.creators;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataContainer;

import java.util.ArrayList;

/**
 * Created by Khartonov Oleg on 17.04.2016.
 */
public class CreatorsDataContainer extends DataContainer {
    public CreatorsDataContainer(@JsonField(name = "offset") String offset, @JsonField(name = "limit") String limit, @JsonField(name = "total") String total, @JsonField(name = "count") String count, @JsonField(name = "results") JsonElement results) {
        super(offset, limit, total, count, results);
    }

    @Override
    public void setResults(JsonElement results) {
        this.results = new ArrayList<>();
        results.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.results.add(reflection.createObject(je.getAsJsonObject(),Creator.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

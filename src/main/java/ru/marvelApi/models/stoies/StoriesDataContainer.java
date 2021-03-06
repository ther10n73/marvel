package ru.marvelApi.models.stoies;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataContainerImpl;

import java.util.ArrayList;

/**
 * Created by Khartonov Oleg on 21.04.2016.
 */
public class StoriesDataContainer extends DataContainerImpl {
    public StoriesDataContainer(@JsonField(name = "offset") String offset, @JsonField(name = "limit") String limit, @JsonField(name = "total") String total, @JsonField(name = "count") String count, @JsonField(name = "results") JsonElement results) {
        super(offset, limit, total, count, results);
    }

    @Override
    public void setResults(JsonElement results) {
        this.results = new ArrayList<>();
        results.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.results.add(reflection.createObject(je.getAsJsonObject(),Stories.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

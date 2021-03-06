package ru.marvelApi.models.events;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataContainerImpl;

import java.util.ArrayList;

/**
 * Created by Khartonov Oleg on 17.04.2016.
 */
public class EventDataContainer extends DataContainerImpl {
    public EventDataContainer(@JsonField(name = "offset") String offset, @JsonField(name = "limit") String limit, @JsonField(name = "total") String total, @JsonField(name = "count") String count, @JsonField(name = "results") JsonElement results) {
        super(offset, limit, total, count, results);
    }

    @Override
    public void setResults(JsonElement results) {
        this.results = new ArrayList<>();
        results.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.results.add(reflection.createObject(je.getAsJsonObject(),Event.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

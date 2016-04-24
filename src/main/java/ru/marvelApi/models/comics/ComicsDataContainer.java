package ru.marvelApi.models.comics;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataContainer;

import java.util.ArrayList;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class ComicsDataContainer extends DataContainer {
    public ComicsDataContainer(@JsonField(name = "offset") String offset, @JsonField(name = "limit") String limit, @JsonField(name = "total") String total, @JsonField(name = "count") String count, @JsonField(name = "results") JsonElement results) {
        super(offset, limit, total, count, results);
    }

    @Override
    public void setResults(JsonElement results) {
            this.results = new ArrayList<>();
            results.getAsJsonArray()
                    .forEach(je -> {
                        try {
                            this.results.add(reflection.createObject(je.getAsJsonObject(),Comic.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
    }
}

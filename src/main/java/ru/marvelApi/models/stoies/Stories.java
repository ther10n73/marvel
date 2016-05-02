package ru.marvelApi.models.stoies;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataImpl;
import ru.marvelApi.models.data.summary.ComicSummary;

/**
 * Created by Khartonov Oleg on 21.04.2016.
 */
public class Stories extends DataImpl {
    private String title;
    private String type;
    private ComicSummary originalIssue;

    public Stories(@JsonField(name = "id") String id,
                   @JsonField(name = "title") String title,
                   @JsonField(name = "description", type = "String") String description,
                   @JsonField(name = "resourceURI") String resourceURI,
                   @JsonField(name = "type") String type,
                   @JsonField(name = "modified") String modified,
                   @JsonField(name = "thumbnail") JsonElement thumbnail,
                   @JsonField(name = "comics") JsonElement comics,
                   @JsonField(name = "series") JsonElement series,
                   @JsonField(name = "events") JsonElement events,
                   @JsonField(name = "characters") JsonElement characters,
                   @JsonField(name = "creators") JsonElement creators,
                   @JsonField(name = "originalIssue") JsonElement originalIssue) {
        super.id = Integer.parseInt(id);
        this.title = title;
        super.description = description;
        super.modified = modified;
        super.resourceURI = resourceURI;
        this.type = type;
        super.setThumbnail(thumbnail);
        super.setComics(comics);
        super.setSeries(series);
        super.setEvents(events);
        super.setCreators(creators);
        super.setCharacters(characters);
        this.setOriginalIssue(originalIssue);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ComicSummary getOriginalIssue() {
        return originalIssue;
    }

    public void setOriginalIssue(JsonElement originalIssue) {
        try {
            if (!originalIssue.isJsonNull()) {
                this.originalIssue = reflection.createObject(originalIssue, ComicSummary.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Stories{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", modified=" + modified +
                ", resourceURI='" + resourceURI + '\'' +
                ", type='" + type + '\'' +
                ", thumbnail=" + thumbnail +
                ", comics=" + comics +
                ", series=" + series +
                ", events=" + events +
                ", characters=" + characters +
                ", creators=" + creators +
                ", originalIssue=" + originalIssue +
                '}';
    }
}

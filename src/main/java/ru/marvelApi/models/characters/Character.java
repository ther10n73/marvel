package ru.marvelApi.models.characters;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.Data;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class Character extends Data {
    private String name;

    public Character(@JsonField(name = "id")String id,
                     @JsonField(name = "name")String name,
                     @JsonField(name = "description")String description,
                     @JsonField(name = "modified")String modified,
                     @JsonField(name = "resourceURI")String resourceURI,
                     @JsonField(name = "urls")JsonElement urls,
                     @JsonField(name = "thumbnail")JsonElement thumbnail,
                     @JsonField(name = "comics")JsonElement comics,
                     @JsonField(name = "stories")JsonElement stories,
                     @JsonField(name = "events")JsonElement events,
                     @JsonField(name = "series")JsonElement series) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.setUrls(urls);
        this.setThumbnail(thumbnail);
        this.setComics(comics);
        this.setStories(stories);
        this.setEvents(events);
        this.setSeries(series);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "description='" + description + '\'' +
                "modified='" + modified + '\''  +
                "resourseURI='" + resourceURI + '\'' +
                "urls='" + urls + '\'' +
                "thumbnail='" + thumbnail + '\'' +
                "comics='" + comics + '\'' +
                "stories='" + stories + '\'' +
                "events='" + events + '\'' +
                "series='" + series + '\'' +
                '}';
    }
}

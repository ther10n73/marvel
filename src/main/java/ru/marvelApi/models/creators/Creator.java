package ru.marvelApi.models.creators;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.Data;

/**
 * Created by Khartonov Oleg on 17.04.2016.
 */
public class Creator extends Data {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String fullName;

    public Creator(@JsonField(name = "firstName")String firstName, @JsonField(name = "middleName")String middleName, @JsonField(name = "lastName")String lastName, @JsonField(name = "suffix")String suffix, @JsonField(name = "fullName")String fullName, @JsonField(name = "id")String id, @JsonField(name = "description")String description, @JsonField(name = "modified")String modified, @JsonField(name = "resourceURI")String resourceURI, @JsonField(name = "urls")JsonElement urls, @JsonField(name = "thumbnail")JsonElement thumbnail, @JsonField(name = "comics")JsonElement comics, @JsonField(name = "stories")JsonElement stories, @JsonField(name = "events")JsonElement events, @JsonField(name = "series")JsonElement series) {
        this.id = Integer.parseInt(id);
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.setUrls(urls);
        this.setThumbnail(thumbnail);
        this.setComics(comics);
        this.setStories(stories);
        this.setEvents(events);
        this.setSeries(series);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.fullName = fullName;
    }
}

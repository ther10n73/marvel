package ru.marvelApi.models.characters;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.Data;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class Character extends Data {
    private String name;

    public Character(@JsonField(name = "id")String id, @JsonField(name = "name")String name, @JsonField(name = "description")String description, @JsonField(name = "modified")String modified, @JsonField(name = "resourceURI")String resourceURI, @JsonField(name = "urls")JsonElement urls, @JsonField(name = "thumbnail")JsonElement thumbnail, @JsonField(name = "comics")JsonElement comics, @JsonField(name = "stories")JsonElement stories, @JsonField(name = "events")JsonElement events, @JsonField(name = "series")JsonElement series) {
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

    public String toString() {
        return "<br>Character: " + "\n</br>" +
                    "<br>id: " + id + "\n</br>" +
                    "<br>name: " + name + "\n</br>" +
                    "<br>description: " + description + "\n</br>" +
                    "<br>modified: " + modified + "\n</br>" +
                    "<br>resourceURl: " + resourceURI + "\n</br>" +
                    "<br>" + getUrls().toString() + "\n</br>" +
                    "<br>" + getThumbnail().toString() + "\n</br>" +
                    "<br>" + getComics().toString() + "\n</br>" +
                    "<br>" +  getStories().toString() + "\n</br>" +
                    "<br>" + getEvents().toString() + "\n</br>" +
                    "<br>" + getSeries().toString();
    }
}

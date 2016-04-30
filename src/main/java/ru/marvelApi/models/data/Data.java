package ru.marvelApi.models.data;

import com.google.gson.JsonElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.marvelApi.ReflectionApp;
import ru.marvelApi.models.data.list.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khartonov Oleg on 17.04.2016.
 */
public abstract class Data {
    protected int id;
    protected String description;
    protected String modified;
    protected String resourceURI;
    protected List<Url> urls;
    protected Image thumbnail;
    protected ComicList comics;
    protected StoryList stories;
    protected EventList events;
    protected SeriesList series;
    protected CreatorList creators;
    protected CharacterList characters;
    protected ReflectionApp reflection = new ReflectionApp();

    public int getId() {
        return id;
    }

    public CreatorList getCreators() {
        return creators;
    }

    public void setCreators(JsonElement creators) {
        try {
            this.creators = reflection.createObject(creators.getAsJsonObject(), CreatorList.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public CharacterList getCharacters() {
        return characters;
    }

    public void setCharacters(JsonElement characters) {
        try {
            this.characters = reflection.createObject(characters.getAsJsonObject(), CharacterList.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public SeriesList getSeries() {
        return series;
    }

    public void setSeries(JsonElement series) {
        try {
            this.series = reflection.createObject(series.getAsJsonObject(), SeriesList.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(JsonElement urls) {
        this.urls = new ArrayList<>();
        if (!urls.isJsonNull()) {
            urls.getAsJsonArray()
                    .forEach(je -> {
                        try {
                            this.urls.add(reflection.createObject(je.getAsJsonObject(), Url.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(JsonElement thumbnail) {
        try {
            if(!thumbnail.isJsonNull()) {
                this.thumbnail = reflection.createObject(thumbnail.getAsJsonObject(), Image.class);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ComicList getComics() {
        return comics;
    }

    public void setComics(JsonElement comics) {
        try {
            this.comics = reflection.createObject(comics.getAsJsonObject(), ComicList.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public StoryList getStories() {
        return stories;
    }

    public void setStories(JsonElement stories) {
        try {
            this.stories = reflection.createObject(stories.getAsJsonObject(), StoryList.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public EventList getEvents() {
        return events;
    }

    public void setEvents(JsonElement events) {
        try {
            this.events = reflection.createObject(events.getAsJsonObject(), EventList.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public abstract String toString();

    @Override
    public boolean equals(Object data) {
        return new EqualsBuilder()
                .reflectionEquals(this, data);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this)
                .toHashCode();
    }
}

package ru.marvelApi.models.data;

import com.google.gson.JsonElement;
import ru.marvelApi.models.data.list.*;

import java.util.List;

/**
 * Created by Khartonov Oleg on 02.05.2016.
 */
public interface Data {
    int getId();

    CreatorList getCreators();

    void setCreators(JsonElement creators);

    CharacterList getCharacters();

    void setCharacters(JsonElement characters);

    SeriesList getSeries();

    void setSeries(JsonElement series);

    String getDescription();

    void setDescription(String description);

    String getModified();

    void setModified(String modified);

    String getResourceURI();

    void setResourceURI(String resourceURI);

    List<Url> getUrls();

    void setUrls(JsonElement urls);

    Image getThumbnail();

    void setThumbnail(JsonElement thumbnail);

    ComicList getComics();

    void setComics(JsonElement comics);

    StoryList getStories();

    void setStories(JsonElement stories);

    EventList getEvents();

    void setEvents(JsonElement events);

    String toString();
}

package ru.marvelApi.models.series;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.Data;
import ru.marvelApi.models.data.summary.SeriesSummary;

/**
 * Created by Khartonov Oleg on 20.04.2016.
 */
public class Series extends Data {
    private String title;
    private int startYear;
    private int endYear;
    private String rating;
    private SeriesSummary next;
    private SeriesSummary previous;

    public Series(@JsonField(name = "id")String id,
                  @JsonField(name = "title")String title,
                  @JsonField(name = "description", type = "String")String description,
                  @JsonField(name = "modified")String modified,
                  @JsonField(name = "resourceURI")String resourceURI,
                  @JsonField(name = "startYear") String startYear,
                  @JsonField(name = "endYear") String endYear,
                  @JsonField(name = "rating") String rating,
                  @JsonField(name = "urls")JsonElement urls,
                  @JsonField(name = "thumbnail")JsonElement thumbnail,
                  @JsonField(name = "comics")JsonElement comics,
                  @JsonField(name = "stories")JsonElement stories,
                  @JsonField(name = "events")JsonElement events,
                  @JsonField(name = "characters") JsonElement characters,
                  @JsonField(name = "creators")JsonElement creators,
                  @JsonField(name = "next") JsonElement next,
                  @JsonField(name = "previous") JsonElement previous) {
        super.id = Integer.parseInt(id);
        this.title = title;
        super.description = description;
        super.modified = modified;
        super.resourceURI = resourceURI;
        this.startYear = Integer.parseInt(startYear);
        this.endYear = Integer.parseInt(endYear);
        this.rating = rating;
        super.setUrls(urls);
        super.setThumbnail(thumbnail);
        super.setComics(comics);
        super.setStories(stories);
        super.setEvents(events);
        super.setCreators(creators);
        super.setCharacters(characters);
        this.setNext(next);
        this.setPrevious(previous);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public SeriesSummary getNext() {
        return next;
    }

    public void setNext(JsonElement next) {
        try {
            if (!next.isJsonNull()) {
                this.next = reflection.createObject(next, SeriesSummary.class);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
    }

    public SeriesSummary getPrevious() {
        return previous;
    }

    public void setPrevious(JsonElement previous) {
        try {
            if (!previous.isJsonNull()) {
                this.previous = reflection.createObject(previous, SeriesSummary.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return null;
    }
}

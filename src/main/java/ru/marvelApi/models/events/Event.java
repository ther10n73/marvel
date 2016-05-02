package ru.marvelApi.models.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.DataImpl;
import ru.marvelApi.models.data.summary.EventSummary;

/**
 * Created by Khartonov Oleg on 17.04.2016.
 */
public class Event extends DataImpl {
    private String title;
    private String start;
    private String end;
    private EventSummary next;
    private EventSummary previous;

    public Event (@JsonField(name = "id")String id,
                  @JsonField(name = "title")String title,
                  @JsonField(name = "description")String description,
                  @JsonField(name = "resourceURI")String resourceURI,
                  @JsonField(name = "urls")JsonElement urls,
                  @JsonField(name = "modified")String modified,
                  @JsonField(name = "start", type = "String") String start,
                  @JsonField(name = "end", type = "String") String end,
                  @JsonField(name = "thumbnail")JsonElement thumbnail,
                  @JsonField(name = "comics")JsonElement comics,
                  @JsonField(name = "stories")JsonElement stories,
                  @JsonField(name = "series")JsonElement series,
                  @JsonField(name = "characters")JsonElement characters,
                  @JsonField(name = "creators")JsonElement creators,
                  @JsonField(name = "next") JsonElement next,
                  @JsonField(name = "previous") JsonElement previous) {
        this.id = Integer.parseInt(id);
        this.title = title;
        this.description = description;
        this.modified = modified;
        this.start = start;
        this.end = end;
        this.resourceURI = resourceURI;
        this.setUrls(urls);
        this.setThumbnail(thumbnail);
        this.setComics(comics);
        this.setStories(stories);
        this.setSeries(series);
        this.setCreators(creators);
        this.setCharacters(characters);
        this.setNext(next);
        this.setPrevious(previous);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public EventSummary getNext() {
        return next;
    }

    public void setNext(JsonElement next) {
        try {
            if (!(next instanceof JsonNull)) {
                this.next = reflection.createObject(next, EventSummary.class);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public EventSummary getPrevious() {
        return previous;
    }

    public void setPrevious(JsonElement previous) {
        try {
            if (!(previous instanceof JsonNull)){
                this.previous = reflection.createObject(previous, EventSummary.class);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                ", urls=" + urls +
                ", modified=" + modified +
                ", thumbnail=" + thumbnail +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", comics=" + comics +
                ", stories=" + stories +
                ", series=" + series +
                ", characters=" + characters +
                ", creators=" + creators +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
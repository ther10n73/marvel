package ru.marvelApi.models.comics;

import com.google.gson.JsonElement;
import ru.marvelApi.annotation.JsonField;
import ru.marvelApi.models.data.Data;
import ru.marvelApi.models.data.Image;
import ru.marvelApi.models.data.summary.ComicSummary;
import ru.marvelApi.models.data.summary.SeriesSummary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class Comic extends Data {
    private int digitalId;
    private String title;
    private double issueNumber;
    private String variantDescription;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    private List<TextObject> textObjects = new ArrayList<>();
    private SeriesSummary series;
    private List<ComicSummary> variants = new ArrayList<>();
    private List<ComicSummary> collections = new ArrayList<>();
    private List<ComicSummary> collectedIssues = new ArrayList<>();
    private List<ComicDate> dates = new ArrayList<>();
    private List<ComicPrice> prices = new ArrayList<>();
    private Image thumbnail;
    private List<Image> images = new ArrayList<>();

    public Comic(@JsonField(name = "id") String id,
                 @JsonField(name = "digitalId")String digitalId,
                 @JsonField(name = "title")String title,
                 @JsonField(name = "issueNumber")String issueNumber,
                 @JsonField(name = "variantDescription")String variantDescription,
                 @JsonField(name = "description", type = "String")String description,
                 @JsonField(name = "modified")String modified,
                 @JsonField(name = "isbn")String isbn,
                 @JsonField(name = "upc")String upc,
                 @JsonField(name = "diamondCode")String diamondCode,
                 @JsonField(name = "ean")String ean,
                 @JsonField(name = "issn")String issn,
                 @JsonField(name = "format")String format,
                 @JsonField(name = "pageCount")String pageCount,
                 @JsonField(name = "textObjects")JsonElement textObjects,
                 @JsonField(name = "resourceURI")String resourceURI,
                 @JsonField(name = "urls") JsonElement urls,
                 @JsonField(name = "series")JsonElement series,
                 @JsonField(name = "variants")JsonElement variants,
                 @JsonField(name = "collections")JsonElement collections,
                 @JsonField(name = "collectedIssues")JsonElement collectedIssues,
                 @JsonField(name = "dates")JsonElement dates,
                 @JsonField(name = "prices") JsonElement prices,
                 @JsonField(name = "thumbnail")JsonElement thumbnail,
                 @JsonField(name = "images")JsonElement images,
                 @JsonField(name = "creators")JsonElement creators,
                 @JsonField(name = "characters")JsonElement characters,
                 @JsonField(name = "stories")JsonElement stories,
                 @JsonField(name = "events")JsonElement events) {
        this.id = Integer.parseInt(id);
        this.digitalId = Integer.parseInt(digitalId);
        this.title = title;
        this.issueNumber = Double.parseDouble(issueNumber);
        this.variantDescription = variantDescription;
        this.description = description;
        this.modified = modified;
        this.isbn = isbn;
        this.upc = upc;
        this.diamondCode = diamondCode;
        this.ean = ean;
        this.issn = issn;
        this.format = format;
        this.pageCount = Integer.parseInt(pageCount);
        this.setTextObjects(textObjects);
        this.resourceURI = resourceURI;
        this.setUrls(urls);
        this.setSeries(series);
        this.setVariants(variants);
        this.setCollections(collections);
        this.setCollectedIssues(collectedIssues);
        this.setDates(dates);
        this.setPrices(prices);
        this.setThumbnail(thumbnail);
        this.setImages(images);
        this.setCreators(creators);
        this.setCharacters(characters);
        this.setStories(stories);
        this.setEvents(events);
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(double issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(JsonElement textObjects) {
        textObjects.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.textObjects.add(reflection.createObject(je.getAsJsonObject(), TextObject.class));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }


    @Override
    public void setSeries(JsonElement series) {
        try {
            this.series = reflection.createObject(series.getAsJsonObject(), SeriesSummary.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ComicSummary> getVariants() {
        return variants;
    }

    public void setVariants(JsonElement variants) {
        variants.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.variants.add(reflection.createObject(je.getAsJsonObject(), ComicSummary.class));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }

    public List<ComicSummary> getCollections() {
        return collections;
    }

    public void setCollections(JsonElement collections) {
        collections.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.collections.add(reflection.createObject(je.getAsJsonObject(), ComicSummary.class));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }

    public List<ComicSummary> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(JsonElement collectedIssues) {
        collectedIssues.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.collectedIssues.add(reflection.createObject(je.getAsJsonArray(), ComicSummary.class));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }

    public List<ComicDate> getDates() {
        return dates;
    }

    public void setDates(JsonElement dates) {
        dates.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.dates.add(reflection.createObject(je.getAsJsonObject(), ComicDate.class));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }

    public List<ComicPrice> getPrices() {
        return prices;
    }

    public void setPrices(JsonElement prices) {
        prices.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.prices.add(reflection.createObject(je.getAsJsonObject(), ComicPrice.class));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
    }


    public List<Image> getImages() {
        return images;
    }

    public void setImages(JsonElement images) {
        images.getAsJsonArray()
                .forEach(je -> {
                    try {
                        this.images.add(reflection.createObject(je.getAsJsonObject(), Image.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}

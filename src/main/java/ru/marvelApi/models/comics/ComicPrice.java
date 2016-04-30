package ru.marvelApi.models.comics;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class ComicPrice {
    private String type;
    private float price;

    public ComicPrice(@JsonField(name = "type")String type, @JsonField(name = "price")String price) {
        this.type = type;
        this.price = Float.parseFloat(price);
    }

    @Override
    public String toString(){
        return "<br>Type: " + type + "</br>" +
                "<br>Price: " + price + "</br>";
    }
}

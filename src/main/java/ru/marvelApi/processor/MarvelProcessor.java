package ru.marvelApi.processor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.marvelApi.MarvelFactory;
import ru.marvelApi.models.MarvelTypes;
import ru.marvelApi.models.data.DataWrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 23.04.2016.
 */
@RestController
public class MarvelProcessor {
    private StringBuilder str = new StringBuilder();
    private MarvelFactory marvelFactory = new MarvelFactory();

    @RequestMapping("/listType/")
    public String getTypeMarvel(){
        str.append("Choose one of theme: \n\t");
        for (MarvelTypes  types: MarvelTypes.values() ){
            str.append(types.toString()).append("\n\t");
        }
        return str.toString();
    }

    @RequestMapping("/")
    public String getTestSpring() {
        return "Welcome to Marvel Library!";
    }

    @RequestMapping("/type/{type}")
    public String getThemeInfo(@PathVariable String type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DataWrapper wr = marvelFactory.createDataWrapper(type);
        return wr.getAttributionText() + wr.getData().getResults().toString();
    }
}

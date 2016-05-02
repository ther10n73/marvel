package ru.marvelApi.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.marvelApi.MarvelFactory;
import ru.marvelApi.MarvelFactoryImpl;
import ru.marvelApi.models.MarvelTypes;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 23.04.2016.
 */
@RestController
@JsonAutoDetect
public class MarvelController {
    private StringBuilder str;
    private MarvelFactory marvelFactory = new MarvelFactoryImpl();

    @RequestMapping("/listType/")
    public String getTypeMarvel(){
        str = new StringBuilder();
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
    @ResponseBody
    public String getThemeInfo(@PathVariable String type) throws Exception {
        return marvelFactory.createDataWrapper(type).getData().getResults().toString();
    }

    @RequestMapping("/type/{type}/{id}")
    public String getInfoForId(@PathVariable String type, @PathVariable int id) throws Exception {
        return String.valueOf(marvelFactory.createDataWrapper(type).getData().getResults()
                .stream()
                .filter(res -> res.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Value not found")));
    }

    @RequestMapping("/type/{type}/{id}/{typeSummary}/{titleId}")
    public String getSummary(@PathVariable String type, @PathVariable int id, @PathVariable String typeSummary) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return marvelFactory.createDataWrapper(type, id, typeSummary).getData().getResults().toString();
    }
}

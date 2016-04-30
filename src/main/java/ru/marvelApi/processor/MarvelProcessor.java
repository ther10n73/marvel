package ru.marvelApi.processor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.marvelApi.MarvelFactory;
import ru.marvelApi.models.MarvelTypes;
import ru.marvelApi.models.data.Data;
import ru.marvelApi.models.data.DataWrapper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Khartonov Oleg on 23.04.2016.
 */
@RestController
@JsonAutoDetect
public class MarvelProcessor {
    private StringBuilder str;
    private MarvelFactory marvelFactory = new MarvelFactory();

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
    public String getThemeInfo(@PathVariable String type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DataWrapper wr = marvelFactory.createDataWrapper(type);
        return wr.getData().getResults().toString();
    }

    @RequestMapping("/type/{type}/{id}")
    public @ResponseBody
    Data getInfoForId(@PathVariable String type, @PathVariable int id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DataWrapper wr = marvelFactory.createDataWrapper(type);
        return  wr.getData().getResults()
                .stream()
                .filter(res -> res.getId() == id)
                .findFirst().get();
    }

    @RequestMapping("/type/{type}/{id}/{typeSummary}/{titleId}")
    public List<Data> getSummary(@PathVariable String type, @PathVariable int id, @PathVariable String typeSummary) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DataWrapper wr = marvelFactory.createDataWrapperForOneId(type, id, typeSummary);
        return wr.getData().getResults();
    }
}

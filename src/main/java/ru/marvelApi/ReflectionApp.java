package ru.marvelApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.commons.lang3.text.WordUtils;
import ru.marvelApi.annotation.JsonField;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class ReflectionApp implements Serializable {
    public final static ReflectionApp getInstance() {
        return new ReflectionApp();
    }

    public <T> T createObject(JsonElement je, Class<T> targetType) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JsonObject jo = je.getAsJsonObject();
        Constructor<T>[] constructors = (Constructor<T>[]) targetType.getConstructors();
        switch (constructors.length){
            case 0: throw new IllegalArgumentException("Class don't have constructor");
            default: return createObjWithParams(jo, constructors[0], targetType);
        }
    }

    private <T> T createObjWithParams(JsonObject jo, Constructor<T> cntr, Class<T> targetType) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        if (cntr.getParameterCount() == 0){
           return createConstructor(jo, cntr, targetType);
        } else {
                Parameter[] parameters = cntr.getParameters();
                List<Object> param = new ArrayList<>(parameters.length);
                Stream.of(parameters)
                        .map(f -> f.getAnnotation(JsonField.class))
                        .forEach(p -> {
                            if (jo.has(p.name())) {
                                if (jo.get(p.name()).isJsonPrimitive()) {
                                    JsonPrimitive jsonPrimitive = jo.get(p.name()).getAsJsonPrimitive();
                                    param.add(jsonPrimitive.getAsString());
                                } else if (jo.get(p.name()).isJsonArray()) {
                                    JsonElement jsonArray = jo.get(p.name()).getAsJsonArray();
                                    param.add(jsonArray);
                                } else if (jo.get(p.name()).isJsonNull()){
                                    if (p.type().equals("String")){
                                        param.add("");
                                    } else {
                                        param.add(jo.get(p.name()).getAsJsonNull());
                                    }
                                } else {
                                    JsonElement jso = jo.get(p.name()).getAsJsonObject();
                                    param.add(jso);
                                }
                            } else {
                                param.add(null);
                            }
                        });
                return cntr.newInstance(param.toArray());
        }
    }

    private <T> T createConstructor(JsonObject jo,Constructor<T> constr, Class<T> targetType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T obj = constr.newInstance();

        jo.entrySet()
                .forEach(je -> {
                    final String methodName = setName(je.getKey());
                    Method method = Stream.of(targetType.getMethods())
                            .filter(m -> m.getName().equals(methodName) && m.getParameterCount() == 1)
                            .findFirst()
                            .orElseThrow(() -> new IllegalStateException("No filed: " + je.getKey()));
                    methodInvoike(je, obj, method);
                });
        return obj;
    }

    private <T> T methodInvoike (Map.Entry<String, JsonElement> je, T obj, Method method){
        try {
            Class typeClass = method.getParameterTypes()[0];
            if (typeClass == Map.class) {
                Map<String, String> map = new HashMap<>();
                JsonObject jso = je.getValue().getAsJsonObject();
                for (Map.Entry<String, JsonElement> jse : jso.entrySet()) {
                    JsonPrimitive jsi = jse.getValue().getAsJsonPrimitive();
                    map.put(jse.getKey(), jsi.getAsString());
                    method.invoke(obj, map);
                }
            } else {
                JsonPrimitive jsi = je.getValue().getAsJsonPrimitive();
                method.invoke(obj, jsi);
            }
        } catch (Exception e){
            throw new IllegalStateException("Cann't create constructor", e);
        }
        return obj;
    }

    private String fieldNameOf(String word){
        String name = WordUtils.capitalize(word, new char[]{'_'}).replaceAll("_", "");
        StringBuilder str = new StringBuilder();
        return str.append(name.toLowerCase().charAt(0)).append(name.substring(1)).toString();
    }

    private String setName(String jsonFieldNmae){
        return fieldNameOf("set_" + jsonFieldNmae);
    }

    private String getName (String jsonFieldName){
        return fieldNameOf("get_" + jsonFieldName);
    }
}

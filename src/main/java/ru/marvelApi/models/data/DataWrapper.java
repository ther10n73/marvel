package ru.marvelApi.models.data;

import com.google.gson.JsonElement;

/**
 * Created by Khartonov Oleg on 02.05.2016.
 */
public interface DataWrapper {
    String getCode();

    String getStatus();

    String getCopyright();

    String getAttributionText();

    String getAttributionHTML();

    DataContainerImpl getData();

    String getEtag();

    void setCode(String code);

    void setStatus(String status);

    void setCopyright(String copyright);

    void setAttributionText(String attributionText);

    void setAttributionHTML(String attributionHTML);

    void setData(JsonElement data) throws NoSuchMethodException;
}

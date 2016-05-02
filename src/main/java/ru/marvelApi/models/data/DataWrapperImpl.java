package ru.marvelApi.models.data;

import com.google.gson.JsonElement;
import ru.marvelApi.ReflectionApp;
import ru.marvelApi.annotation.JsonField;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public abstract class DataWrapperImpl implements DataWrapper{
    private String code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    protected DataContainerImpl data;
    private String etag;

    protected ReflectionApp reflectionApp = new ReflectionApp();

    public DataWrapperImpl(@JsonField(name = "code") String code, @JsonField(name = "status") String status, @JsonField(name = "copyright") String copyright, @JsonField(name = "attributionText") String attributionText, @JsonField(name = "attributionHTML") String attributionHTML, @JsonField(name = "data") JsonElement data, @JsonField(name = "etag") String etag) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.setData(data);
        this.etag = etag;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public DataContainerImpl getData() {
        return data;
    }

    public String getEtag() {
        return etag;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public abstract void setData(JsonElement data) throws NoSuchMethodException;

    @Override
    public String toString() {
        return "DataWrapperImpl{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", attributionText='" + attributionText + '\'' +
                ", attributionHTML='" + attributionHTML + '\'' +
                ", data=" + data +
                ", etag='" + etag + '\'' +
                ", reflectionApp=" + reflectionApp +
                '}';
    }
}

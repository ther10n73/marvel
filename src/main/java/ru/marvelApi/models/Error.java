package ru.marvelApi.models;

import java.util.Map;

/**
 * Created by Khartonov Oleg on 01.05.2016.
 */
public class Error {
    public int status;
    public String error;
    public String message;
    public String timeStamp;
    public String trace;

    public Error(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timeStamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }
}

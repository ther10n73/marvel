package ru.marvelApi.connection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class HttpConnection {
    private final String publicKey = "844af6ef6f171d2ce158675d2d20b389";
    private final String privateKey = "6bc96dfbea100d192323284edbedef1e903d3141";
    public static final String GET_INFO = "http://gateway.marvel.com/v1/public/";
    private HttpURLConnection urlConnection;
    private JsonParser parser = new JsonParser();
    public final static String TS = "1";

    public JsonObject getResponse(String uri){
        StringBuilder str = new StringBuilder();
        try {
            URL url = new URL(uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String read;
            while ((read = reader.readLine()) != null){
                str.append(read).append("\n");
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return parser.parse(str.toString()).getAsJsonObject();
    }

    public String getMd5Hash() {
        String md5Hash = DigestUtils.md5Hex(new StringBuilder().append(TS).append(privateKey).append(publicKey).toString());
        return md5Hash;
    }

    public JsonElement createParamRequests(String url) {
        StringBuilder uri = new StringBuilder();
        uri.append(url)
                .append("?ts=").append(TS)
                .append("&apikey=").append(publicKey)
                .append("&hash=").append(getMd5Hash());
        return getResponse(uri.toString());
    }
}

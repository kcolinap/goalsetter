package core.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Utils {

    private  static final Properties properties = new Properties();
    private static Actions actions;

    public static String getProperty(String property, String filename) throws IOException {
        try {
            String userDir = System.getProperty("user.dir");

            FileInputStream fis = new FileInputStream(userDir + "/src/main/resources/"+filename.toLowerCase()+".properties");
            properties.load(fis);

            return properties.getProperty(property);

        } catch (Exception | Error e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String getTestProperty(String property, String filename) throws IOException {
        try {
            String userDir = System.getProperty("user.dir");

            FileInputStream fis = new FileInputStream(userDir + "/src/test/resources/"+filename.toLowerCase()+".properties");
            properties.load(fis);

            return properties.getProperty(property);

        } catch (Exception | Error e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String getRid(String token){
        String[] parts = token.split("\\.");


       Base64.Decoder decoder =  Base64.getUrlDecoder();
        String payload = new String(decoder.decode(parts[1]));
        JsonObject  jsonObject = JsonParser.parseString(payload).getAsJsonObject();


        return String.valueOf(jsonObject.get("rid")).replace("\"", "");
    }

    public static JsonObject sortJson(JsonObject object){
        List<String> keySet = object.keySet().stream().sorted().collect(Collectors.toList());

        JsonObject ordered = new JsonObject();

        for(String key : keySet){
            JsonElement element = object.get(key);
            if(element.isJsonObject()){
                element = sortJson(element.getAsJsonObject());
                ordered.add(key, element);
            }else if (element.isJsonArray()) {
                ordered.add(key, element.getAsJsonArray());
            }else
                ordered.add(key, element.getAsJsonPrimitive());
        }

        return ordered;
    }


}

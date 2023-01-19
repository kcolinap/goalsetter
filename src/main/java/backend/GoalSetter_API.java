package backend;

import backend.dto.Login;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import core.util.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GoalSetter_API {

    private static GoalSetter_API instance;

    private static JsonParser parser = new JsonParser();

    private HashMap<String, String> queryParams = new HashMap<>();

    public synchronized static GoalSetter_API getInstance(){
        if (instance != null) {
            instance = null;
        }
        instance = new GoalSetter_API();

        return instance;
    }

    public Login postLogin(HashMap<String, String> queryParams) throws IOException {
        //Get URI
        RestAssured.baseURI= Utils.getProperty("BASE_URI", "config");


        //Make the request
        Login login =
                given().
                        header("Content-type", "application/json").
                        request().body(queryParams).
                when().
                        post(Utils.getProperty("LOGIN_ENDPOINT", "config")).
                then().
                        statusCode(200).
                        extract().as(Login.class);

        return login;
    }

    public JsonElement getParents(String rid, String token) throws IOException {
        //Get URI
        RestAssured.baseURI= Utils.getProperty("BASE_URI", "config");

        Response response =
                given().
                        header("Content-type", "application/json").
                        header("Authorization", "Bearer " + token).
                when().
                        get(Utils.getProperty("RID_ENDPOINT", "config") + rid).
                then().
                        statusCode(200).
                        extract().response();


        return JsonParser.parseString(response.getBody().asString());

    }
}

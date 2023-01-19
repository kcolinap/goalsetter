package steps;

import backend.GoalSetter_API;
import backend.dto.Login;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.util.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;


public class BackendSteps {

    private GoalSetter_API goalSetterApi;
    private static Login login;

    private static HashMap queryParams = new HashMap();

    private static String token;
    private static String rid;
    private static JsonObject jsonObject;


    @Given("User set his information")
    public void userSetHisInformation() throws IOException {
        try{

            //Fill query parameters
            queryParams.put("email", Utils.getTestProperty("email", "test"));
            queryParams.put("password", Utils.getTestProperty("password", "test"));


        }catch (Exception | Error er){
            throw er;
        }
    }

    @When("User log into the app")
    public void userLogIntoTheApp() throws IOException {
        try{

            goalSetterApi = GoalSetter_API.getInstance();


            //MAke the request
            login = goalSetterApi.postLogin(queryParams);

            token = login.getToken();

            //Get rid from token
            rid = Utils.getRid(token);


        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("Send a get request to parent endpoint")
    public void sendAGetRequestToParentEndpoint() throws IOException {
        try{

            goalSetterApi = GoalSetter_API.getInstance();

            jsonObject = goalSetterApi.getParents(rid, token).getAsJsonObject();



        }catch (Exception | Error er){
            throw er;
        }
    }

    @Then("Validate wallet balance is {double} and financial status is {string}")
    public void validateTheResponse(Double balance, String status) {
        try{

            Assert.assertEquals(jsonObject.get("walletBalance").getAsDouble(), balance);
            Assert.assertEquals(jsonObject.get("financialStatus").getAsString(), status);


        }catch (Exception | Error er){
            throw er;
        }
    }


    @And("Print sorted response")
    public void printSortedResponse() {

        try{

            System.out.println("Before sorting: " + JsonParser.parseString(jsonObject.toString()));

            System.out.println("Sorted using key: " + JsonParser.parseString(Utils.sortJson(jsonObject).getAsJsonObject().toString()));

        }catch (Exception | Error er){
            throw er;
        }
    }
}

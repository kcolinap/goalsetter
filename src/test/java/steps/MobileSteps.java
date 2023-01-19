package steps;

import core.manager.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.android.Wrapper;
import mobile.android.goalsetter.screens.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;



public class MobileSteps {


    static int INICIATED =0;
    OnBoardingScreen onBoardingScreen;
    AlertScreen alertScreen;

    LoginScreen loginScreen;

    HomeScreen homeScreen;
    MyWalletScreen myWalletScreen;
    ChildSavingScreen childSavingScreen;

    @Given("Open the app")
    public void openTheApp() throws IOException {
        try{

            if(INICIATED==0) {
                DriverManager.createDriver();
                INICIATED =1;
            }

        }catch (Exception | Error er){
            throw er;
        }
    }

    @Given("User tap on login button on main screen")
    public void userClickOnLoginButton() throws Exception {
        try{
            onBoardingScreen = OnBoardingScreen.getInstance();

            //Click on login button
            onBoardingScreen.clickLoginButton();
        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("Selects login with email")
    public void userClickOnLoginWithEmail() throws Exception {
        try{
            alertScreen = AlertScreen.getInstance();

            //Click on login with email button
            alertScreen.clickLoginWithEmail();
        }catch (Exception | Error er){
            throw er;
        }
    }

    @When("User set his email")
    public void setAnEmailAs() throws Exception {
        try{
            loginScreen = LoginScreen.getInstance();

            //User set his email
            loginScreen.setCredential("email");

        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("User set his password")
    public void setAPasswordAs() throws Exception {
        try{
            loginScreen = LoginScreen.getInstance();

            //User set his password
            loginScreen.setCredential("password");

        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("Tap on login button")
    public void tapOnLoginButton() throws Exception {
        try{
            loginScreen = LoginScreen.getInstance();

            //Tap login button
            loginScreen.clickLogin();

        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("Tap on wallet button")
    public void tapOnWalletButton() throws Exception {
        try{
            homeScreen = HomeScreen.getInstance();

            //Tap wallet button
            homeScreen.cliokOnWallet();

        }catch (Exception | Error er){
            throw er;
        }
    }

    @Then("Validate header {string}")
    public void validateHeader(String compare) throws Exception {
        try{
            myWalletScreen = MyWalletScreen.getInstance();

            //Assertion on header
            Assert.assertEquals(Wrapper.getElementText(MyWalletScreen.getLblMyWallet()), compare);

        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("Validate there is {int} on wallet")
    public void validateThereIs$(int amount) throws Exception {
        try{
            myWalletScreen = MyWalletScreen.getInstance();

            //Assertion on amount label
           Assert.assertTrue(Wrapper.isDisplayed(DriverManager.getDriver().findElement(By.xpath(
                   "//*[@text='$" + String.valueOf(amount) + "']"
           ))));

        }catch (Exception | Error er){
            throw er;
        }
    }

    @Given("Reset App")
    public void resetApp() {
        try {
            DriverManager.driver.terminateApp("com.goalsetter");
            DriverManager.driver.activateApp("com.goalsetter");

            if(!DriverManager.getDriver().currentActivity().contains("goalsetter"))
                DriverManager.getDriver().activateApp("com.goalsetter");

        }catch (Exception | Error er){
            throw er;
        }
    }

    @And("Tap on savings first child")
    public void tapOnSavingsStChild() throws Exception {
        try {
           homeScreen = HomeScreen.getInstance();


            DriverManager.getDriver().findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"ALLOWANCE\"))")).
                    getText();

            homeScreen.clickOnSavings();
        }catch (Exception | Error er){
            throw er;
        }
    }

    @Then("Validate child savings header")
    public void validateChildSavingsHeader() throws Exception {
        childSavingScreen = ChildSavingScreen.getInstance();


        Assert.assertTrue(Wrapper.isDisplayed(ChildSavingScreen.getLblTitle()));

        Assert.assertTrue(Wrapper.isDisplayed(ChildSavingScreen.getLblSubTitle()));
    }

    @And("Close the app")
    public void closeTheApp() throws Exception {
        try {
           DriverManager.getDriver().quit();
        }catch (Exception | Error er){
            throw er;
        }
    }
}

package mobile.android.goalsetter.screens;

import core.manager.DriverManager;
import core.util.Utils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.android.Wrapper;
import mobile.android.goalsetter.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginScreen extends BaseScreen {

    private static LoginScreen sSoleInstance;
    //@FindBy(xpath="//android.widget.EditText[@content_desc='TEXT-InputEmail']")
    @FindBy(xpath = "(//android.widget.EditText)[1]")
    private static WebElement txtEmail;

    @FindBy(xpath="(//android.widget.EditText)[2]")
    private static WebElement txtPassword;

    @FindBy(xpath="//android.widget.TextView[@text='LOGIN']")
    private static WebElement btnLogin;



    public LoginScreen(){
        super();
        wait.until(driver -> btnLogin.isDisplayed());
    }

    public synchronized static LoginScreen getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new LoginScreen();
        else {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), LoginScreen.class);
            wait.until(driver -> btnLogin.isDisplayed());
        }


        return sSoleInstance;
    }

    public void setCredential(String credential) throws IOException {

        if(credential.equalsIgnoreCase("email"))
            Wrapper.setTextOn(Utils.getTestProperty("email", "test"), txtEmail);
        else if (credential.equalsIgnoreCase("password"))
            Wrapper.setTextOn(Utils.getTestProperty("password", "test"), txtPassword);
    }

    public void clickLogin(){
        Wrapper.clickOn(btnLogin);
    }
}

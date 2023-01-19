package mobile.android.goalsetter.screens;

import core.manager.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.android.Wrapper;
import mobile.android.goalsetter.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertScreen extends BaseScreen {

    private static AlertScreen sSoleInstance;
    @FindBy(xpath="//android.widget.TextView[@text='Login with email']")
    private static WebElement btnLoginEmail;

    public AlertScreen(){
        super();
        wait.until(driver -> btnLoginEmail.isDisplayed());
    }

    public synchronized static AlertScreen getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new AlertScreen();
        else {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), AlertScreen.class);
            wait.until(driver -> btnLoginEmail.isDisplayed());
        }


        return sSoleInstance;
    }

    public void clickLoginWithEmail(){
        Wrapper.clickOn(btnLoginEmail);
    }
}

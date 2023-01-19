package mobile.android.goalsetter.screens;

import core.manager.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.android.Wrapper;
import mobile.android.goalsetter.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnBoardingScreen extends BaseScreen {

    private static OnBoardingScreen sSoleInstance;
    @FindBy(xpath="//android.widget.TextView[@text='LOG IN']")
    private static WebElement BtnLoginId;

    @AndroidFindBy(id="BtnSignUpId")
    private WebElement btnSignUp;


    public OnBoardingScreen(){
        super();
        wait.until(driver -> BtnLoginId.isDisplayed());
    }

    public synchronized static OnBoardingScreen getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new OnBoardingScreen();
        else {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), OnBoardingScreen.class);
            wait.until(driver -> BtnLoginId.isDisplayed());
        }


        return sSoleInstance;
    }

    public void clickLoginButton(){
        Wrapper.clickOn(BtnLoginId);
    }
}

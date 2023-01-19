package mobile.android.goalsetter.screens;

import core.manager.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.android.Wrapper;
import mobile.android.goalsetter.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends BaseScreen {

    private static HomeScreen sSoleInstance;
    @FindBy(xpath="//android.widget.TextView[@content-desc='TEXT-Welcome']")
    private static WebElement lblWelcome;

    @FindBy(xpath="//android.widget.TextView[@text='WALLET']")
    private static WebElement btnWallet;

    @FindBy(xpath="//android.widget.TextView[@text='SAVINGS']")
    private static WebElement btnSavings;



    public HomeScreen(){
        super();
        wait.until(driver -> lblWelcome.isDisplayed());
    }

    public synchronized static HomeScreen getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new HomeScreen();
        else {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), HomeScreen.class);
            wait.until(driver -> lblWelcome.isDisplayed());
        }


        return sSoleInstance;
    }

    public void cliokOnWallet(){
        Wrapper.clickOn(btnWallet);
    }

    public void clickOnSavings(){
        Wrapper.clickOn(btnSavings);
    }

}

package mobile.android.goalsetter.screens;

import core.manager.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.android.Wrapper;
import mobile.android.goalsetter.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildSavingScreen extends BaseScreen {

    static final String headerText= "Germancito's Savings";
    private static ChildSavingScreen sSoleInstance;
    @FindBy(xpath="//android.widget.TextView[contains(@text,'Germancito') and contains(@text, 'Savings')]")
    private static WebElement lblTitle;

    @FindBy(xpath="//android.widget.TextView[@text='$germancito0355']")
    private static WebElement lblSubTitle;




    public ChildSavingScreen(){
        super();
        wait.until(driver -> lblTitle.isDisplayed());
    }

    public synchronized static ChildSavingScreen getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new ChildSavingScreen();
        else {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), ChildSavingScreen.class);
            wait.until(driver -> lblTitle.isDisplayed());
        }


        return sSoleInstance;
    }

    public static WebElement getLblTitle() {
        return lblTitle;
    }

    public static WebElement getLblSubTitle() {
        return lblSubTitle;
    }
}

package mobile.android.goalsetter.screens;

import core.manager.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.android.Wrapper;
import mobile.android.goalsetter.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWalletScreen extends BaseScreen {

    private static MyWalletScreen sSoleInstance;
    @FindBy(xpath="//android.widget.TextView[@text='My Wallet']")
    private static WebElement lblMyWallet;



    public MyWalletScreen(){
        super();
        wait.until(driver -> lblMyWallet.isDisplayed());
    }

    public synchronized static MyWalletScreen getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new MyWalletScreen();
        else {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), MyWalletScreen.class);
            wait.until(driver -> lblMyWallet.isDisplayed());
        }


        return sSoleInstance;
    }

    public static WebElement getLblMyWallet() {
        return lblMyWallet;
    }
}

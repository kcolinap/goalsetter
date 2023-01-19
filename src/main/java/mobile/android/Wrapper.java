package mobile.android;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Wrapper {

    public static void clickOn(WebElement element){
        element.click();
    }

    public static void setTextOn(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public static String getElementText(WebElement element){
        return element.getText();
    }

    public static boolean isDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException err){
            return false;
        }
    }
}

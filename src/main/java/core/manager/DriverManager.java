package core.manager;

import core.util.Utils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverManager {

    private static HashMap<String, URL> hosts;

    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String APP_NAME;
    public static String PLATFORM_NAME;
    public static String PLATFORM_VERSION;
    public static String AUTOMATION_NAME;
    public static String DEVICE_NAME;

    public static AndroidDriver driver;

    public static void createDriver() throws MalformedURLException{
        try{
            DEVICE_NAME = Utils.getProperty("device.name", "app");
            driver = new AndroidDriver(host(DEVICE_NAME), getCaps());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static URL host(String deviceID) throws MalformedURLException {
        if (hosts == null) {
            hosts = new HashMap<String, URL>();
            hosts.put(deviceID, new URL("http://127.0.0.1:4723/wd/hub"));
        }
        return hosts.get(deviceID);
    }

    private static DesiredCapabilities getCaps() throws IOException {

        loadConfigProp("app");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformVersion", PLATFORM_VERSION);
        caps.setCapability("platformName", PLATFORM_NAME);
        caps.setCapability("deviceName", DEVICE_NAME);
        caps.setCapability("automationName", AUTOMATION_NAME);
        caps.setCapability("app", APP_NAME);
        caps.setCapability("appPackage", "com.goalsetter");
        caps.setCapability("appActivity", "com.goalsetter.MainActivity");

        return caps;
    }


    public static void loadConfigProp(String propertyFileName) throws IOException {

        EXPLICIT_WAIT_TIME = Integer.parseInt(Utils.getProperty("explicit.wait", propertyFileName));
        DEFAULT_WAIT_TIME = Integer.parseInt(Utils.getProperty("default.wait", propertyFileName));
        IMPLICIT_WAIT_TIME = Integer.parseInt(Utils.getProperty("implicit.wait", propertyFileName));
        APP_NAME = System.getProperty("user.dir") + Utils.getProperty("app.path",propertyFileName);
        PLATFORM_NAME = Utils.getProperty("platform.name", propertyFileName);
        DEVICE_NAME = Utils.getProperty("device.name", propertyFileName);
        PLATFORM_VERSION = Utils.getProperty("platform.version", propertyFileName);
        AUTOMATION_NAME = Utils.getProperty("automationName", propertyFileName);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}

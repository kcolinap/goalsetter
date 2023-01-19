package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@CucumberOptions(
        features = {"classpath:features/"},
        plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"steps"},
        tags = "not @ignore",
        publish = true,
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public static void setUp() throws IOException {
        System.out.println("INIT");
    }

    @AfterSuite
    public static void tearDown(){
        System.out.println("FINISh");;
    }

}
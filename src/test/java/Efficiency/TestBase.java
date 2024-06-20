package Efficiency;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestBase {
    protected static WebDriver driver;

    @BeforeSuite(description = "Set up driver.")
    @Parameters({"environment", "browser"})
    public void preConditions(String environment, String browser){
        Configuration.timeout = 8000;


        BrowserDriverFactory bdf = new BrowserDriverFactory();
        driver = bdf.createDriver(browser);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterSuite
    public void clearSelenideListener(){
        WebDriverRunner.getWebDriver().quit();
    }
}

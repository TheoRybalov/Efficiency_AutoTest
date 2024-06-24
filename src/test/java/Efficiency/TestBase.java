package Efficiency;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {
    protected static WebDriver driver;
    protected String env;

    @BeforeClass(description = "Set up driver.")
    @Parameters({"environment", "browser"})
    public void preConditions(String environment, String browser){
        Configuration.timeout = 8000;

        this.env = environment;
        BrowserDriverFactory bdf = new BrowserDriverFactory();
        driver = bdf.createDriver(browser, environment);

        WebDriverRunner.setWebDriver(driver);
    }

    public String getEnv(){
        return env;
    }

    @AfterClass
    public void clearSelenideListener(){
        WebDriverRunner.getWebDriver().quit();
    }
}

package Efficiency;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import net.lightbody.bmp.BrowserMobProxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.UnknownHostException;

public class TestBase {
    public static WebDriver driver;
    protected String env;
    protected String md;
    protected BrowserMobProxy proxy;
    @BeforeClass(description = "Set up driver.")
    @Parameters({"environment", "browser", "mode", "proxy"})
    public void preConditions(String environment, String browser, String mode, @Optional("false") boolean proxy) throws UnknownHostException {
        Configuration.timeout = 8000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        this.env = environment;
        this.md = mode;
        BrowserDriverFactory bdf = new BrowserDriverFactory();
        driver = bdf.createDriver(browser, environment, mode, proxy);
        this.proxy = bdf.getProxy();



        WebDriverRunner.setWebDriver(driver);
    }

    public String getEnv(){
        return env;
    }
    public String getMode(){return md;};


    @AfterClass
    public void clearSelenideListener(){
        SelenideLogger.removeListener("AllureSelenide");
        WebDriverRunner.getWebDriver().quit();
        if (proxy != null) {
            proxy.stop();
        }
    }
}

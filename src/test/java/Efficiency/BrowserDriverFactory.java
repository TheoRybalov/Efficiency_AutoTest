package Efficiency;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
public class BrowserDriverFactory {

    private WebDriver driver = null;

    public WebDriver createDriver(String browser, String environment) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.out.println("Starting " + browser + " locally");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        switch (environment.toLowerCase()) {
            case "pc":
                driver.manage().window().setSize(new Dimension(1920, 1080));
                break;
            case "tablet":
                driver.manage().window().setSize(new Dimension(1024, 768));
                break;
            case "phone":
                driver.manage().window().setSize(new Dimension(640, 360));
                break;
            default:
                throw new IllegalArgumentException("Неверный тип устройства: " + environment);
        }

        driver.manage().deleteAllCookies();
        return driver;
    }

    public WebDriver createPhoneDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.out.println("Starting " + browser + " locally");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().setSize(new Dimension(992, 1920));
        driver.manage().deleteAllCookies();
        return driver;
    }
}

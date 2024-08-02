package Efficiency;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import java.io.File;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class  BrowserDriverFactory {

    private WebDriver driver = null;
    public BrowserMobProxy proxy;
    private Proxy seleniumProxy;


    public WebDriver createDriver(String browser, String environment, String mode, boolean useProxy) throws UnknownHostException {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.out.println("Starting " + browser + " locally");

                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                ChromeOptions options = new ChromeOptions();
                if(useProxy){proxy = new BrowserMobProxyServer();
                    proxy.start(8080);
                    seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
                    String hostIp = Inet4Address.getLocalHost().getHostAddress();
                    seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
                    seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
                    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

                    options.setProxy(seleniumProxy);
                    options.setAcceptInsecureCerts(true);}

                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-background-networking");


                if (mode.equals("headless")) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");

                    String downloadDir = getDownloadDirectory() + File.separator + "pdf";
                    File dir = new File(downloadDir);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }


                    chromePrefs.put("download.default_directory", downloadDir);
                    chromePrefs.put("download.prompt_for_download", false);
                    chromePrefs.put("plugins.always_open_pdf_externally", true); // Добавлено для принудительного сохранения PDF
                    options.setExperimentalOption("prefs", chromePrefs);

                    options.addArguments("--disable-pdf-viewer");
                }

                switch (environment.toLowerCase()) {
                    case "phone":
                        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 11; SM-G991B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.210 Mobile Safari/537.36");
                        break;
                    case "tablet":
                        options.addArguments("--user-agent=Mozilla/5.0 (iPad; CPU OS 14_7_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/92.0.4515.90 Mobile/15E148 Safari/604.1");
                        break;
                    case "pc":
                        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный тип устройства: " + environment);
                }

                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().setSize(getDimensionForEnvironment(environment));
        driver.manage().deleteAllCookies();
        return driver;
    }



    private Dimension getDimensionForEnvironment(String environment) {
        Map<String, Dimension> environmentDimensions = Map.of(
                "pc", new Dimension(1920, 1080),
                "tablet", new Dimension(768, 1024),
                "phone", new Dimension(390, 884)
        );

        if (environmentDimensions.containsKey(environment.toLowerCase())) {
            return environmentDimensions.get(environment.toLowerCase());
        } else {
            throw new IllegalArgumentException("Неверный тип устройства: " + environment);
        }
    }

    private String getDownloadDirectory() {
        String projectDir = System.getProperty("user.dir");
        return projectDir + File.separator + "src" + File.separator + "test" + File.separator + "resources";
    }


    public BrowserMobProxy getProxy() {
        return proxy;
    }

}

package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage extends CommonFunctions {

    //header
    private static final SelenideElement WebSiteLabel = $x("//*[@id=\"root\"]/div/header/div[1]/span");
    private static final SelenideElement ServicesLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[1]/a");
    private static final SelenideElement IndustriesLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[2]/a");
    private static final SelenideElement EnterpriseLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[3]/a");
    private static final SelenideElement ProvidersLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[4]/a");
    private static final SelenideElement AboutProjectLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[5]/span/span");
    public static final SelenideElement VideoAboutPlatformButton = $x("//*[@id=\"root\"]/div/main/section[1]/div/div/div[1]/div[4]");
    private HashMap<String, SelenideElement> selenideElementHashMap;
    public SelenideElement getHeaderElement(String key) {
        //Creating hash-map, like key-value List to get elements
        selenideElementHashMap = new HashMap<>();
        selenideElementHashMap.put("webSiteLabel", WebSiteLabel);
        selenideElementHashMap.put("servicesLink", ServicesLink);
        selenideElementHashMap.put("industriesLink", IndustriesLink);
        selenideElementHashMap.put("enterpriseLink", EnterpriseLink);
        selenideElementHashMap.put("providersLink", ProvidersLink);
        selenideElementHashMap.put("aboutProjectLink", AboutProjectLink);

        return selenideElementHashMap.get(key).shouldBe(visible);
    }

    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/industries/PC/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/industries/phone/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }

        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfFullPage(screenshotPath);
    }

    public void TakeScreenshotOfVideoButton(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/current_video_button.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/reference_video_button.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }

        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(VideoAboutPlatformButton, screenshotPath);
    }






}

package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ContactsPage extends CommonFunctions {
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");

    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }

    @Step("Создание скриншота всей страницы")
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfFullPage(screenshotPath);
    }
    public boolean compareScreenshotsOfFullPage(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/differences.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }
}

package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ServicesPage extends CommonFunctions {
    private static final SelenideElement MainHeader = $x("//*[@id=\"root\"]/div/main/div/div/div/div/h1");

    private static final SelenideElement cookieButton = $x("//*[@id=\"rcc-confirm-button\"]");

    @Step("Принимаем куки")
    public void AcceptCookie(){cookieButton.shouldBe(visible).getText();}

    @Step("Скриншот страницы полностью")
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;

        switch (environment){
            case "PC":
                screenshotPath = ("src/test/resources/screenshots/services/PC/current.png");
                break;
            case "phone":
                screenshotPath = ("src/test/resources/screenshots/services/phone/current.png");
                break;
            case "tablet":
                screenshotPath = ("src/test/resources/screenshots/services/tablet/current.png");
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);

        }
        super.TakeScreenshotOfFullPage(screenshotPath);
        }

    @Step("Сравниваем скриншоты полных страниц")
    public boolean CompareScreenshotsOfFullPage(String environment) throws IOException {
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment){
            case"PC":
                screenshotPath = "src/test/resources/screenshots/services/PC/current.png";
                referencePath = "src/test/resources/screenshots/services/PC/reference.png";
                resultPath = "src/test/resources/screenshots/services/PC/result.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/services/phone/current.png";
                referencePath = "src/test/resources/screenshots/services/phone/reference.png";
                resultPath = "src/test/resources/screenshots/services/phone/result.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/services/tablet/current.png";
                referencePath = "src/test/resources/screenshots/services/tablet/reference.png";
                resultPath = "src/test/resources/screenshots/services/tablet/result.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);

        }
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);


    }


    public void HeaderVisible(){
        Assert.assertEquals(MainHeader.shouldBe(visible).getText(), "Сервисы");
    }
}

package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AboutProjectPage extends CommonFunctions {

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
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/AboutProjectPage/PC/FullPage/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/AboutProjectPage/phone/FullPage/current.png";
                break;
            case "tablet":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/AboutProjectPage/tablet/FullPage/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }

        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfFullPage(screenshotPath);
    }

    public boolean compareScreenshotsOfFullPage(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/AboutProjectPage/PC/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/AboutProjectPage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/AboutProjectPage/PC/FullPage/differences.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/AboutProjectPage/phone/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/AboutProjectPage/phone/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/AboutProjectPage/phone/FullPage/differences.png";
                break;
            case "tablet":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/AboutProjectPage/tablet/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/AboutProjectPage/tablet/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/AboutProjectPage/tablet/FullPage/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }
}

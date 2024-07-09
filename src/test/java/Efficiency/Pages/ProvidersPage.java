package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProvidersPage extends CommonFunctions {
    //Заполнить анкету поставщика
    public static final SelenideElement ProviderFormLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/div/div/a");

    //Стать поставщиком
    public static final SelenideElement BecomeAProviderLink = $x("//*[@id=\"root\"]/div/main/div/article/section[1]/div/div/div/div/div/div[1]/a");

    //Вход для поставщика
    public static final SelenideElement LoginAsProviderLink = $x("//*[@id=\"root\"]/div/main/div/article/section[1]/div/div/div/div/div/div[2]/a");
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");
    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }

    @Step("Проверка редиректа по ссылке 'Заполнить анкету поставщика'")
    public void ProviderFormLink_Redirect(){
        Assert.assertEquals(ProviderFormLink.getText(), "Заполнить анкету поставщика", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ProviderFormLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Vendor");
    }

    @Step("Проверка редиректа по ссылке 'Стать поставщиком'")
    public void BecomeAProviderLink_Redirect(){
        Assert.assertEquals(BecomeAProviderLink.getText(), "Стать поставщиком", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(BecomeAProviderLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Vendor");
    }

    @Step("Проверка редиректа по ссылке 'Вход для поставщика'")
    public void LoginAsProviderLink_Redirect(){
        Assert.assertEquals(LoginAsProviderLink.getText(), "Вход для поставщика", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(LoginAsProviderLink, "https://aksis.dev.qsupport.ru/partner");
    }

    @Step("Создание скриншота всей страницы")
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/ProvidersPage/PC/FullPage/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/ProvidersPage/phone/FullPage/current.png";
                break;
            case "tablet":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/ProvidersPage/tablet/FullPage/current.png";
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
                screenshotPath = "src/test/resources/screenshots/ProvidersPage/PC/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ProvidersPage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ProvidersPage/PC/FullPage/differences.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/ProvidersPage/phone/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ProvidersPage/phone/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ProvidersPage/phone/FullPage/differences.png";
                break;
            case "tablet":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/ProvidersPage/tablet/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ProvidersPage/tablet/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ProvidersPage/tablet/FullPage/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }
}

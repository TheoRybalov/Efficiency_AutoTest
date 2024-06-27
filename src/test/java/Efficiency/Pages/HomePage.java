package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage extends CommonFunctions {

    //header elements
    private static final SelenideElement Header_WebSiteLabel = $x("//*[@id=\"root\"]/div/header/div[1]/span");
    private static final SelenideElement Header_ServicesLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[1]/a");
    private static final SelenideElement Header_IndustriesLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[2]/a");
    private static final SelenideElement Header_EnterpriseLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[3]/a");
    private static final SelenideElement Header_ProvidersLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[4]/a");
    private static final SelenideElement Header_AboutProjectLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[5]/span/span");
    private static final SelenideElement Header_AboutProject_OptionList = $x("//div[@id='root']/div/header/div[2]/div/nav/ul/li[5]/span/div/ul");
    private static final SelenideElement Header_PressCenterLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[6]/a");

    //footer elements
    private static final SelenideElement Footer_ServicesLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[1]/ul/li[1]/a");
    private static final SelenideElement Footer_ProvidersLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[1]/ul/li[2]/a");
    private static final SelenideElement Footer_FAQLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[1]/ul/li[3]/a");

    //footer Участникам elements
    private static final SelenideElement Footer_IndustriesLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[2]/ul/li[1]/a");
    private static final SelenideElement Footer_PressCenterLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[2]/ul/li[2]/a");
    private static final SelenideElement Footer_ContactsLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[2]/ul/li[3]/a");

    //footer О проекте elements
    private static final SelenideElement Footer_BecomeParticipantLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[3]/ul/li[1]/a");
    private static final SelenideElement Footer_BecomeProviderLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[3]/ul/li[2]/a");

    //footer Подключение elements
    private static final SelenideElement Footer_VKLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[4]/ul/li[1]/a");
    private static final SelenideElement Footer_TelegramLink = $x("//*[@id=\"root\"]/div/footer/div[1]/div/div[2]/nav/ul/li[4]/ul/li[2]/a");

    //footer Контакты elements
    public static final SelenideElement VideoAboutPlatformButton = $x("//*[@id=\"root\"]/div/main/section[1]/div/div/div[1]/div[4]");
    public static final SelenideElement Carousel = $x("//*[@id=\"root\"]/div/main/section[9]");


    @Step("Создание скриншота всей страницы")
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

    @Step("Создание скриншота кнопки видео о платформе")
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
    @Step("Создание скриншота карусели")
    public void TakeScreenshotOfCarousel(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/current_carousel.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/reference_carousel.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(Carousel, screenshotPath);
    }

    @Step("Проверка редиректа по ссылке 'Сервисы' в хедере")
    public void Header_ServicesLink_Redirect(){
        Assert.assertEquals(Header_ServicesLink.getText(), "Сервисы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Header_ServicesLink, "https://aksis.dev.qsupport.ru/services");
    }


    @Step("Проверка редиректа по ссылке 'Отрасли' в хедере")
    public void Header_IndustriesLink_Redirect(){
        Assert.assertEquals(Header_IndustriesLink.getText(), "Отрасли", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Header_IndustriesLink, "https://aksis.dev.qsupport.ru/industries");
    }

    @Step("Проверка редиректа по ссылке 'Предприятиям' в хедере")
    public void Header_EnterpriseLink_Redirect(){
        Assert.assertEquals(Header_EnterpriseLink.getText(), "Предприятиям", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Header_EnterpriseLink, "https://aksis.dev.qsupport.ru/enterprise");
    }

    @Step("Проверка редиректа по ссылке 'Поставщикам' в хедере")
    public void Header_ProvidersLink_Redirect(){
        Assert.assertEquals(Header_ProvidersLink.getText(), "Поставщикам", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Header_ProvidersLink, "https://aksis.dev.qsupport.ru/providers");
    }

    @Step("Проверка отображения выпадающего списка по наведению на ссылку 'О проекте' в хедере")
    public void Header_AboutProjectLink_Redirect(){
        Assert.assertEquals(Header_AboutProjectLink.getText(), "О проекте", "Текст элемента не соответствует заданному");
        Header_AboutProjectLink.hover();
        Header_AboutProject_OptionList.shouldBe(visible);
    }

    @Step("Проверка редиректа по ссылке 'Пресс-центр' в хедере")
    public void Header_PressCenterLink_Redirect(){
        Assert.assertEquals(Header_PressCenterLink.getText(), "Пресс-центр", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Header_PressCenterLink, "https://aksis.dev.qsupport.ru/press-center");
    }

    @Step("Проверка редиректа по ссылке 'Сервисы' в футере")
    public void Footer_ServicesLink_Redirect(){
        Assert.assertEquals(Footer_ServicesLink.getText(), "Сервисы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Footer_ServicesLink, "https://aksis.dev.qsupport.ru/services");
    }

    @Step("Проверка редиректа по ссылке 'Поставщикам' в футере")
    public void Footer_ProvidersLink_Redirect(){
        Assert.assertEquals(Footer_ProvidersLink.getText(), "Поставщикам", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Footer_ProvidersLink, "https://aksis.dev.qsupport.ru/providers");
    }

    @Step("Проверка редиректа по ссылке 'Вопросы и ответы' в футере")
    public void Footer_FAQLink(){
        Assert.assertEquals(Footer_FAQLink.getText(), "Вопросы и ответы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Footer_FAQLink, "https://aksis.dev.qsupport.ru/faq");
    }

    @Step("Проверка редиректа по ссылке 'Отрасли' в футере")
    public void Footer_IndustriesLink_Redirect(){
        Assert.assertEquals(Footer_IndustriesLink.getText(), "Отрасли", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Footer_IndustriesLink, "https://aksis.dev.qsupport.ru/industries");
    }

    @Step("Проверка редиректа по ссылке 'Пресс-центр' в футере")
    public void Footer_PressCenterLink_Redirect(){
        Assert.assertEquals(Footer_PressCenterLink.getText(), "Пресс-центр", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Footer_PressCenterLink, "https://aksis.dev.qsupport.ru/press-center");
    }

    @Step("Проверка редиректа по ссылке 'Контакты' в футере")
    public void Footer_ContactsLink_Redirect(){
        Assert.assertEquals(Footer_ContactsLink.getText(), "Контакты", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Footer_ContactsLink, "https://aksis.dev.qsupport.ru/contacts");
    }

    @Step("Проверка редиректа по ссылке 'Стать участником' в футере")
    public void Footer_BecomeParticipantLink_Redirect(){
        Assert.assertEquals(Footer_BecomeParticipantLink.getText(), "Стать участником", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link( Footer_BecomeParticipantLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Company");
    }

    @Step("Проверка редиректа по ссылке 'Стать поставщиком' в футере")
    public void Footer_BecomeProviderLink_Redirect(){
        Assert.assertEquals(Footer_BecomeProviderLink.getText(), "Стать поставщиком", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(Footer_BecomeProviderLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Vendor");
    }

    @Step("Проверка редиректа по ссылке 'Вконтакте' в футере")
    public void Footer_VKLink_Redirect(){
        Assert.assertEquals(Footer_VKLink.getText(), "Вконтакте", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(Footer_VKLink, "https://vk.com/public210761653");
    }

    @Step("Проверка редиректа по ссылке 'Telegram' в футере")
    public void Footer_TelegramLink_Redirect(){
        Assert.assertEquals(Footer_TelegramLink.getText(), "Telegram", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(Footer_TelegramLink, "https://t.me/effekt_rf");
    }







}

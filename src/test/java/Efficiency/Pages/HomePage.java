package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage extends CommonFunctions {

    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");

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
    public static final SelenideElement PopupVideoWindow = $x("/html/body/div[2]/div");
    public static final SelenideElement Carousel = $x("//*[@id=\"root\"]/div/main/section[9]");

    //Наши отрасли
    private static final SelenideElement SelskoyeHozaystvoLink = $x("//*[@id=\"root\"]/div/main/section[8]/ul/li[1]/a");
    private static final SelenideElement ManufacrturingIndustriesLink = $x("//*[@id=\"root\"]/div/main/section[8]/ul/li[2]/a");
    private static final SelenideElement ConstructionLink = $x("//*[@id=\"root\"]/div/main/section[8]/ul/li[3]/a");
    private static final SelenideElement TradingLink = $x("//*[@id=\"root\"]/div/main/section[8]/ul/li[4]/a");
    private static final SelenideElement TransportLink = $x("//*[@id=\"root\"]/div/main/section[8]/ul/li[5]/a");

    //Путь цифровой трансформации
    private static final SelenideElement Transformation_StrategyServiceLink = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[1]/article/div/header/div/a");
    private static final SelenideElement Transformation_InitiationServiceLink = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[2]/article/div/header/div/a");
    private static final SelenideElement Transformation_FinancingServiceLink = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[3]/article/div/header/div/a");
    private static final SelenideElement Transformation_ImplementationServiceLink = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[4]/article/div/header/div/a");
    private static final SelenideElement Transformation_InitiationButton = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[1]/div[2]");
    private static final SelenideElement Transformation_InitiationWindow = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[2]");
    private static final SelenideElement Transformation_FinancingButton = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[1]/div[3]");
    private static final SelenideElement Transformation_FinancingWindow = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[3]");
    private static final SelenideElement Transformation_ImplementationButton = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[1]/div[4]");
    private static final SelenideElement Transformation_ImplementationWindow = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[4]");
    private static final SelenideElement Transformation_StrategyButton = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[1]/div[1]");
    private static final SelenideElement Transformation_StrategyWindow = $x("//*[@id=\"root\"]/div/main/section[4]/div/div[1]/div[2]/div[1]");

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
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/FullPage/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/phone/FullPage/current.png";
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
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/HomePage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/HomePage/PC/FullPage/differences.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/HomePage/phone/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/HomePage/phone/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/HomePage/phone/FullPage/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }


    @Step("Создание скриншота кнопки 'Смотреть видео о платформе' до наведения курсора")
    public void TakeScreenshotOfVideoButtonBeforeAnimation(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/VideoButton/current_video_button_before.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/phone/Elements/VideoButton/current_video_button_before.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(VideoAboutPlatformButton, screenshotPath);
    }

    @Step("Создание скриншота кнопки 'Смотреть видео о платформе' после наведения курсора")
    public void TakeScreenshotOfVideoButtonAfterAnimation(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/VideoButton/current_video_button_after.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/phone/Elements/VideoButton/current_video_button_after.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(VideoAboutPlatformButton, screenshotPath);
    }

    @Step("Сравнение скриншотов кнопки 'Смотреть видео о платформе' до и после наведения")
    public boolean compareScreenshotsOfVideoButton(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/HomePage/PC/Elements/VideoButton/current_video_button_before.png";
                referencePath = "src/test/resources/screenshots/HomePage/PC/Elements/VideoButton/current_video_button_after.png";
                resultPath = "src/test/resources/screenshots/HomePage/PC/Elements/VideoButton/differences.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/HomePage/phone/Elements/VideoButton/current_video_button_before.png";
                referencePath = "src/test/resources/screenshots/HomePage/phone/Elements/VideoButton/current_video_button_after.png";
                resultPath = "src/test/resources/screenshots/HomePage/phone/Elements/VideoButton/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    @Step("Навести курсор на кнопку 'Смотреть видео о платформе'")
    public void VideoAboutPlatformButton_Hover(){
        VideoAboutPlatformButton.scrollTo().shouldBe(visible).hover();
        sleep(500);
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

    //Наши отрасли
    @Step("Проверка редиректа по ссылке 'Сельское хозяйство' в разделе 'Отрасли'")
    public void SelskoyeHozaystvoLink_Redirect(){
        Assert.assertEquals(SelskoyeHozaystvoLink.getText(), "Сельское хозяйство", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(SelskoyeHozaystvoLink, "https://aksis.dev.qsupport.ru/industries/selskoye-hozaystvo");
    }
    @Step("Проверка редиректа по ссылке 'Обрабатывающая промышленность' в разделе 'Отрасли'")
    public void ManufacrturingIndustriesLink_Redirect(){
        Assert.assertEquals(ManufacrturingIndustriesLink.getText(), "Обрабатывающая промышленность", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ManufacrturingIndustriesLink, "https://aksis.dev.qsupport.ru/industries/manufacturing-industries");
    }
    @Step("Проверка редиректа по ссылке 'Строительство' в разделе 'Отрасли'")
    public void ConstructionLink_Redirect(){
        Assert.assertEquals(ConstructionLink.getText(), "Строительство", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ConstructionLink, "https://aksis.dev.qsupport.ru/industries/construction");
    }
    @Step("Проверка редиректа по ссылке 'Торговля' в разделе 'Отрасли'")
    public void TradingLink_Redirect(){
        Assert.assertEquals(TradingLink.getText(), "Торговля", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(TradingLink, "https://aksis.dev.qsupport.ru/industries/trading");
    }
    @Step("Проверка редиректа по ссылке 'Транспортировка и хранение' в разделе 'Отрасли'")
    public void TransportLink_Redirect(){
        Assert.assertEquals(TransportLink.getText(), "Транспортировка и хранение", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(TransportLink, "https://aksis.dev.qsupport.ru/industries/transport");
    }

    @Step("Проверка редиректа по ссылке 'Подробнее о сервисах платформы' в разделе 'Стратегия'")
    public void TransformationStrategyServiceLink_Redirect(){
        Transformation_ImplementationButton.scrollTo().shouldBe(visible).click();
        Transformation_StrategyButton.scrollTo().shouldBe(visible).click();
        Assert.assertEquals(Transformation_StrategyServiceLink.getText(), "Подробнее о сервисах платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Transformation_StrategyServiceLink, "https://aksis.dev.qsupport.ru/services");
    }
    @Step("Проверка редиректа по ссылке 'Подробнее о сервисах платформы' в разделе 'Инициация'")
    public void TransformationInitiationServiceLink_Redirect(){
        Transformation_InitiationButton.scrollTo().shouldBe(visible).click();
        Assert.assertEquals(Transformation_InitiationServiceLink.getText(), "Подробнее о сервисах платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Transformation_InitiationServiceLink, "https://aksis.dev.qsupport.ru/services");
    }
    @Step("Проверка редиректа по ссылке 'Подробнее о сервисах платформы' в разделе 'Финансирование'")
    public void TransformationFinancingServiceLink_Redirect(){
        Transformation_FinancingButton.scrollTo().shouldBe(visible).click();
        Assert.assertEquals(Transformation_FinancingServiceLink.getText(), "Подробнее о сервисах платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Transformation_FinancingServiceLink, "https://aksis.dev.qsupport.ru/services");
    }
    @Step("Проверка редиректа по ссылке 'Подробнее о сервисах платформы' в разделе 'Реализация'")
    public void TransformationImplementationServiceLink_Redirect(){
        Transformation_ImplementationButton.scrollTo().shouldBe(visible).click();
        Assert.assertEquals(Transformation_ImplementationServiceLink.getText(), "Подробнее о сервисах платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Transformation_ImplementationServiceLink, "https://aksis.dev.qsupport.ru/services");
    }

    @Step("Проверка работоспособности кнопки 'Смотреть видео о платформе'")
    public void VideoAboutPlatformButton_Performance(){
        VideoAboutPlatformButton.scrollTo().shouldBe(visible).click();
        sleep(500);
        PopupVideoWindow.shouldBe(visible);
    }
    @Step("Проверка отображения данных по нажатию 'Инициализация'")
    public void TransformationInitiation_Visible(){
        Transformation_InitiationButton.scrollTo().shouldBe(visible).click();
        Transformation_InitiationWindow.shouldBe(visible);
    }
    @Step("Проверка отображения данных по нажатию 'Финансирование'")
    public void TransformationFinancing_Visible(){
        Transformation_FinancingButton.scrollTo().shouldBe(visible).click();
        Transformation_FinancingWindow.shouldBe(visible);
    }
    @Step("Проверка отображения данных по нажатию 'Реализация'")
    public void TransformationImplementation_Visible(){
        Transformation_ImplementationButton.scrollTo().shouldBe(visible).click();
        Transformation_ImplementationWindow.shouldBe(visible);
    }
    @Step("Проверка отображения данных по нажатию 'Стратегия'")
    public void TransformationStrategy_Visible(){
        Transformation_ImplementationButton.scrollTo().shouldBe(visible).click();
        Transformation_StrategyButton.scrollTo().shouldBe(visible).click();
        Transformation_StrategyWindow.shouldBe(visible);
    }









}

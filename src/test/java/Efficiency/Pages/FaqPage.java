package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FaqPage extends CommonFunctions {
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");
    //Кнопка 'Отправить сообщение
    public static final SelenideElement SendMessageLink = $x("//*[@id=\"root\"]/div/main/div/article/footer/div/div/a");
    //Кнопка раскрытия вопроса 'С чего начать работу на платформе?'
    public static final SelenideElement StartWorkButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[1]/button");
    //Окно ответа на вопрос 'С чего начать работу на платформе?'
    public static final SelenideElement StartWorkWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[1]/div/div/div");
    //Кнопка раскрытия вопроса 'Будут ли эксперты посещать предприятие?'
    public static final SelenideElement ExpertVisitButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[2]/button");
    //Окно ответа на вопрос 'Будут ли эксперты посещать предприятие?'
    public static final SelenideElement ExpertVisitWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[3]/div/div/div");
    //Кнопка раскрытия вопроса 'В чём польза платформы?'
    public static final SelenideElement BenefitPlatformButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[3]/button");
    //Окно ответа на вопрос 'В чём польза платформы?'
    public static final SelenideElement BenefitPlatformWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[3]/div/div/div");
    //Кнопка раскрытия вопроса 'Какой опыт работы у экспертов платформы?'
    public static final SelenideElement ExpertExperienceButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[4]/button");
    //Окно ответа на вопрос 'Какой опыт работы у экспертов платформы?'
    public static final SelenideElement ExpertExperienceWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[4]/div/div/div");
    //Кнопка раскрытия вопроса 'Насколько трудозатратна работа на платформе?'
    public static final SelenideElement WorkOnPlatformButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[5]/button");
    //Окно ответа на вопрос 'Насколько трудозатратна работа на платформе?'
    public static final SelenideElement WorkOnPlatformWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[5]/div/div/div");
    //Кнопка раскрытия вопроса 'Кто может воспользоваться сервисами платформы?'
    public static final SelenideElement WhoUsePlatformButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[6]/button");
    //Окно ответа на вопрос 'Кто может воспользоваться сервисами платформы?'
    public static final SelenideElement WhoUsePlatformWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[6]/div/div/div");
    //Ссылка в ответе 'Кто может воспользоваться сервисами платформы?'
    public static final SelenideElement WhoUsePlatformLink = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[6]/div/div/div/div/p[2]/a");
    //Кнопка раскрытия вопроса 'Для каких специалистов предназначена платформа?'
    public static final SelenideElement PurposePlatformButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[7]/button");
    //Окно ответа на вопрос 'Для каких специалистов предназначена платформа?'
    public static final SelenideElement PurposePlatformWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[7]/div/div/div");
    //Кнопка раскрытия вопроса 'Обязательно ли выполнять рекомендации платформы?'
    public static final SelenideElement PlatformRecommendationsButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[8]/button");
    //Окно ответа на вопрос 'Обязательно ли выполнять рекомендации платформы?'
    public static final SelenideElement PlatformRecommendationsWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[8]/div/div/div");
    //Ссылка в вопросе 'Обязательно ли выполнять рекомендации платформы?'
    public static final SelenideElement PlatformRecommendationsLink = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[8]/div/div/div/div/p/a");
    //Кнопка раскрытия вопроса 'Как получить доступ к платформе и экспертной поддержке?'
    public static final SelenideElement ConnectionPlatformButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[9]/button");
    //Окно ответа на вопрос 'Как получить доступ к платформе и экспертной поддержке?'
    public static final SelenideElement ConnectionPlatformWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[9]/div/div/div");
    //Кнопка раскрытия вопроса 'Есть ли на платформе примеры российских аналогов зарубежного ПО??'
    public static final SelenideElement AnalogsButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[10]/button");
    //Окно ответа на вопрос 'Есть ли на платформе примеры российских аналогов зарубежного ПО??'
    public static final SelenideElement AnalogsWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[10]/div/div/div");
    //Кнопка раскрытия вопроса 'Нужна ли рабочая группа от предприятия для взаимодействия с платформой?'
    public static final SelenideElement WorkingGroupButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[11]/button");
    //Окно ответа на вопрос 'Нужна ли рабочая группа от предприятия для взаимодействия с платформой?'
    public static final SelenideElement WorkingGroupWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[11]/div/div/div");
    //Кнопка раскрытия вопроса 'Если предприятие уже цифровизируется, чем платформа может быть полезна?'
    public static final SelenideElement DigitalizationButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[12]/button");
    //Окно ответа на вопрос 'Если предприятие уже цифровизируется, чем платформа может быть полезна?'
    public static final SelenideElement DigitalizationWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[12]/div/div/div");
    //Кнопка раскрытия вопроса 'Если предприятие полностью перестраивает бизнес, будет ли платформа полезна?'
    public static final SelenideElement OveragingBusinessButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[13]/button");
    //Окно ответа на вопрос 'Если предприятие полностью перестраивает бизнес, будет ли платформа полезна?'
    public static final SelenideElement OveragingBusinessWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[13]/div/div/div");
    //Кнопка раскрытия вопроса 'У предприятия нет бюджета на внедрение ИТ-решений. Как платформа может помочь?'
    public static final SelenideElement BudgetButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[14]/button");
    //Окно ответа на вопрос 'У предприятия нет бюджета на внедрение ИТ-решений. Как платформа может помочь?'
    public static final SelenideElement BudgetWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[14]/div/div/div");
    //Кнопка раскрытия вопроса 'Если предприятие работает по советским принципам, сможет ли платформа помочь ему?'
    public static final SelenideElement PrincipleButton = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[15]/button");
    //Окно ответа на вопрос 'Если предприятие работает по советским принципам, сможет ли платформа помочь ему?'
    public static final SelenideElement PrincipleWindow = $x("//*[@id=\"root\"]/div/main/div/article/div/div/ul/li[15]/div/div/div");


    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }

    @Step("Создание скриншота всей страницы")
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/FaqPage/PC/FullPage/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/FaqPage/phone/FullPage/current.png";
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
                screenshotPath = "src/test/resources/screenshots/FaqPage/PC/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/FaqPage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/FaqPage/PC/FullPage/differences.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/FaqPage/phone/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/FaqPage/phone/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/FaqPage/phone/FullPage/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }
    @Step("Создание скриншота всей страницы с раскрытыми вопросами")
    public void TakeScreenshotOfFullPageWithButtons(String environment) throws IOException {
        String screenshotPath = null;
        PrincipleButton.scrollTo().shouldBe(visible).click();
        StartWorkButton.scrollTo().shouldBe(visible).click();
        ExpertVisitButton.scrollTo().shouldBe(visible).click();
        ExpertExperienceButton.scrollTo().shouldBe(visible).click();
        BenefitPlatformButton.scrollTo().shouldBe(visible).click();
        WorkOnPlatformButton.scrollTo().shouldBe(visible).click();
        WhoUsePlatformButton.scrollTo().shouldBe(visible).click();
        PurposePlatformButton.scrollTo().shouldBe(visible).click();
        PlatformRecommendationsButton.scrollTo().shouldBe(visible).click();
        ConnectionPlatformButton.scrollTo().shouldBe(visible).click();
        AnalogsButton.scrollTo().shouldBe(visible).click();
        DigitalizationButton.scrollTo().shouldBe(visible).click();
        OveragingBusinessButton.scrollTo().shouldBe(visible).click();
        WorkingGroupButton.scrollTo().shouldBe(visible).click();
        BudgetButton.scrollTo().shouldBe(visible).click();
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/FaqPage/PC/FullPage/current_with_buttons.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/FaqPage/phone/FullPage/current_with_buttons.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfFullPage(screenshotPath);
    }
    @Step("Сравнение скриншотов страницы с раскрытми кнопками вопросов")
    public boolean compareScreenshotsOfWithButtons(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/FaqPage/PC/FullPage/current_with_buttons.png";
                referencePath = "src/test/resources/screenshots/FaqPage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/FaqPage/PC/FullPage/differences.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/HomePage/phone/FullPage/current_with_buttons.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }

        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    @Step("Проверка редиректа по ссылке 'Отправить сообщение'")
    public void SendMessageLink_Redirect(){
        Assert.assertEquals(SendMessageLink.getText(), "Отправить сообщение", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(SendMessageLink, "https://aksis.dev.qsupport.ru/contacts#feedback");
    }

    @Step
    public void PlatformRecommendationsLink_Redirect(){
        PlatformRecommendationsButton.scrollTo().shouldBe(visible).click();
        Assert.assertEquals(PlatformRecommendationsLink.getText(), "офертой", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(PlatformRecommendationsLink, "https://qua-storage-qp.xn--b1afjhrgvdfla9hb.xn--p1ai/minpromtorg_catalog/upload/contents/645/Offer_Company.pdf");
    }

    @Step
    public void WhoUsePlatformLink_Redirect(){
        WhoUsePlatformButton.scrollTo().shouldBe(visible).click();
        Assert.assertEquals(WhoUsePlatformLink.getText(), "Правила подачи заявки на участие в нацпроекте \"Производительность труда\".", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(WhoUsePlatformLink, "https://qua-storage-qp.xn--b1afjhrgvdfla9hb.xn--p1ai/minpromtorg_catalog/upload/images/%D0%94%D0%BE%D0%BA%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B%20%D1%8D%D1%84%D1%84%D0%B5%D0%BA%D1%82%D0%B8%D0%B2%D0%BD%D0%BE%D1%81%D1%82%D1%8C.%D1%80%D1%84/%D0%9F%D0%BE%D0%B4%D0%B0%D1%87%D0%B0_%D0%B7%D0%B0%D1%8F%D0%B2%D0%BA%D0%B8_%D0%B2_%D0%BD%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82_%D0%9F%D1%80%D0%BE%D0%B8%D0%B7%D0%B2%D0%BE%D0%B4%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C_%D1%82%D1%80%D1%83%D0%B4%D0%B0_.pdf");
    }

    @Step
    public void StartWorkQuestion_Visible(){
        StartWorkButton.scrollTo().shouldBe(visible).click();
        StartWorkWindow.shouldBe(visible);
    }

    @Step
    public void ExpertVisitQuestion_Visible(){
        ExpertVisitButton.scrollTo().shouldBe(visible).click();
        ExpertVisitWindow.shouldBe(visible);
    }

    @Step
    public void ExpertExperienceQuestion_Visible(){
        ExpertExperienceButton.scrollTo().shouldBe(visible).click();
        ExpertExperienceWindow.shouldBe(visible);
    }

    @Step
    public void BenefitPlatformQuestion_Visible(){
        BenefitPlatformButton.scrollTo().shouldBe(visible).click();
        BenefitPlatformWindow.shouldBe(visible);
    }

    @Step
    public void WorkOnPlatformQuestion_Visible(){
        WorkOnPlatformButton.scrollTo().shouldBe(visible).click();
        WorkOnPlatformWindow.shouldBe(visible);
    }

    @Step
    public void WhoUsePlatformQuestion_Visible(){
        WhoUsePlatformButton.scrollTo().shouldBe(visible).click();
        WhoUsePlatformWindow.shouldBe(visible);
    }

    @Step
    public void PurposePlatformQuestion_Visible(){
        PurposePlatformButton.scrollTo().shouldBe(visible).click();
        PurposePlatformWindow.shouldBe(visible);
    }

    @Step
    public void PlatformRecommendationsQuestion_Visible(){
        PlatformRecommendationsButton.scrollTo().shouldBe(visible).click();
        PlatformRecommendationsWindow.shouldBe(visible);
    }

    @Step
    public void ConnectionPlatformQuestion_Visible(){
        ConnectionPlatformButton.scrollTo().shouldBe(visible).click();
        ConnectionPlatformWindow.shouldBe(visible);
    }

    @Step
    public void AnalogsQuestion_Visible(){
        AnalogsButton.scrollTo().shouldBe(visible).click();
        AnalogsWindow.shouldBe(visible);
    }

    @Step
    public void WorkingGroupQuestion_Visible(){
        WorkingGroupButton.scrollTo().shouldBe(visible).click();
        WorkingGroupWindow.shouldBe(visible);
    }

    @Step
    public void DigitalizationQuestion_Visible(){
        DigitalizationButton.scrollTo().shouldBe(visible).click();
        DigitalizationWindow.shouldBe(visible);
    }

    @Step
    public void OveragingBusinessQuestion_Visible(){
        OveragingBusinessButton.scrollTo().shouldBe(visible).click();
        OveragingBusinessWindow.shouldBe(visible);
    }

    @Step
    public void BudgetQuestion_Visible(){
        BudgetButton.scrollTo().shouldBe(visible).click();
        BudgetWindow.shouldBe(visible);
    }

    @Step
    public void PrincipleQuestion_Visible(){
        PrincipleButton.scrollTo().shouldBe(visible).click();
        PrincipleWindow.shouldBe(visible);
    }
}

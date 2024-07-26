package Efficiency.Pages.AuthorizedZone;

import Efficiency.AuthorizedCommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static Efficiency.Providers.ConfigProviderInterface.baseURL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HomeExpertPage extends AuthorizedCommonFunctions {

    private static final SelenideElement Solutions_Showcase_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[1]/span");
    private static final SelenideElement Solutions_Showcase_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[2]/dl/dt");
    private static final SelenideElement Solutions_Showcase_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[2]/dl/dd");
    private Map<String, Object> SolutionsWidgetData = new HashMap<>();
    private static final SelenideElement Chat_Statistic_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[1]/span");
    private static final SelenideElement Chat_Statistic_Unread_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[1]/dt");
    private static final SelenideElement Chat_Statistic_Unread_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[1]/dd");
    private static final SelenideElement Chat_Statistic_Unanswered_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[2]/dt");
    private static final SelenideElement Chat_Statistic_Unanswered_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[2]/dd");
    private Map<String, Object> ChatStatisticWidgetData = new HashMap<>();
    private static final SelenideElement Counter_Agent_Section = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[2]/div/div/div/div");

    @Step("Получить данные из API для виджета Витрина решений")
    public void getSolutionsWidgetDataFromApi() {
        Map<String, Object> apiData = super.getMyFeedWidgetDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/SolutionsShowcaseWidget/GetSolutionsShowcase");
        SolutionsWidgetData.putAll(apiData);
    }

    @Step("Получить информацию о виджете Витрина решений из базы данных")
    public void getSolutionsWidgetDataFromDB() throws SQLException {
        Map<String, Object> dbData = super.getDataFromDB("public.content_30771", "741670");
        SolutionsWidgetData.putAll(dbData);
    }

    @Step("Проверка корректности заголовка виджета Витрина решений")
    public void Assert_MyFeed_Solutions_Header(){
        Solutions_Showcase_Header.scrollTo().shouldBe(visible);
        String actualTitle = Solutions_Showcase_Header.getText();
        String expectedTitle = (String) SolutionsWidgetData.get("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности текстового содержания виджета Витрина решений")
    public void Assert_MyFeed_Solutions_Text(){
        Solutions_Showcase_Text.scrollTo().shouldBe(visible);
        String actualTitle = Solutions_Showcase_Text.getText();
        String expectedTitle = (String) SolutionsWidgetData.get("text");
        Assert.assertEquals(actualTitle, expectedTitle, "Содержание не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности общего количества решений в виджете Витрина решений")
    public void Assert_MyFeed_Solutions_Quantity(){
        Solutions_Showcase_Quantity.scrollTo().shouldBe(visible);
        int actualQuantity = Integer.parseInt(Solutions_Showcase_Quantity.getText());
        int expectedQuantity = (int) SolutionsWidgetData.get("totalCount");

        Assert.assertEquals(actualQuantity, expectedQuantity, "Общее количество решений не соответствует ожидаемому значению.");
    }

    @Step("Проверка отображения виджета 'Контур Фокус'")
    public void Counter_Agent_Visible(){
        Counter_Agent_Section.scrollTo().shouldBe(visible);
    }

    @Step("Создание скриншота футера")
    public void TakeScreenshotOfCounterAgentSection(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/HomeExpertPage/PC/Elements/CounterAgentSection/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/HomeExpertPage/tablet/Elements/CounterAgentSection/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/HomeExpertPage/phone/Elements/CounterAgentSection/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfElement(Counter_Agent_Section, screenshotPath);
    }

    @Step("Сравнение скриншотов кнопки 'Смотреть видео о платформе' до и после наведения")
    public boolean compareScreenshotsOfCounterAgent(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/HomeExpertPage/PC/Elements/CounterAgentSection/current.png";
                referencePath = "src/test/resources/screenshots/HomeExpertPage/PC/Elements/CounterAgentSection/reference.png";
                resultPath = "src/test/resources/screenshots/HomeExpertPage/PC/Elements/CounterAgentSection/differences.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/HomeExpertPage/phone/Elements/CounterAgentSection/current.png";
                referencePath = "src/test/resources/screenshots/HomeExpertPage/phone/Elements/CounterAgentSection/reference.png";
                resultPath = "src/test/resources/screenshots/HomeExpertPage/phone/Elements/CounterAgentSection/differences.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/HomeExpertPage/tablet/Elements/CounterAgentSection/current.png";
                referencePath = "src/test/resources/screenshots/HomeExpertPage/tablet/Elements/CounterAgentSection/reference.png";
                resultPath = "src/test/resources/screenshots/HomeExpertPage/tablet/Elements/CounterAgentSection/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }
    @Step("Получить данные из API для виджета 'Сообщения в чате'")
    public void getChatStatisticWidgetDataFromApi() {
        Map<String, Object> apiData = super.getMyFeedWidgetDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/ChatStatisticWidget/GetChatStatistic");
        ChatStatisticWidgetData.putAll(apiData);
    }

    @Step("Получить информацию о виджете 'Сообщения в чате' из базы данных")
    public void getChatStatisticWidgetDataFromDB() throws SQLException {
        Map<String, Object> dbData = super.getDataFromDB("public.content_30779", "741691");
        ChatStatisticWidgetData.putAll(dbData);
    }

    @Step("Проверка корректности заголовка виджета 'Сообщения в чате'")
    public void Assert_MyFeed_ChatStatistic_Header(){
        Chat_Statistic_Header.scrollTo().shouldBe(visible);
        String actualTitle = Chat_Statistic_Header.getText();
        String expectedTitle = "Сообщения в чате";
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности текстового содержания виджета 'Сообщения в чате'")
    public void Assert_MyFeed_ChatStatistic_Unread_Text(){
        Chat_Statistic_Unread_Text.scrollTo().shouldBe(visible);
        String actualTitle = Chat_Statistic_Unread_Text.getText();
        String expectedTitle = (String) ChatStatisticWidgetData.get("newmessagecounttitle");
        Assert.assertEquals(actualTitle, expectedTitle, "Содержание не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности текстового содержания виджета 'Сообщения в чате'")
    public void Assert_MyFeed_ChatStatistic_Unanswered_Text(){
        Chat_Statistic_Unanswered_Text.scrollTo().shouldBe(visible);
        String actualTitle = Chat_Statistic_Unanswered_Text.getText();
        String expectedTitle = (String) ChatStatisticWidgetData.get("unansweredcounttitle");
        Assert.assertEquals(actualTitle, expectedTitle, "Содержание не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности общего количества решений в виджете 'Сообщения в чате'")
    public void Assert_MyFeed_ChatStatistic_Unread_Quantity(){
        Chat_Statistic_Unread_Quantity.scrollTo().shouldBe(visible);
        int actualQuantity = Integer.parseInt(Chat_Statistic_Unread_Quantity.getText());
        int expectedQuantity = (int) ChatStatisticWidgetData.get("newMessageCount");

        Assert.assertEquals(actualQuantity, expectedQuantity, "Общее количество непрочитанных сообщений не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности общего количества решений в виджете 'Сообщения в чате'")
    public void Assert_MyFeed_ChatStatistic_Unanswered_Quantity(){
        Chat_Statistic_Unanswered_Quantity.scrollTo().shouldBe(visible);
        int actualQuantity = Integer.parseInt(Chat_Statistic_Unanswered_Quantity.getText());
        int expectedQuantity = (int) ChatStatisticWidgetData.get("unansweredCount");

        Assert.assertEquals(actualQuantity, expectedQuantity, "Общее количество неотвеченных сообщений не соответствует ожидаемому значению.");
    }

}

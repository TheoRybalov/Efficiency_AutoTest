package Efficiency.Pages.AuthorizedZone;

import Efficiency.AuthorizedCommonFunctions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Efficiency.Providers.ConfigProviderInterface.baseURL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomeExpertPage extends AuthorizedCommonFunctions {

    //Боковое меню
    private static final ElementsCollection SideMenu_Widgets = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[1]/ul/li");
    private static final ElementsCollection SideMenu_Widgets_hrefs = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[1]/ul/li/a");
    private static final ElementsCollection SideMenu_Services = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[2]/div/div/div[1]/div/ul/li");
    private static final ElementsCollection SideMenu_Services_hrefs = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[2]/div/div/div[1]/div/ul/a");
    private Map<String, Object> SideMenuData = new HashMap<>();

    //Виджет "Витрина решений"
    private static final SelenideElement Solutions_Showcase_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[1]/span");
    private static final SelenideElement Solutions_Showcase_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[2]/dl/dt");
    private static final SelenideElement Solutions_Showcase_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[2]/dl/dd");
    private Map<String, Object> SolutionsWidgetData = new HashMap<>();

    //Виджет общее количество чатов
    private static final SelenideElement Chat_Statistic_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[1]/span");
    private static final SelenideElement Chat_Statistic_Unread_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[1]/dt");
    private static final SelenideElement Chat_Statistic_Unread_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[1]/dd");
    private static final SelenideElement Chat_Statistic_Unanswered_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[2]/dt");
    private static final SelenideElement Chat_Statistic_Unanswered_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[2]/div/div[2]/dl[2]/dd");
    private Map<String, Object> ChatStatisticWidgetData = new HashMap<>();

    //Виджет Рекомендуемая статья
    private static final SelenideElement MyFeed_RecommendedArticle_Title = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[7]/div/div[2]/div/h4/a");
    private static final SelenideElement MyFeed_RecommendedArticle_Description = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[7]/div/div[2]/div/p");
    private Map<String, Object> RecommendedArticleWidgetData = new HashMap<>();

    //Виджет Поиск в Базе знаний
    private static final SelenideElement MyFeed_KnowledgeBaseSearch_Title = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[8]/div/div[2]/div/h4");
    private static final SelenideElement MyFeed_KnowledgeBaseSearch_Input = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[8]/div/div[2]/div/div/div[2]/input");
    private static final ElementsCollection MyFeed_KnowledgeBaseSearch_items = $$x("//*[@id='root']/div/div[2]/main/div/div/div[1]/div[8]/div/div[2]/div/div[2]/div/ul/li[@class='select-list__item']");
    private Map<String, Object> KnowledgeBaseSearchWidgetData = new HashMap<>();

    //Виджет Контур Фокус
    private static final SelenideElement Counter_Agent_Section = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[2]/div/div/div/div");

    @Step("Получить данные из API для Бокового меню")
    public void getSideMenuDataFromApi() {
        Map<String, Object> apiData = super.getFullSideMenuDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/TableOfContents/Main");
        SideMenuData.putAll(apiData);

    }

    @Step("Сравнить названия из Api и на сайте для виджетов бокового меню")
    public void Assert_SideMenu_WidgetData_Titles() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("mainItems");
        SideMenu_Widgets.first().shouldBe(visible);
        for (int i = 0; i < SideMenu_Widgets.size(); i++) {
            String apiName = widgetItems.get(i).get("name");
            String elementText = SideMenu_Widgets.get(i).getText();
            Assert.assertEquals(apiName, elementText, "Название для элемента " + elementText + " не совпадает");
        }

    }

    @Step("Сравнить ссылки из Api и на сайте для виджетов бокового меню")
    public void Assert_SideMenu_WidgetData_URLs() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("mainItems");
        for (int i = 0; i < SideMenu_Widgets_hrefs.size(); i++) {
            String apiUrl = widgetItems.get(i).get("url");
            String elementUrl = SideMenu_Widgets_hrefs.get(i).getAttribute("href");
            Assert.assertEquals(apiUrl, elementUrl, "Ссылка для элемента " + SideMenu_Widgets.get(i).getText() + " не совпадает");
        }

    }


    @Step("Сравнить названия из Api и на сайте для сервисов бокового меню")
    public void Assert_SideMenu_ServicesData_Titles() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("serviceItems");
        SideMenu_Services.first().shouldBe(visible);
        for (int i = 0; i < SideMenu_Services.size(); i++) {
            String apiName = widgetItems.get(i).get("name");
            String elementText = SideMenu_Services.get(i).getText();
            Assert.assertEquals(apiName, elementText, "Название для элемента " + elementText + " не совпадает");
        }

    }

    @Step("Сравнить ссылки из Api и на сайте для сервисов бокового меню")
    public void Assert_SideMenu_ServicesData_URLs() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("serviceItems");
        for (int i = 0; i < SideMenu_Services_hrefs.size(); i++) {
            String apiUrl = widgetItems.get(i).get("url");
            String elementUrl = SideMenu_Services_hrefs.get(i).getAttribute("href");
            Assert.assertEquals(apiUrl, elementUrl, "Ссылка для элемента " + SideMenu_Widgets.get(i).getText() + " не совпадает");
        }

    }
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


    @Step("Получить данные из API для виджета Рекомендуемая статья")
    public void getRecommendedArticleWidgetDataFromApi(BrowserMobProxy proxyTest) {
        proxyTest.newHar("RecommendedArticle");
        refresh();
        sleep(1000);
        MyFeed_RecommendedArticle_Title.scrollTo().shouldBe(visible);
        Har har = proxyTest.getHar();
        Map<String, Object> responseMap = new HashMap<>();

        List<HarEntry> entries = har.getLog().getEntries();
        for (HarEntry entry : entries) {
            if (entry.getRequest().getMethod().equals("POST") &&
                    entry.getRequest().getUrl().equals("https://aksis.dev.qsupport.ru/onboarding/api/KnowledgeBaseWidget/GraphQl")) {

                String responseContent = entry.getResponse().getContent().getText();
                JSONObject jsonResponse = new JSONObject(responseContent);
                JSONObject widgetRandomArticle = jsonResponse.getJSONObject("data").getJSONObject("widgetRandomArticle");

                responseMap.put("id", widgetRandomArticle.getString("id"));
                responseMap.put("name", widgetRandomArticle.get("name").toString());
                responseMap.put("description", widgetRandomArticle.optString("description", ""));
                break;
            }
        }

        RecommendedArticleWidgetData.putAll(responseMap);

    }

    @Step("Проверка корректности заголовка статьи внутри виджета Рекомендуемая статья")
    public void Assert_MyFeed_RecommendedArticle_Title(){
        MyFeed_RecommendedArticle_Title.scrollTo().shouldBe(visible);
        String actualTitle1 = MyFeed_RecommendedArticle_Title.getText();
        String expectedTitle1 = (String) RecommendedArticleWidgetData.get("name");
        Assert.assertEquals(actualTitle1, expectedTitle1, "Текст внутри виджета не соответсвует ожидаемому значению");
    }

    @Step("Проверка корректности описания статьи внутри виджета Рекомендуемая статья")
    public void Assert_MyFeed_RecommendedArticle_Description(){
        if (MyFeed_RecommendedArticle_Description.is(visible)) {
            String actualTitle1 = MyFeed_RecommendedArticle_Description.getText();
            String expectedTitle1 = (String) RecommendedArticleWidgetData.get("description");
            Assert.assertEquals(actualTitle1, expectedTitle1, "Текст внутри виджета не соответствует ожидаемому значению");
        } else {
            System.out.println("Description в состоянии hidden, проверка не выполняется.");
        }
    }


    @Step("Получить название статьи для поиска")
    public String MyFeed_KnowledgeBaseSearch_GetArticleTitleForSearch(){
        String name = MyFeed_RecommendedArticle_Title.scrollTo().shouldBe(visible).getText();
        return name;
    }

    @Step("Получить данные из API для после ввода в поисковую строку База Знаний не пустого значения")
    public void getKnowledgeBaseSearchWidgetAfterNotEmptySearch(BrowserMobProxy proxyTest, String inputData ) {
        proxyTest.newHar("KnowledgeBaseSearch");
        MyFeed_KnowledgeBaseSearch_Input
                .scrollTo()
                .shouldBe(visible)
                .clear();
        MyFeed_KnowledgeBaseSearch_Input.sendKeys(inputData);
        sleep(3000);
        Har har = proxyTest.getHar();
        Map<String, Object> responseMap = new HashMap<>();

        List<HarEntry> entries = har.getLog().getEntries();
        // Находим последний подходящий запрос
        HarEntry targetEntry = null;
        for (int i = entries.size() - 1; i >= 0; i--) {
            HarEntry entry = entries.get(i);
            if (entry.getRequest().getMethod().equals("POST") &&
                    entry.getRequest().getUrl().equals("https://aksis.dev.qsupport.ru/onboarding/api/KnowledgeBaseWidget/GraphQl")) {
                targetEntry = entry;
                break;
            }
        }

        if (targetEntry != null) {
            String responseContent = targetEntry.getResponse().getContent().getText();
            JSONObject jsonResponse = new JSONObject(responseContent);
            JSONArray dataArray = jsonResponse.getJSONObject("data").getJSONObject("widgetCategorySearch").getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject item = dataArray.getJSONObject(i);
                responseMap.put("name_" + (i + 1), item.get("name").toString());
            }
        }

        KnowledgeBaseSearchWidgetData.putAll(responseMap);
    }

    @Step("Проверка корректности первых десяти строк в поиске Базы знаний после ввода")
    public void Assert_MyFeed_KnowledgeBaseSearch_AfterSearch(){
        for (int i = 0; i < MyFeed_KnowledgeBaseSearch_items.size(); i++) {
            String apiName = (String) KnowledgeBaseSearchWidgetData.get("name_" + (i + 1));
            String elementText = MyFeed_KnowledgeBaseSearch_items.get(i).getText();

            // Замена двойных пробелов на одинарные
            apiName = apiName.replace("  ", " ");
            elementText = elementText.replace("  ", " ");
            Assert.assertEquals(apiName, elementText, "Название элемента #" + (i + 1) + " не совпадает");
        }
    }


    @Step("Проверка отображения виджета 'Контур Фокус'")
    public void Counter_Agent_Visible(){
        Counter_Agent_Section.scrollTo().shouldBe(visible);
    }

    @Step("Создание скриншота 'Контур Фокус'")
    public void TakeScreenshotOfCounterAgentSection(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/PC/Elements/CounterAgentSection/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/tablet/Elements/CounterAgentSection/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/phone/Elements/CounterAgentSection/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfElement(Counter_Agent_Section, screenshotPath);
    }

    @Step("Сравнение скриншотов виджета Контур Фокус")
    public boolean compareScreenshotsOfCounterAgent(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/PC/Elements/CounterAgentSection/current.png";
                referencePath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/PC/Elements/CounterAgentSection/reference.png";
                resultPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/PC/Elements/CounterAgentSection/differences.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/phone/Elements/CounterAgentSection/current.png";
                referencePath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/phone/Elements/CounterAgentSection/reference.png";
                resultPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/phone/Elements/CounterAgentSection/differences.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/tablet/Elements/CounterAgentSection/current.png";
                referencePath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/tablet/Elements/CounterAgentSection/reference.png";
                resultPath = "src/test/resources/screenshots/AuthZone/HomeExpertPage/tablet/Elements/CounterAgentSection/differences.png";
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

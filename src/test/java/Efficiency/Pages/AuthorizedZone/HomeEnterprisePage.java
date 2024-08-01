package Efficiency.Pages.AuthorizedZone;

import Efficiency.AuthorizedCommonFunctions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.json.JSONArray;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import org.json.JSONObject;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class HomeEnterprisePage extends AuthorizedCommonFunctions {

    //Боковое меню
    private static final ElementsCollection SideMenu_Widgets = $$x("//*[@id='root']/div/div[2]/main/aside/div/div/nav/div/div[1]/ul/li");
    private static final ElementsCollection SideMenu_Widgets_hrefs = $$x("//*[@id='root']/div/div[2]/main/aside/div/div/nav/div/div[1]/ul/li/a");
    private static final ElementsCollection SideMenu_Services = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[2]/div/div/div[1]/div/ul/li");
    private static final ElementsCollection SideMenu_Services_hrefs = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[2]/div/div/div[1]/div/ul/a");
    private Map<String, Object> SideMenuData = new HashMap<>();

    //Моя лента

    //Виджет диагностика
    private static final SelenideElement MyFeed_Diagnostics_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/span");
    private static final SelenideElement MyFeed_Diagnostics_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/dl/dt");
    private static final SelenideElement MyFeed_Diagnostics_Percentage = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/dl/dd");
    private static final SelenideElement MyFeed_Diagnostics_Applications = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/p");
    private static final SelenideElement MyFeed_Diagnostics_href = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/a");
    private Map<String, Object> DiagnosticsWidgetData = new HashMap<>();


    //Виджет рекомендуемые анкеты
    private static final SelenideElement MyFeed_RecommendedQuestionnaires_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/span");
    private static final SelenideElement MyFeed_RecommendedQuestionnaires_Title = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[1]/h4");
    private static final SelenideElement MyFeed_RecommendedQuestionnaires_Questions = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/p");
    private static final SelenideElement MyFeed_RecommendedQuestionnaires_Duration = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/p");
    private Map<String, Object> RecommendedQuestionnairesWidgetData = new HashMap<>();


    //Виджет Бенчмаркинг
    private static final SelenideElement MyFeed_Benchmarking_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div[1]/span");
    private static final SelenideElement MyFeed_Benchmarking_companiesCount = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div[2]/dl[1]/dd");
    private static final SelenideElement MyFeed_Benchmarking_companiesByOkvedCount = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div[2]/dl[2]/dd");
    private static final SelenideElement MyFeed_Benchmarking_countText = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div[2]/dl[1]/dt");
    private static final SelenideElement MyFeed_Benchmarking_companiesbyokvedcountText = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div[2]/dl[2]/dt");
    private static final SelenideElement MyFeed_Benchmarking_href = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div[1]/a");
    private Map<String, Object> BenchmarkingWidgetData = new HashMap<>();


    //Виджет Бенчмаркинг
    private static final SelenideElement MyFeed_SolutionShowcase_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[4]/div/div[1]/span");
    private static final SelenideElement MyFeed_SolutionShowcase_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[4]/div/div[2]/dl/dt");
    private static final SelenideElement MyFeed_SolutionShowcase_Count = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[4]/div/div[2]/dl/dd");
    private static final SelenideElement MyFeed_SolutionShowcase_href = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[4]/div/div[1]/a");
    private Map<String, Object> SolutionShowcaseWidgetData = new HashMap<>();


    //Виджет Рекомендуемая статья
    private static final SelenideElement MyFeed_RecommendedArticle_Title = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[7]/div/div[2]/div/h4/a");
    private static final SelenideElement MyFeed_RecommendedArticle_Description = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[7]/div/div[2]/div/p");
    private Map<String, Object> RecommendedArticleWidgetData = new HashMap<>();

    //Виджет Поиск в Базе знаний
    private static final SelenideElement MyFeed_KnowledgeBaseSearch_Title = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[8]/div/div[2]/div/h4");
    private static final SelenideElement MyFeed_KnowledgeBaseSearch_Input = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[8]/div/div[2]/div/div/div[2]/input");
    private static final ElementsCollection MyFeed_KnowledgeBaseSearch_items = $$x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[8]/div/div[2]/div/div[2]/div/ul/li[@class='select-list__item']");
    private Map<String, Object> KnowledgeBaseSearchWidgetData = new HashMap<>();


    //Виджет контрагента 1
    private static final SelenideElement HTML_Widget_Counterparty_1 = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/div[1]");

    //Виджет контрагента 2
    private static final SelenideElement HTML_Widget_Counterparty_2 = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/div[2]");

    //Блок со столбцами из 'Проекты с Экспертной поддержкой'
    private static final SelenideElement Elemental_Support_Column_1 = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div/div/div[1]");
    private static final SelenideElement Elemental_Support_Column_2 = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div/div/div[2]");
    private static final SelenideElement Elemental_Support_Column_3 = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div/div/div[3]");
    private static final SelenideElement Elemental_Support_Column_4 = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div/div/div[4]");

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

    @Step("Получить данные из API для виджета диагностика")
    public void getDiagnosticWidgetDataFromApi() {
        Map<String, Object> apiData = super.getMyFeedWidgetDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/DiagnosticsWidget/GetDiagnostics");
        DiagnosticsWidgetData.putAll(apiData);

    }


    @Step("Получить информацию о виджете Диагностика из базы данных")
    public void getDiagnosticWidgetDataFromDB() throws SQLException {
        Map<String, Object> dbData = super.getDataFromDB("public.content_30767", "741576");
        DiagnosticsWidgetData.putAll(dbData);
    }



    @Step("Проверка корректности заголовка виджета Диагностика")
    public void Assert_MyFeed_Diagnostics_Header(){
        MyFeed_Diagnostics_Header.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_Diagnostics_Header.getText();
        String expectedTitle = (String) DiagnosticsWidgetData.get("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности текстового содержания виджета Диагностика")
    public void Assert_MyFeed_Diagnostics_Text(){
        MyFeed_Diagnostics_Text.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_Diagnostics_Text.getText();
        String expectedTitle = (String) DiagnosticsWidgetData.get("text");
        Assert.assertEquals(actualTitle, expectedTitle, "Содержание не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности ссылки виджета Диагностика")
    public void Assert_MyFeed_Diagnostics_Href(){
        String actualTitle = MyFeed_Diagnostics_href.getAttribute("href");
        String expectedTitle = (String) DiagnosticsWidgetData.get("errorhref");
        Assert.assertEquals(actualTitle, expectedTitle, "Ссылка не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности процента цифровизации в виджете Диагностика")
    public void Assert_MyFeed_Diagnostics_Percentage(){
        MyFeed_Diagnostics_Percentage.scrollTo().shouldBe(visible);

        int actualPercentage = Integer.parseInt(MyFeed_Diagnostics_Percentage.getText().replace("%", ""));
        int roundedExpectedPercentage = (int) Math.round(((Number) DiagnosticsWidgetData.get("digitalization")).doubleValue());

        Assert.assertEquals(actualPercentage, roundedExpectedPercentage, "Процент цифровизации не соответствует ожидаемому значению.");
    }

    @Step("Проверка количества анкет в виджете Диагностика")
    public void Assert_MyFeed_Diagnostics_Application(){
        MyFeed_Diagnostics_Applications.scrollTo().shouldBe(visible);

        String text = MyFeed_Diagnostics_Applications.getText();
        String[] numbers = text.replaceAll("[^0-9]+", " ").trim().split(" ");

        if (numbers.length != 2) {
            throw new IllegalArgumentException("Текст виджета не соответствует ожидаемому формату");
        }

        int firstValue = Integer.parseInt(numbers[0].trim());
        int secondValue = Integer.parseInt(numbers[1].trim());
        int difference = secondValue - firstValue;

        int expectedFirstValue = ((Number) DiagnosticsWidgetData.get("surveyTemplatesPassedCount")).intValue();
        int expectedSecondValue = ((Number) DiagnosticsWidgetData.get("surveyTemplatesAvailableCount")).intValue();

        Assert.assertEquals(firstValue, expectedFirstValue, "Значение пройденных анкет не совпало");
        Assert.assertEquals(difference, expectedSecondValue, "Значение доступных анкет не совпало");
    }




    @Step("Получить данные из API для виджета Рекомендуемые анкеты")
    public void getRecommendedQuestionnairesWidgetDataFromApi(BrowserMobProxy proxyTest) {
        proxyTest.newHar("RecommendedQuestionnaire");
        refresh();
        sleep(1000);
        MyFeed_RecommendedQuestionnaires_Header.scrollTo().shouldBe(visible);
        Har har = proxyTest.getHar();
        Map<String, Object> responseMap = new HashMap<>();

        List<HarEntry> entries = har.getLog().getEntries();
        for (HarEntry entry : entries) {
            if (entry.getRequest().getMethod().equals("GET") &&
                    entry.getRequest().getUrl().equals("https://aksis.dev.qsupport.ru/onboarding/api/QuestionnaireWidget/GetQuestionnaire")) {

                String responseContent = entry.getResponse().getContent().getText();
                JSONObject jsonResponse = new JSONObject(responseContent);

                // Извлекаем данные в соответствии с новым JSON
                JSONObject template = jsonResponse.getJSONObject("template");
                responseMap.put("name", template.getString("name"));
                responseMap.put("code", template.getString("code"));
                responseMap.put("unansweredQuestionCount", jsonResponse.getInt("unansweredQuestionCount"));
                responseMap.put("durationLeft", jsonResponse.getInt("durationLeft"));
                responseMap.put("questionsCount", jsonResponse.getInt("questionsCount"));
                responseMap.put("answeredQuestionsCount", jsonResponse.getInt("answeredQuestionsCount"));
                break;
            }
        }

        RecommendedQuestionnairesWidgetData.putAll(responseMap);
    }

    @Step("Получить информацию о виджете Рекомендуемые анкеты из базы данных")
    public void getRecommendedQuestionnairesWidgetDataFromDB() throws SQLException {
        Map<String, Object> dbData = super.getDataFromDB("public.content_30770", "741584");
        RecommendedQuestionnairesWidgetData.putAll(dbData);
    }

    @Step("Проверка корректности заголовка виджета Рекомендуемые анкеты")
    public void Assert_MyFeed_RecommendedQuestionnaires_Header(){
        MyFeed_RecommendedQuestionnaires_Header.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_RecommendedQuestionnaires_Header.getText();
        String expectedTitle = (String) RecommendedQuestionnairesWidgetData.get("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности содержания виджета Рекомендуемые анкеты")
    public void Assert_MyFeed_RecommendedQuestionnaires_Text(){
        MyFeed_RecommendedQuestionnaires_Title.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_RecommendedQuestionnaires_Title.getText();
        String expectedTitle = (String) RecommendedQuestionnairesWidgetData.get("name");

        Assert.assertEquals(actualTitle, expectedTitle, "Содержание не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности текстового содержания виджета Рекомендуемые анкеты")
    public void Assert_MyFeed_RecommendedQuestionnaires_Questions(){
        MyFeed_RecommendedQuestionnaires_Questions.shouldBe(visible);
        String text = MyFeed_RecommendedQuestionnaires_Questions.getText();

        String[] numbers = text.replaceAll("[^0-9]+", " ").trim().split(" ");

        if (numbers.length != 2) {
            throw new IllegalArgumentException("Текст не соответствует ожидаемому формату: " + text);
        }

        int answeredQuestions = Integer.parseInt(numbers[0].trim());
        int totalQuestions = Integer.parseInt(numbers[1].trim());

        int expectedTotalQuestions = ((Number) RecommendedQuestionnairesWidgetData.get("questionsCount")).intValue();
        int expectedAnsweredQuestions = Integer.parseInt((String) RecommendedQuestionnairesWidgetData.get("archive"));

        Assert.assertEquals(answeredQuestions, expectedAnsweredQuestions, "Количество отвеченных вопросов не совпало");
        Assert.assertEquals(totalQuestions, expectedTotalQuestions, "Общее количество вопросов не совпало");

    }

    @Step("Проверка корректности текстового содержания виджета Рекомендуемые анкеты")
    public void Assert_MyFeed_RecommendedQuestionnaires_Duration(){
        MyFeed_RecommendedQuestionnaires_Duration.shouldBe(visible);
        String text = MyFeed_RecommendedQuestionnaires_Duration.getText();

        String[] numbers = text.replaceAll("[^0-9]+", " ").trim().split(" ");

        if (numbers.length != 1) {
            throw new IllegalArgumentException("Текст не соответствует ожидаемому формату: " + text);
        }

        int duration = Integer.parseInt(numbers[0].trim());

        int expectedDuration = ((Number) RecommendedQuestionnairesWidgetData.get("durationLeft")).intValue();

        Assert.assertEquals(duration, expectedDuration, "Время не совпало");

    }



    @Step("Получить данные из API для виджета Бенчмаркинг")
    public void getBenchmarkingWidgetDataFromApi() {
        Map<String, Object> apiData = super.getMyFeedWidgetDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/BenchmarksWidget/GetBenchmarks");
        BenchmarkingWidgetData.putAll(apiData);

    }

    @Step("Получить информацию о виджете Бенчмаркинг из базы данных")
    public void getBenchmarkingWidgetDataFromDB() throws SQLException {
        Map<String, Object> dbData = super.getDataFromDB("public.content_30766", "741574");
        BenchmarkingWidgetData.putAll(dbData);
    }


    @Step("Проверка корректности заголовка виджета Бенчмаркинг")
    public void Assert_MyFeed_Benchmarking_Header(){
        MyFeed_Benchmarking_Header.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_Benchmarking_Header.getText();
        String expectedTitle = (String) BenchmarkingWidgetData.get("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок не соответствует ожидаемому значению.");
    }


    @Step("Проверка корректности текста внутри виджета Бенчмаркинг")
    public void Assert_MyFeed_Benchmarking_Text(){
        MyFeed_Benchmarking_countText.scrollTo().shouldBe(visible);
        String actualTitle1 = MyFeed_Benchmarking_countText.getText();
        String expectedTitle1 = (String) BenchmarkingWidgetData.get("companiescounttext");
        Assert.assertEquals(actualTitle1, expectedTitle1, "Текст первого абзаца не соответсвует ожидаемому значению");

        MyFeed_Benchmarking_companiesbyokvedcountText.scrollTo().shouldBe(visible);
        String actualTitle2 = MyFeed_Benchmarking_companiesbyokvedcountText.getText();
        String expectedTitle2 = (String) BenchmarkingWidgetData.get("companiesbyokvedcounttext");
        Assert.assertEquals(actualTitle2, expectedTitle2, "Текст второго абзаца не соответсвует ожидаемому значению");
    }


    @Step("Проверка корректности отображения общего количества предприятий внутри виджета Бенчмаркинг")
    public void Assert_MyFeed_Benchmarking_companiesCount(){
        MyFeed_Benchmarking_companiesCount.scrollTo().shouldBe(visible);
        int actualCompaniesCount = Integer.parseInt(MyFeed_Benchmarking_companiesCount.getText().replace(" ", ""));
        int expectedCompaniesCount = (Integer) BenchmarkingWidgetData.get("companiesCount");
        Assert.assertEquals(actualCompaniesCount, expectedCompaniesCount, "Общее количество предприятий не соответсвует ожидаемому значению");

    }


    @Step("Проверка корректности отображения общего количества предприятий из вашей отрасли внутри виджета Бенчмаркинг")
    public void Assert_MyFeed_Benchmarking_companiesByOkvedCount(){
        MyFeed_Benchmarking_companiesByOkvedCount.scrollTo().shouldBe(visible);
        int actualCompaniesCount = Integer.parseInt(MyFeed_Benchmarking_companiesByOkvedCount.getText().replace(" ", ""));
        int expectedCompaniesCount = (Integer) BenchmarkingWidgetData.get("companiesByOkvedCount");
        Assert.assertEquals(actualCompaniesCount, expectedCompaniesCount, "Общее количество предприятий из вашей отрасли не соответсвует ожидаемому значению");

    }

    @Step("Проверка корректности ссылки виджета Бенчмаркинг")
    public void Assert_MyFeed_Benchmarking_Href(){
        String actualTitle = MyFeed_Benchmarking_href.getAttribute("href");
        String expectedTitle = (String) DiagnosticsWidgetData.get("errorhref");
        Assert.assertEquals(actualTitle, expectedTitle, "Ссылка не соответствует ожидаемому значению.");
    }


    @Step("Получить данные из API для виджета Витрина решений")
    public void getSolutionShowcaseWidgetDataFromApi() {
        Map<String, Object> apiData = super.getMyFeedWidgetDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/SolutionsShowcaseWidget/GetSolutionsShowcase");
        SolutionShowcaseWidgetData.putAll(apiData);

//        for (String key : SolutionShowcaseWidgetData.keySet()) {
//            Object value = SolutionShowcaseWidgetData.get(key);
//            System.out.println(key + " " + value);
//        }

    }

    @Step("Получить информацию о виджете Витрина решений из базы данных")
    public void getSolutionShowcaseWidgetDataFromDB() throws SQLException {
        Map<String, Object> dbData = super.getDataFromDB("public.content_30771", "741586");
        SolutionShowcaseWidgetData.putAll(dbData);

    }


    @Step("Проверка корректности заголовка виджета Витрина решений")
    public void Assert_MyFeed_SolutionShowcase_Header(){
        MyFeed_SolutionShowcase_Header.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_SolutionShowcase_Header.getText();
        String expectedTitle = (String) SolutionShowcaseWidgetData.get("title");
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок не соответствует ожидаемому значению.");
    }


    @Step("Проверка корректности текста внутри виджета Витрина решений")
    public void Assert_MyFeed_SolutionShowcase_Text(){
        MyFeed_SolutionShowcase_Text.scrollTo().shouldBe(visible);
        String actualTitle1 = MyFeed_SolutionShowcase_Text.getText();
        String expectedTitle1 = (String) SolutionShowcaseWidgetData.get("text");
        Assert.assertEquals(actualTitle1, expectedTitle1, "Текст внутри виджета не соответсвует ожидаемому значению");
    }


    @Step("Проверка корректности отображения количества решений внутри виджета Витрина решений")
    public void Assert_MyFeed_SolutionShowcase_Count(){
        MyFeed_SolutionShowcase_Count.scrollTo().shouldBe(visible);
        int actualCompaniesCount = Integer.parseInt(MyFeed_SolutionShowcase_Count.getText());
        int expectedCompaniesCount = (Integer) SolutionShowcaseWidgetData.get("totalCount");
        Assert.assertEquals(actualCompaniesCount, expectedCompaniesCount, "Количество решений не соответсвует ожидаемому значению");

    }

    @Step("Проверка корректности ссылки виджета Витрина решений")
    public void Assert_MyFeed_SolutionShowcase_Href(){
        String actualTitle = MyFeed_SolutionShowcase_href.getAttribute("href");
        String expectedTitle = (String) SolutionShowcaseWidgetData.get("errorhref");
        Assert.assertEquals(actualTitle, expectedTitle, "Ссылка не соответствует ожидаемому значению.");
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
                responseMap.put("name", widgetRandomArticle.getString("name"));
                if (widgetRandomArticle.getString("description") != null) {
                    responseMap.put("description", widgetRandomArticle.getString("description"));
                }
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


    @Step("Создание скриншота виджета первого контрагента")
    public void TakeScreenshotOfCounterpartyWidget1(String environment) throws IOException {
        HTML_Widget_Counterparty_1.scrollTo().shouldBe(visible);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.querySelector('#layout-header').style.display = 'none';");
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget1/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget1/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget1/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(HTML_Widget_Counterparty_1, screenshotPath);
        js.executeScript("document.querySelector('#layout-header').style.display = 'block';");
    }

    @Step("Сравнение скриншотов виджета первого контрагента")
    public boolean compareScreenshotsOfCounterpartyWidget1(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget1/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget1/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget1/difference.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget1/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget1/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget1/difference.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget1/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget1/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget1/difference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }


    @Step("Создание скриншота виджета второго контрагента")
    public void TakeScreenshotOfCounterpartyWidget2(String environment) throws IOException {
        HTML_Widget_Counterparty_2.scrollTo().shouldBe(visible);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.querySelector('#layout-header').style.display = 'none';");
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget2/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget2/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget2/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(HTML_Widget_Counterparty_2, screenshotPath);
        js.executeScript("document.querySelector('#layout-header').style.display = 'block';");
    }

    @Step("Сравнение скриншотов виджета второго контрагента")
    public boolean compareScreenshotsOfCounterpartyWidget2(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget2/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget2/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/CounterpartyWidget2/difference.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget2/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget2/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/CounterpartyWidget2/difference.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget2/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget2/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/CounterpartyWidget2/difference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    @Step("Создание скриншота для первой колонки блока 'Проекты с Экспертной поддержкой'")
    public void TakeScreenshotOfElementalSupportWindow_Column1(String environment) throws IOException {
        Elemental_Support_Column_1.scrollTo().shouldBe(visible);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.querySelector('#layout-header').style.display = 'none';");
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_1/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_1/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_1/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfElement( Elemental_Support_Column_1, screenshotPath);
        js.executeScript("document.querySelector('#layout-header').style.display = 'block';");
    }

    @Step("Создание скриншота для второй колонки блока 'Проекты с Экспертной поддержкой'")
    public void TakeScreenshotOfElementalSupportWindow_Column2(String environment) throws IOException {
        Elemental_Support_Column_2.scrollTo().shouldBe(visible);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.querySelector('#layout-header').style.display = 'none';");
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_2/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_2/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_2/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfElement( Elemental_Support_Column_2, screenshotPath);
        js.executeScript("document.querySelector('#layout-header').style.display = 'block';");
    }

    @Step("Создание скриншота для третьей колонки блока 'Проекты с Экспертной поддержкой'")
    public void TakeScreenshotOfElementalSupportWindow_Column3(String environment) throws IOException {
        Elemental_Support_Column_3.scrollTo().shouldBe(visible);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.querySelector('#layout-header').style.display = 'none';");
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_3/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_3/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_3/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfElement( Elemental_Support_Column_3, screenshotPath);
        js.executeScript("document.querySelector('#layout-header').style.display = 'block';");
    }


    @Step("Создание скриншота для четвёртой колонки блока 'Проекты с Экспертной поддержкой'")
    public void TakeScreenshotOfElementalSupportWindow_Column4(String environment) throws IOException {
        Elemental_Support_Column_4.scrollTo().shouldBe(visible);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.querySelector('#layout-header').style.display = 'none';");
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_4/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_4/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_4/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfElement( Elemental_Support_Column_4, screenshotPath);
        js.executeScript("document.querySelector('#layout-header').style.display = 'block';");
    }

    @Step("Сравнение скриншота для первой колонки блока 'Проекты с Экспертной поддержкой'")
    public boolean compareScreenshotsOfElementalSupportWindow_Column1(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_1/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_1/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_1/difference.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_1/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_1/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_1/difference.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_1/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_1/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_1/difference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    @Step("Сравнение скриншота для второй колонки блока 'Проекты с Экспертной поддержкой'")
    public boolean compareScreenshotsOfElementalSupportWindow_Column2(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_2/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_2/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_2/difference.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_2/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_2/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_2/difference.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_2/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_2/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_2/difference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    @Step("Сравнение скриншота для третьей колонки блока 'Проекты с Экспертной поддержкой'")
    public boolean compareScreenshotsOfElementalSupportWindow_Column3(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_3/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_3/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_3/difference.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_3/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_3/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_3/difference.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_3/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_3/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_3/difference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    @Step("Сравнение скриншота для четвёртой колонки блока 'Проекты с Экспертной поддержкой'")
    public boolean compareScreenshotsOfElementalSupportWindow_Column4(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_4/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_4/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/PC/Elements/Elemental_Support_Column_4/difference.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_4/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_4/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/tablet/Elements/Elemental_Support_Column_4/difference.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_4/current.png";
                referencePath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_4/reference.png";
                resultPath = "src/test/resources/screenshots/AuthorizedZone/HomeEnterprisePage/phone/Elements/Elemental_Support_Column_4/difference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }















}

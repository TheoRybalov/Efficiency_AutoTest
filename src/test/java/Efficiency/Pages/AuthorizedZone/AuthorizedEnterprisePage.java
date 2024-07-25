package Efficiency.Pages.AuthorizedZone;

import Efficiency.AuthorizedCommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.restassured.RestAssured.given;

public class AuthorizedEnterprisePage extends AuthorizedCommonFunctions {















    //Моя лента
    //Виджет диагностика
    private static final SelenideElement MyFeed_Diagnostics_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/span");
    private static final SelenideElement MyFeed_Diagnostics_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/dl/dt");
    private static final SelenideElement MyFeed_Diagnostics_Percentage = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/dl/dd");
    private static final SelenideElement MyFeed_Diagnostics_Applications = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/p");
    private static final SelenideElement MyFeed_Diagnostics_href = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/a");
    private Map<String, Object> DiagnosticsWidgetData = new HashMap<>();

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


}

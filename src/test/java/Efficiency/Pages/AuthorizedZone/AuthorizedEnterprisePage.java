package Efficiency.Pages.AuthorizedZone;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import org.testng.Assert;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.restassured.RestAssured.given;

public class AuthorizedEnterprisePage extends CommonFunctions {















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




        Response response = given()
                .get("https://aksis.dev.qsupport.ru/onboarding/api/DiagnosticsWidget/GetDiagnostics");
        Assert.assertFalse(response.asString().isEmpty(), "Response is empty");
        System.out.println("Response body:");
        response.prettyPrint();



        Map<String, Object> data = response.jsonPath().getMap("");
        DiagnosticsWidgetData.put("digitalization", data.get("digitalization"));
        DiagnosticsWidgetData.put("surveyTemplatesAvailableCount", data.get("surveyTemplatesAvailableCount"));
        DiagnosticsWidgetData.put("surveyTemplatesPassedCount", data.get("surveyTemplatesPassedCount"));
    }

//    @Step("Получить информацию о новости из базы данных")
//    public void getDiagnosticWidgetDataFromDB() throws SQLException {
//        String query = "SELECT title, text, errorhref FROM public.content_30767 WHERE content_item_id = 741576";
//
//        try (Connection conn = DriverManager.getConnection(DB_URL_MINPROMTORG, DB_USER, DB_PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    DiagnosticsWidgetData.put("title", rs.getString("title"));
//                    DiagnosticsWidgetData.put("text", rs.getString("text"));
//                    DiagnosticsWidgetData.put("errorhref", rs.getString("errorhref"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Step("Получить информацию о виджете Диагностика из базы данных")
    public void getDiagnosticWidgetDataFromDB() throws SQLException {
        DiagnosticsWidgetData = super.getWidgetDataFromDB("public.content_30767", "741576");
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
        for (Map.Entry<String, Object> entry : DiagnosticsWidgetData.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }
        MyFeed_Diagnostics_Percentage.scrollTo().shouldBe(visible);
        String actualTitle = MyFeed_Diagnostics_Percentage.getText().replace("%", "");
        String expectedTitle = (String) DiagnosticsWidgetData.get("digitalization");
        Assert.assertEquals(actualTitle, expectedTitle, "Процент цифровизации не соответствует ожидаемому значению.");
    }

    @Step("Проверка количества анкет в виджете Диагностика")
    public void Assert_MyFeed_Diagnostics_Application(){
        MyFeed_Diagnostics_Applications.scrollTo().shouldBe(visible);
        String[] parts = MyFeed_Diagnostics_Percentage.getText().split(" — | из ");
        int firstValue = Integer.parseInt(parts[0]);
        int secondValue = Integer.parseInt(parts[1]);
        int difference = secondValue - firstValue;

        int expectedFirstValue = (int) DiagnosticsWidgetData.get("surveyTemplatesAvailableCount");
        int expectedSeconfValue = (int) DiagnosticsWidgetData.get("surveyTemplatesPassedCount");

        Assert.assertEquals(firstValue, expectedFirstValue, "Значение пройденных анкет не совпало");
        Assert.assertEquals(difference, expectedSeconfValue, "Значение доступных анкет не совпало");
    }


}

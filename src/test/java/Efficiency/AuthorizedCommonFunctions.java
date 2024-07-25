package Efficiency;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class AuthorizedCommonFunctions extends CommonFunctions{

    @Step("Получить данные из API для виджета")
    public Map<String, Object> getMyFeedWidgetDataFromApi(String requestURL) {

        Set<Cookie> seleniumCookies = WebDriverRunner.getWebDriver().manage().getCookies();

        // Преобразуем куки в формат RestAssured
        Map<String, String> restAssuredCookies = new HashMap<>();

        // Преобразуем куки Selenium в формат Map
        for (org.openqa.selenium.Cookie seleniumCookie : seleniumCookies) {
            restAssuredCookies.put(seleniumCookie.getName(), seleniumCookie.getValue());
        }

        Response response = given()
                .cookies(restAssuredCookies)
                .get(requestURL);
        Assert.assertFalse(response.asString().isEmpty(), "Response is empty");
        Map<String, Object> data = response.jsonPath().getMap("");
        return data;

    }

    @Step("Получить информацию о виджете из базы данных")
    public Map<String, Object> getDataFromDB(String tableName, String contentItemId) throws SQLException {

        String query = "SELECT * FROM " + tableName + " WHERE content_item_id = " + contentItemId;
        Map<String, Object> WidgetDataQP = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(DB_URL_MINPROMTORG, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int columnCount = rsMetaData.getColumnCount();

                if (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = rsMetaData.getColumnName(i);
                        Object columnValue = rs.getString(i);
                        WidgetDataQP.put(columnName, columnValue);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return WidgetDataQP;

    }

}

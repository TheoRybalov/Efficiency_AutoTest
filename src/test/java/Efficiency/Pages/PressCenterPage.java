package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PressCenterPage extends CommonFunctions {

    private static final SelenideElement News_Platform_1 = $x("//*[@id=\"news-platform\"]/div/div/div[1]/a/div/div[2]/div[1]");
    private static final SelenideElement News_Platform_2 = $x("//*[@id=\"news-platform\"]/div/div/div[2]/a/div/div[2]/div[1]");
    private static final SelenideElement News_Platform_3 = $x("//*[@id=\"news-platform\"]/div/div/div[3]/a/div/div[2]/div[1]");

    @Step("Получить первый заголовок новостей с платформы")
    public String getFirstLabelOfNewsPlatform(){
        return News_Platform_1.shouldBe(visible).getText();
    }

    @Step("Получить ID новости с API по заголовку: {title}")
    public long getIdFromApi(String title) {
        Response response = RestAssured.get("https://aksis.dev.qsupport.ru/api/PressCenter/GetNews?newsTypes=platformNews&pageSize=3");
        Assert.assertFalse(response.asString().isEmpty(), "Response is empty");

        List<Map<String, Object>> items = response.jsonPath().getList("items");
        // Ищем элемент с заданным title
        long id = items.stream()
                .filter(item -> title.equals(item.get("title")))
                .map(item -> ((Number) item.get("id")).longValue()) // Извлекаем значение "id" и преобразуем в long
                .findFirst()
                .orElseThrow(() -> new AssertionError("Информация не найдена"));

        return id;
    }

    @Step("Получить информацию о новости из базы данных по ID: {contentItemId}")
    public String getNewsTitleFromDatabase(long contentItemId) throws SQLException {
        String query = "SELECT title FROM public.content_630 WHERE content_item_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, contentItemId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("title");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new AssertionError("News title not found for contentItemId: " + contentItemId);
    }

    @Step("Сравнить новость с сайта и из базы данных")
    public void compareNewsTitles(String titleFromSite, String titleFromDB) throws SQLException {
        Assert.assertEquals(titleFromSite, titleFromDB, "Titles do not match");
    }




}

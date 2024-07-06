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
    //Ссылки: 'Материалы', 'Новости платформы', 'Новости нацпроекта', 'Контакты'
    private static final SelenideElement MaterialsLink = $x("//*[@id=\"root\"]/div/main/section[1]/header/ul/li[1]/a");
    private static final SelenideElement Header_NewsPlatformLink = $x("//*[@id=\"root\"]/div/main/section[1]/header/ul/li[2]/a");
    private static final SelenideElement NewsProjectLink = $x("//*[@id=\"root\"]/div/main/section[1]/header/ul/li[3]/a");
    private static final SelenideElement ContactsLink = $x("//*[@id=\"root\"]/div/main/section[1]/header/ul/li[4]/a");
    //Ссылки "Скачать презентацию", "Скачать видео о платформе цифровых решений", 'Рекомендации по размещению информации о платформе'
    private static final SelenideElement DownloadPresentationLink = $x("//*[@id=\"media\"]/ul/li[1]/a");
    private static final SelenideElement DownloadPlatformLink = $x("//*[@id=\"media\"]/ul/li[2]/a");
    private static final SelenideElement PostingRecommendationsLink = $x("//*[@id=\"media\"]/ul/li[3]/a");

    //Ссылка "Все новости нац проекта"
    private static final SelenideElement AllNewsProject_Link = $x("//*[@id=\"news-project\"]/footer/span/a");

    //Ссылка "Все мероприятия"
    private static final SelenideElement AllEvents_Link = $x("//*[@id=\"root\"]/div/main/section[5]/footer/span/a");

    //Ссылка "Все новости платформы"
    private  static final SelenideElement AllNewsPlatform_Link = $x("//*[@id=\"news-platform\"]/footer/span/a");

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

    @Step("Проверка редиректа по ссылке 'Материалы'")
    public void MaterialsLink_Redirect(){
        Assert.assertEquals(MaterialsLink.getText(), "Материалы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(MaterialsLink, "https://aksis.dev.qsupport.ru/press-center");
    }

    @Step("Проверка редиректа по ссылке 'Новости платформы'")
    public void Header_NewsPlatform_Redirect(){
        Assert.assertEquals(Header_NewsPlatformLink.getText(), "Новости платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(Header_NewsPlatformLink, "https://aksis.dev.qsupport.ru/press-center");
    }

    @Step("Проверка редиректа по ссылке 'Новости нацпроекта'")
    public void NewsProjectLink_Redirect(){
        Assert.assertEquals(NewsProjectLink.getText(), "Новости нацпроекта", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(NewsProjectLink, "https://aksis.dev.qsupport.ru/press-center");
    }

    @Step("Проверка редиректа по ссылке 'Контакты'")
    public void ContactsLink_Redirect(){
        Assert.assertEquals(ContactsLink.getText(), "Контакты", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ContactsLink, "https://aksis.dev.qsupport.ru/press-center");
    }

    @Step("Проверка редиректа по ссылке 'Скачать презентацию'")
    public void DownloadPresentation_Redirect(){
        Assert.assertEquals(DownloadPresentationLink.getText(), "Скачать презентацию", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(DownloadPresentationLink, "https://storage.qp.dev.qsupport.ru/minpromtorg_catalog/upload/contents/641/%D0%9E%20%D0%BF%D0%BB%D0%B0%D1%82%D1%84%D0%BE%D1%80%D0%BC%D0%B5%20%D1%8D%D1%84%D1%84%D0%B5%D0%BA%D1%82%D0%B8%D0%B2%D0%BD%D0%BE%D1%81%D1%82%D1%8C.%D1%80%D1%84.pdf");
    }

    @Step("Проверка редиректа по ссылке 'Скачать видео о платформе цифровых решений'")
    public void DownloadPlatformLink_Redirect(){
        Assert.assertEquals(DownloadPlatformLink.getText(), "Скачать видео о платформе цифровых решений", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(DownloadPlatformLink, "https://cloud.ctprf.ru/index.php/s/2a7awMlneVF2IJP");
    }

    @Step("Проверка редиректа по ссылке 'Рекомендации по размещению информации о платформе'")
    public void PostingRecommendationsLink_Redirect(){
        Assert.assertEquals(PostingRecommendationsLink.getText(), "Рекомендации по размещению информации о платформе", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(PostingRecommendationsLink, "https://cloud.ctprf.ru/index.php/s/P9aESRtr2L1rx2d");
    }

    @Step("Проверка редиректа по ссылке 'Все новости'")
    public void AllNewsPlatform_Link_Redirect(){
        Assert.assertEquals(AllNewsPlatform_Link.getText(), "Все новости платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(AllNewsPlatform_Link, "https://aksis.dev.qsupport.ru/news?category=platformNews");
    }

    @Step("Проверка редиректа по ссылке 'Все новости нацпроекта'")
    public void AllNewsProject_Link_Redirect(){
        Assert.assertEquals(AllNewsProject_Link.getText(), "Все новости нацпроекта", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(AllNewsProject_Link, "https://aksis.dev.qsupport.ru/news?category=projectNews");
    }

    @Step("Проверка редиректа по ссылке 'Все мероприятия'")
    public void AllEvents_Link_Redirect(){
        Assert.assertEquals(AllEvents_Link.getText(), "Все мероприятия", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(AllEvents_Link,"https://aksis.dev.qsupport.ru/events");
    }
}

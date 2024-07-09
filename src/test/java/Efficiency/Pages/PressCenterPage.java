package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class PressCenterPage extends CommonFunctions {

    //Разделы на странице
    private static final SelenideElement PressCenterSection = $x("//*[@id=\"root\"]/div/main/section[1]");
    private static final SelenideElement MaterialsSection = $x("//*[@id=\"media\"]");
    private static final SelenideElement ContactsSection = $x("//*[@id=\"contacts\"]");
    private static final SelenideElement FooterSection = $x("//*[@id=\"root\"]/div/footer");

    //Новости платформы
    private static final SelenideElement News_Platform_1 = $x("//*[@id=\"news-platform\"]/div/div/div[1]/a/div/div[2]/div[1]");
    private static final SelenideElement News_Platform_2 = $x("//*[@id=\"news-platform\"]/div/div/div[2]/a/div/div[2]/div[1]");
    private static final SelenideElement News_Platform_3 = $x("//*[@id=\"news-platform\"]/div/div/div[3]/a/div/div[2]/div[1]");

    //Новости платформы
    private static final SelenideElement News_National_Project_1 = $x("//*[@id=\"news-project\"]/div/div/div[1]/a/div/div[2]/div[1]");
    private static final SelenideElement News_National_Project_2 = $x("//*[@id=\"news-project\"]/div/div/div[2]/a/div/div[2]/div[1]");
    private static final SelenideElement News_National_Project_3 = $x("//*[@id=\"news-project\"]/div/div/div[3]/a/div/div[2]/div[1]");

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
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");
    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }

    @Step("Создание скриншота секции 'Пресс-центр'")
    public void TakeScreenshotOfPressCenterSection(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/PC/Elements/PressCenterSection/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/phone/Elements/PressCenterSection/reference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(PressCenterSection, screenshotPath);
    }

    @Step("Создание скриншота секции 'Контакты'")
    public void TakeScreenshotOfMaterialsSection(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/PC/Elements/MaterialsSection/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/phone/Elements/MaterialsSection/reference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(MaterialsSection, screenshotPath);
    }

    @Step("Создание скриншота секции 'Контакты'")
    public void TakeScreenshotOfContactsSection(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/PC/Elements/ContactsSection/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/phone/Elements/ContactsSection/reference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(ContactsSection, screenshotPath);
    }

    @Step("Создание скриншота футера")
    public void TakeScreenshotOfFooterSection(String environment) throws IOException {
        String screenshotPath = null;
        sleep(2000);
        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/PC/Elements/FooterSection/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/phone/Elements/FooterSection/reference.png";
                break;
            case "tablet":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/PressCenterPage/tablet/Elements/FooterSection/reference.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfElement(FooterSection, screenshotPath);
    }

    @Step("Сравнение скриншотов кнопки 'Смотреть видео о платформе' до и после наведения")
    public boolean compareScreenshotsOfSection(String environment, String NameOfSection) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath =  String.format("src/test/resources/screenshots/PressCenterPage/PC/Elements/%s/current.png", NameOfSection);
                referencePath = String.format("src/test/resources/screenshots/PressCenterPage/PC/Elements/%s/reference.png", NameOfSection);
                resultPath = String.format("src/test/resources/screenshots/PressCenterPage/PC/Elements/%s/differences.png", NameOfSection);
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath =  String.format("src/test/resources/screenshots/PressCenterPage/phone/Elements/%s/current.png", NameOfSection);
                referencePath = String.format("src/test/resources/screenshots/PressCenterPage/phone/Elements/%s/reference.png", NameOfSection);
                resultPath = String.format("src/test/resources/screenshots/PressCenterPage/phone/Elements/%s/differences.png", NameOfSection);
                break;
            case "tablet":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath =  String.format("src/test/resources/screenshots/PressCenterPage/tablet/Elements/%s/current.png", NameOfSection);
                referencePath = String.format("src/test/resources/screenshots/PressCenterPage/tablet/Elements/%s/reference.png", NameOfSection);
                resultPath = String.format("src/test/resources/screenshots/PressCenterPage/tablet/Elements/%s/differences.png", NameOfSection);
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }


    @Step("Получить первый заголовок новостей платформы")
    public String getFirstLabelOfNewsPlatform(){
        return News_Platform_1.shouldBe(visible).getText();
    }

    @Step("Получить второй заголовок новостей платформы")
    public String getSecondLabelOfNewsPlatform(){
        return News_Platform_2.shouldBe(visible).getText();
    }

    @Step("Получить третий заголовок новостей платформы")
    public String getThirdLabelOfNewsPlatform(){
        return News_Platform_3.shouldBe(visible).getText();
    }


    @Step("Получить первый заголовок новостей нацпроекта")
    public String getFirstLabelOfNewsNationalProject(){
        return News_National_Project_1.shouldBe(visible).getText();
    }

    @Step("Получить второй заголовок новостей нацпроекта")
    public String getSecondLabelOfNewsNationalProject(){
        return News_National_Project_2.shouldBe(visible).getText();
    }

    @Step("Получить третий заголовок новостей нацпроекта")
    public String getThirdLabelOfNewsNationalProject(){
        return News_National_Project_3.shouldBe(visible).getText();
    }


    @Step("Получить данные новости платформы с API по заголовку: {title}")
    public Map<String, Object> getPlatformNewsDataFromApi(String title) {


        Response response = RestAssured.get("https://aksis.dev.qsupport.ru/api/PressCenter/GetNews?newsTypes=platformNews&pageSize=3");
        Assert.assertFalse(response.asString().isEmpty(), "Response is empty");

        List<Map<String, Object>> items = response.jsonPath().getList("items");
        Map<String, Object> newsData = items.stream()
                .filter(item -> title.equals(item.get("title")))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Информация не найдена для заголовка: " + title));

        newsData.put("date", ((String) newsData.get("date")).substring(0, 10));
        newsData.put("image", extractFileName((String) newsData.remove("imageUrl")));
        return newsData;
    }

    @Step("Получить данные новости платформы с API по заголовку: {title}")
    public Map<String, Object> getNationalProjectNewsDataFromApi(String title) {


        Response response = RestAssured.get("https://aksis.dev.qsupport.ru/api/PressCenter/GetNews?newsTypes=projectNews&pageSize=3");
        Assert.assertFalse(response.asString().isEmpty(), "Response is empty");

        List<Map<String, Object>> items = response.jsonPath().getList("items");
        Map<String, Object> newsData = items.stream()
                .filter(item -> title.equals(item.get("title")))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Информация не найдена для заголовка: " + title));

        newsData.put("date", ((String) newsData.get("date")).substring(0, 10));
        newsData.put("image", extractFileName((String) newsData.remove("imageUrl")));
        return newsData;
    }



    @Step("Получить информацию о новости из базы данных по ID: {contentItemId}")
    public Map<String, Object> getNewsFromDatabase(long contentItemId) throws SQLException {
        String query = "SELECT content_item_id, title, date, image FROM public.content_630 WHERE content_item_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, contentItemId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> newsData = new HashMap<>();
                    newsData.put("id", rs.getLong("content_item_id"));
                    newsData.put("title", rs.getString("title"));
                    newsData.put("date", rs.getString("date").substring(0, 10));
                    newsData.put("image", extractFileName(rs.getString("image")));
                    return newsData;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new AssertionError("News data not found for contentItemId: " + contentItemId);
    }


    private String extractFileName(String path) {
        if (path == null || path.isEmpty()) {
            return "";
        }
        String[] parts = path.split("/");
        String fileName = parts[parts.length - 1];
        return fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf('.')) : fileName;
    }


    @Step("Сравнить данные новости из базы данных и API")
    public void compareNewsData(Map<String, Object> dbNewsData, Map<String, Object> apiNewsData) {
        Assert.assertEquals(dbNewsData.size(), apiNewsData.size(), "Размер данных не совпадает");

        for (String key : dbNewsData.keySet()) {
            Assert.assertTrue(apiNewsData.containsKey(key), "Ключ " + key + " отсутствует в данных API");

            Object dbValue = dbNewsData.get(key);
            Object apiValue = apiNewsData.get(key);

            if (dbValue instanceof Number && apiValue instanceof Number) {
                Assert.assertEquals(((Number) dbValue).doubleValue(), ((Number) apiValue).doubleValue(), "Значение ключа " + key + " не совпадает");
            } else if (dbValue instanceof String && apiValue instanceof String) {
                Assert.assertEquals(dbValue, apiValue, "Значение ключа " + key + " не совпадает");
            } else {
                Assert.assertEquals(dbValue, apiValue, "Значение ключа " + key + " не совпадает");
            }
        }
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

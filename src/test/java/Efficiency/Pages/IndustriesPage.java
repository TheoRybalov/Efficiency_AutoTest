package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class IndustriesPage extends CommonFunctions {

    public static final SelenideElement ManufacturingIndustriesHeader = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[2]/div/a/div[2]/div[2]/div/p");
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");

    //Ссылки отраслей
    public static final SelenideElement SelskoeHozaystvoLink = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[1]/div/a");
    public static final SelenideElement SelskoeHozaystvoTitle = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[1]/div/a/div[2]/div[1]");
    public static final SelenideElement ManufactoringIndustriesLink = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[2]/div/a");
    public static final SelenideElement ManufactoringIndustriesTtle = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[2]/div/a/div[2]/div[1]");
    public static final SelenideElement ConstructionLink = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[3]/div/a");
    public static final SelenideElement ConstructionTitle = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[3]/div/a/div[2]/div[1]");
    public static final SelenideElement TradingLink = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[4]/div/a");
    public static final SelenideElement TradingTitle = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[4]/div/a/div[2]/div[1]");
    public static final SelenideElement TransportLink = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[5]/div/a");
    public static final SelenideElement TransportTitle = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[5]/div/a/div[2]/div[1]");

    @Step("Проверка совпадения описания для блока 'Обрабатывающая промышленность'")
    public void AssertionManufacturingIndustriesDescription(String desc){
        Assert.assertEquals(desc, ManufacturingIndustriesHeader.shouldBe(visible).getText(), "Видимый текст не совпадает с текстом в запросе");
    }

    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }


    //Получение скриншота полной страницы
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/industries/PC/current.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефон, то сохранение будет идти в эту папку
                screenshotPath = "src/test/resources/screenshots/industries/phone/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }

        //вызывается метод создания и сохранения такого скриншота, куда мы передаём путь до папки
        super.TakeScreenshotOfFullPage(screenshotPath);
    }


    public boolean compareScreenshotsOfFullPage(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                //Если мы получаем скриншот в кофигурации ПК, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/industries/PC/current.png";
                referencePath = "src/test/resources/screenshots/industries/PC/reference.png";
                resultPath = "src/test/resources/screenshots/industries/PC/differences.png";
                break;
            case "phone":
                //Если мы получаем скриншот в кофигурации телефона, то для сравнения current и reference нужно вытащить из этих папок
                screenshotPath = "src/test/resources/screenshots/industries/phone/current.png";
                referencePath = "src/test/resources/screenshots/industries/phone/reference.png";
                resultPath = "src/test/resources/screenshots/industries/phone/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        //вызывается сравнения скриншотов, куда мы передаём пути до папок
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }

    public String GetManufacturingIndustriesFromApi(String title){
        Response response = RestAssured.get("https://aksis.dev.qsupport.ru/api/Industry/GetDetailsIndustries?PageSize=12&PageNumber=0");
        Assert.assertFalse(response.asString().isEmpty(), "Response is empty");

        // Получаем JSON-ответ как Map
        List<Map<String, Object>> items = response.jsonPath().getList("items");

        // Ищем элемент с title "Обрабатывающая промышленность"
        Map<String, Object> industry = items.stream()
                .filter(item -> title.equals(item.get("title")))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Информация не найдена"));

        // Получаем описание из API
        String apiDescription = (String) industry.get("description");
        apiDescription = apiDescription.replaceAll("<p>|</p>", "");

        return apiDescription;
    }


    @Step("Проверка редиректа на элементе 'Сельское хозяйство'")
    public void SelskoeHozaystvoLink_Redirect(){
        Assert.assertEquals(SelskoeHozaystvoTitle.getText(), "Сельское хозяйство", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(SelskoeHozaystvoLink, "https://aksis.dev.qsupport.ru/industries/selskoye-hozaystvo");
    }

    @Step("Проверка редиректа на элементе 'Обрабатывающая промышленность'")
    public void ManufactoringIndustriesLink_Redirect(){
        Assert.assertEquals(ManufactoringIndustriesTtle.getText(), "Обрабатывающая промышленность", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ManufactoringIndustriesLink, "https://aksis.dev.qsupport.ru/industries/manufacturing-industries");
    }

    @Step("Проверка редиректа на элементе 'Строительство'")
    public void ConstructionLink_Redirect(){
        Assert.assertEquals(ConstructionTitle.getText(), "Строительство", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ConstructionLink, "https://aksis.dev.qsupport.ru/industries/construction");
    }

    @Step("Проверка редиректа на элементе 'Торговля'")
    public void TradingLink_Redirect(){
        Assert.assertEquals(TradingTitle.getText(), "Торговля", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(TradingLink, "https://aksis.dev.qsupport.ru/industries/trading");
    }

    @Step("Проверка редиректа на элементе 'Транспортировка и хранение'")
    public void TransportLink_Redirect(){
        Assert.assertEquals(TransportTitle.getText(), "Транспортировка и хранение", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(TransportLink, "https://aksis.dev.qsupport.ru/industries/transport");
    }





}

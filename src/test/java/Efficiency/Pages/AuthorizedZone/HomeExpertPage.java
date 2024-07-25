package Efficiency.Pages.AuthorizedZone;

import Efficiency.AuthorizedCommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomeExpertPage extends AuthorizedCommonFunctions {

    private static final SelenideElement Solutions_Showcase_Header = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[1]/span");
    private static final SelenideElement Solutions_Showcase_Text = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[2]/dl/dt");
    private static final SelenideElement Solutions_Showcase_Href = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[1]/a");
    private static final SelenideElement Solutions_Showcase_Quantity = $x("//*[@id=\"root\"]/div/div[2]/main/div/div/div[1]/div[4]/div/div[2]/dl/dd");
    private Map<String, Object> SolutionsWidgetData = new HashMap<>();

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

    @Step("Проверка корректности ссылки виджета Диагностика")
    public void Assert_MyFeed_Solutions_Href(){
        String actualTitle = Solutions_Showcase_Href.getAttribute("href");
        String expectedTitle = (String) SolutionsWidgetData.get("errorhref");
        Assert.assertEquals(actualTitle, expectedTitle, "Ссылка не соответствует ожидаемому значению.");
    }

    @Step("Проверка корректности общего количества решений в виджете Витрина решений")
    public void Assert_MyFeed_Solutions_Quantity(){
        Solutions_Showcase_Quantity.scrollTo().shouldBe(visible);
        int actualQuantity = Integer.parseInt(Solutions_Showcase_Quantity.getText());
        int expectedQuantity = (int) SolutionsWidgetData.get("totalCount");

        Assert.assertEquals(actualQuantity, expectedQuantity, "Общее количество решений не соответствует ожидаемому значению.");
    }
}

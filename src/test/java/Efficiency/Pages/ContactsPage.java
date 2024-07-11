package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.restassured.RestAssured.given;

public class ContactsPage extends CommonFunctions {
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");
    public static final SelenideElement NameField = $x("//*[@id=\"name\"]");
    public static final SelenideElement NameFieldNecessary = $x("//*[@id=\"feedback\"]/div/div/div/form/div/div[1]/div/div");
    public static final SelenideElement CityField = $x("//*[@id=\"location\"]");
    public static final SelenideElement CityFieldNecessary = $x("//*[@id=\"feedback\"]/div/div/div/form/div/div[2]/div/div");
    public static final SelenideElement PhoneField = $x("//*[@id=\"tel\"]");
    public static final SelenideElement PhoneFieldNecessary = $x("//*[@id=\"feedback\"]/div/div/div/form/div/div[3]/div/div");
    public static final SelenideElement EmailField = $x("//*[@id=\"email\"]");
    public static final SelenideElement EmailFieldNecessary = $x("//*[@id=\"feedback\"]/div/div/div/form/div/div[4]/div/div");
    public static final SelenideElement MessageField = $x("//*[@id=\"message\"]");
    public static final SelenideElement MessageFieldNecessary = $x("//*[@id=\"feedback\"]/div/div/div/form/div/div[5]/div/div");

    @Step("Проверка поля имени на обязательность")
    public void CheckNameFieldNecessary(){
        NameField.scrollTo().click();
        CityField.click();
        Assert.assertEquals(NameFieldNecessary.getText(), "Поле обязательно", "Текст элемента не соответствует заданному");
        NameFieldNecessary.shouldBe(visible);
    }

    @Step("Проверка поля города на обязательность")
    public void CheckCityFieldNecessary(){
        CityField.scrollTo().click();
        PhoneField.click();
        Assert.assertEquals(CityFieldNecessary.getText(), "Поле обязательно", "Текст элемента не соответствует заданному");
        CityFieldNecessary.shouldBe(visible);
    }

    @Step("Проверка поля телефон на обязательность")
    public void CheckPhoneFieldNecessary(){
        PhoneField.scrollTo().click();
        CityField.click();
        Assert.assertEquals(PhoneFieldNecessary.getText(), "Поле обязательно", "Текст элемента не соответствует заданному");
        PhoneFieldNecessary.shouldBe(visible);
    }

    @Step("Проверка поля электронная почта на обязательность")
    public void CheckEmailFieldNecessary(){
        EmailField.scrollTo().click();
        CityField.click();
        Assert.assertEquals(EmailFieldNecessary.getText(), "Поле обязательно", "Текст элемента не соответствует заданному");
        EmailFieldNecessary.shouldBe(visible);
    }

    @Step("Проверка поля сообщение на обязательность")
    public void CheckMessageFieldNecessary(){
        MessageField.scrollTo().click();
        EmailField.click();
        Assert.assertEquals(MessageFieldNecessary.getText(), "Поле обязательно", "Текст элемента не соответствует заданному");
        MessageFieldNecessary.shouldBe(visible);
    }

    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }

    @Step("Создание скриншота всей страницы")
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;
        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/current.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/current.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/tablet/FullPage/current.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        super.TakeScreenshotOfFullPage(screenshotPath);
    }
    public boolean compareScreenshotsOfFullPage(String environment) throws IOException{
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;

        switch (environment) {
            case "PC":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ContactsPage/PC/FullPage/differences.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ContactsPage/phone/FullPage/differences.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/ContactsPage/tablet/FullPage/current.png";
                referencePath = "src/test/resources/screenshots/ContactsPage/tablet/FullPage/reference.png";
                resultPath = "src/test/resources/screenshots/ContactsPage/tablet/FullPage/differences.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);
        }
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);
    }


    @Step("Принимаем куки")
    public void SendFeedback() {
        RestAssured.baseURI = "https://aksis.dev.qsupport.ru";
        String feedbackJson = super.generateRandomFeedbackJson();

        Response response = given()
                .header("Content-Type", "application/json")
                .body(feedbackJson)
                .when()
                .post("/api/Contacts/SendFeedback");

        response.then().statusCode(200);
    }

}

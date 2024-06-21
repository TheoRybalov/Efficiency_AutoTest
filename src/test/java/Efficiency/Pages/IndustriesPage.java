package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.openqa.selenium.JavascriptExecutor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class IndustriesPage extends CommonFunctions {

    public static final SelenideElement ManufacturingIndustriesHeader = $x("//*[@id=\"root\"]/div/main/div/section[1]/div/div[2]/div/a/div[2]/div[2]/div/p");
    public static final SelenideElement CookieButton = $x("//*[@id=\"rcc-confirm-button\"]");



    @Step("Проверка совпадения описания для блока 'Обрабатывающая промышленность'")
    public void AssertionManufacturingIndustriesDescription(String desc){
        Assert.assertEquals(desc, ManufacturingIndustriesHeader.shouldBe(visible).getText(), "Видимый текст не совпадает с текстом в запросе");
    }

    @Step("Принимаем куки")
    public void AddCookies(){
        CookieButton.shouldBe(visible).click();
    }



    public void TakeScreenshotOfFullPage() throws IOException {
        String screenshotPath = "src/test/resources/screenshots/industries/current.png";
        super.TakeScreenshotOfFullPage(screenshotPath);
    }


    public boolean compareScreenshots() throws IOException{
        String screenshotPath = "src/test/resources/screenshots/industries/current.png";
        String referencePath = "src/test/resources/screenshots/reference.png";
        return super.compareScreenshots(screenshotPath, referencePath);
    }





}

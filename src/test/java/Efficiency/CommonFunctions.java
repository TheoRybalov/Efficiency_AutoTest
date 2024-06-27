package Efficiency;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommonFunctions {
    protected static final String DB_URL = System.getenv()
            .getOrDefault("DB_URL", "jdbc:postgresql://172.16.4.238/minpromtorg_catalog");
    protected static final String DB_USER = System.getenv()
            .getOrDefault("DB_USER", "postgres");
    protected static final String DB_PASSWORD = System.getenv()
            .getOrDefault("DB_PASSWORD", "1q2w-p=[");


    public void TakeScreenshotOfFullPage(String screenshotPath) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.body.style.overflow = 'hidden';");


        Screenshot fullPageScreenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(WebDriverRunner.getWebDriver());

        BufferedImage screenshotImage = fullPageScreenshot.getImage();

        File screenshotFile = new File(screenshotPath);
        screenshotFile.getParentFile().mkdirs();
        ImageIO.write(screenshotImage, "PNG", screenshotFile);

        js.executeScript("document.body.style.overflow = 'auto';");
    }

    public void TakeScreenshotOfElement(SelenideElement element, String screenshotPath) throws IOException {
        WebDriver driver = WebDriverRunner.getWebDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("document.body.style.overflow = 'hidden';");

        File screenshotFile = element.screenshot();

        BufferedImage fullImg = ImageIO.read(screenshotFile);

        File outputFile = new File(screenshotPath);
        outputFile.getParentFile().mkdirs();

        ImageIO.write(fullImg, "PNG", outputFile);

        js.executeScript("document.body.style.overflow = 'auto';");
    }


    public boolean compareScreenshots(String screenshotPath, String referencePath, String resultPath) throws IOException {

        BufferedImage currentPageImage = ImageComparisonUtil.readImageFromResources(screenshotPath);
        BufferedImage referencePageImage = ImageComparisonUtil.readImageFromResources(referencePath);

        File resultDestination = new File(resultPath);
        resultDestination.getParentFile().mkdirs();
        ImageComparison imageComparison = new ImageComparison(currentPageImage, referencePageImage, resultDestination);
        imageComparison.setThreshold(10);

        ImageComparisonResult result = imageComparison.compareImages();

        return result.getDifferencePercent() <= imageComparison.getThreshold();


    }

    public void AssertionCompareScreenshots(Boolean result){
        Assert.assertTrue(result, "Найдены различия в файлах");
    }

    public void Check_Redirect_By_Link(SelenideElement link, String ExpectedUrl){
        link.scrollTo().shouldBe(visible).click();
        String ActualUrl = url();
        Assert. assertEquals(ExpectedUrl, ActualUrl, "Ссылки не совпадают, редирект не корректен");
        back();
    }

    public void Check_RedirectToOtherTab_By_Link(SelenideElement link, String ExpectedUrl){
        String originalWindow = webdriver().object().getWindowHandle();

        link.scrollTo().shouldBe(visible).click();
        ArrayList<String> tabs = new ArrayList<>(webdriver().object().getWindowHandles());
        switchTo().window(tabs.get(1));

        String ActualUrl = url();
        Assert. assertEquals(ExpectedUrl, ActualUrl, "Ссылки не совпадают, редирект не корректен");

        closeWindow();
        switchTo().window(originalWindow);
    }

}

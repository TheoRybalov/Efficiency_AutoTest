package Efficiency;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.restassured.RestAssured.given;

public class CommonFunctions {
    protected static final String DB_URL = System.getenv()
            .getOrDefault("DB_URL", "jdbc:postgresql://172.16.4.238/minpromtorg_catalog");
    protected static final String DB_URL_MINPROMTORG = System.getenv()
            .getOrDefault("DB_URL", "jdbc:postgresql://172.16.4.238/minpromtorg");
    protected static final String DB_USER = System.getenv()
            .getOrDefault("DB_USER", "postgres");
    protected static final String DB_PASSWORD = System.getenv()
            .getOrDefault("DB_PASSWORD", "1q2w-p=[");


    @Step("Получить информацию о виджете из базы данных")
    public Map<String, Object> getDataFromDB(String tableName, String contentItemId) throws SQLException {

        String query = "SELECT * FROM " + tableName + " WHERE content_item_id = " + contentItemId;
        Map<String, Object> WidgetDataQP = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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

    public void CheckDownloadedByLinkFile(SelenideElement link, String expectedFileName){
        sleep(2000);
        link.scrollTo().click();
        String downloadDir = System.getProperty("user.dir");
        downloadDir = downloadDir + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "pdf" + File.separator + expectedFileName;
        File downloadedFile = new File(downloadDir);
        int attempts = 0;
        while (attempts < 20) {
            if (downloadedFile.exists() && !new File(downloadDir + ".crdownload").exists()) {
                break;
            }
            sleep(1000);
            attempts++;
        }

        Assert.assertTrue(downloadedFile.exists(), "Файл не был скачан!");
        downloadedFile.delete();
    }
    public String generateRandomFeedbackJson() {
        String randomName = RandomStringUtils.randomAlphabetic(10);
        String randomCity = RandomStringUtils.randomAlphabetic(8);
        String randomPhone = "8" + RandomStringUtils.randomNumeric(10);
        String randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@mail.com";
        String randomMessage = RandomStringUtils.randomAlphabetic(20);

        return "{"
                + "\"name\":\"" + randomName + "\","
                + "\"city\":\"" + randomCity + "\","
                + "\"phone\":\"" + randomPhone + "\","
                + "\"email\":\"" + randomEmail + "\","
                + "\"message\":\"" + randomMessage + "\""
                + "}";
    }
    public void TakeScreenshotOfFullPage(String screenshotPath) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.body.style.overflow = 'hidden';");


        sleep(2000);

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
        sleep(4000);
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

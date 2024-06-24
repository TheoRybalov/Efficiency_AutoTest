package Efficiency;

import com.codeborne.selenide.WebDriverRunner;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommonFunctions {

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


}

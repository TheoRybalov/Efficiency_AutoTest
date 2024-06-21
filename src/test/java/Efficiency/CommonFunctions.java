package Efficiency;

import com.codeborne.selenide.WebDriverRunner;
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

    public boolean compareScreenshots(String screenshotPath, String referencePath) throws IOException {
        BufferedImage currentPageImage = ImageIO.read(new File(screenshotPath));
        BufferedImage referencePageImage = ImageIO.read(new File(referencePath));
        if (currentPageImage.getWidth() != referencePageImage.getWidth() || currentPageImage.getHeight() != referencePageImage.getHeight()) {
            return true;
        }
        for (int y = 0; y < currentPageImage.getHeight(); y++) {
            for (int x = 0; x < currentPageImage.getWidth(); x++) {
                if (currentPageImage.getRGB(x, y) != referencePageImage.getRGB(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void AssertionCompareScreenshots(Boolean result){
        Assert.assertFalse(result, "Найдены различия в файлах");
    }


}

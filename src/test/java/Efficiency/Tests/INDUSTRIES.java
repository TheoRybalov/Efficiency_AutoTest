package Efficiency.Tests;

import Efficiency.Pages.IndustriesPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class INDUSTRIES extends TestBase {

    @Test(priority = 1, description = "Отрасли. Проверка данных на плитках")
    public void PlatesCorrectData_TEST(){
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        String Desc_From_API = industriesPage.GetManufacturingIndustriesFromApi("Обрабатывающая промышленность");
        industriesPage.AssertionManufacturingIndustriesDescription(Desc_From_API);
    }

    @Test(priority = 11, description = "Отрасли. Сравнение вёрстки по скриншотам")
    public void MarkupScreenShot_TEST() throws IOException {
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        industriesPage.AddCookies();
        industriesPage.TakeScreenshotOfFullPage();
        Boolean result_of_comparing = industriesPage.compareScreenshots();
        industriesPage.AssertionCompareScreenshots(result_of_comparing);
    }



}

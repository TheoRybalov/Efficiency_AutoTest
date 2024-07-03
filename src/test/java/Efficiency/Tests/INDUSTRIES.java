package Efficiency.Tests;

import Efficiency.Pages.IndustriesPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class INDUSTRIES extends TestBase {

    //для метода MarkupScreenshot мы должны получать окружение
    public String getEnvironment(){
        return super.getEnv();
    }

    @Test(priority = 1, description = "Отрасли. Проверка данных на плитках")
    public void PlatesCorrectData_TEST(){
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        String Desc_From_API = industriesPage.GetManufacturingIndustriesFromApi("Обрабатывающая промышленность");
        industriesPage.AssertionManufacturingIndustriesDescription(Desc_From_API);
    }

    @Test(priority = 2, description = "Отрасли. Сравнение вёрстки по скриншотам")
    public void MarkupScreenShot_TEST() throws IOException {
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        industriesPage.AddCookies();
        industriesPage.TakeScreenshotOfFullPage(getEnvironment());
        Boolean result_of_comparing = industriesPage.compareScreenshotsOfFullPage(getEnvironment());
        industriesPage.AssertionCompareScreenshots(result_of_comparing);
    }

    @Test(priority = 3, description = "Отрасли. Проверка редиректов")
    public void Industries_Redirects() throws IOException {
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        industriesPage.SelskoeHozaystvoLink_Redirect();
        industriesPage.ManufactoringIndustriesLink_Redirect();
        industriesPage.ConstructionLink_Redirect();
        industriesPage.TradingLink_Redirect();
        industriesPage.TransportLink_Redirect();
    }

}

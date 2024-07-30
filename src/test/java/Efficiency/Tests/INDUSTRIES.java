package Efficiency.Tests;

import Efficiency.Pages.IndustriesPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class INDUSTRIES extends TestBase {

    //для метода MarkupScreenshot мы должны получать окружение
    public String getEnvironment(){
        return super.getEnv();
    }

    @Test(priority = 2, description = "Отрасли. Сравнение вёрстки по скриншотам")
    public void MarkupScreenShot_TEST() throws IOException {
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        industriesPage.AddCookies();
        industriesPage.TakeScreenshotOfFullPage(getEnvironment());
        Boolean result_of_comparing = industriesPage.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
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

    @Test(priority = 4,description = "Проверка карусели")
    public void Partners_Carousel() throws IOException{
        IndustriesPage industriesPage = open(ConfigProviderInterface.industriesURL, IndustriesPage.class);
        industriesPage.checkBanners();
    }

}

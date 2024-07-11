package Efficiency.Tests;

import Efficiency.Pages.ServicesPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class SERVICES extends TestBase {

    public String getEnvironment() {return super.getEnv();}

//    @Test(priority = 1, description = "Страница 'Сервисы'. Сравнение верстки по скриншотам")
//    public void MarkupScreenshot_TEST() throws IOException {
//        ServicesPage services = open(ConfigProviderInterface.servicesURL, ServicesPage.class);
//        services.AcceptCookie();
//        services.TakeScreenshotOfFullPage(getEnvironment());
//        Boolean result_ofComparing = services.CompareScreenshotsOfFullPage(getEnvironment());
//        services.AssertionCompareScreenshots(result_ofComparing);
//    }
}
